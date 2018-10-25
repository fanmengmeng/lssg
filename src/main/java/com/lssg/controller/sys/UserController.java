package com.lssg.controller.sys;

import java.util.List;
import java.util.Map;

import com.lssg.common.util.FileUtils;
import com.lssg.model.sys.Role;
import com.lssg.model.sys.User;
import com.lssg.pojo.ResponseBo;
import com.lssg.common.util.MD5Utils;
import com.lssg.controller.common.BaseController;
import com.lssg.service.sys.RoleService;
import com.lssg.service.sys.UserService;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private static final String ON = "on";

    /**
     * 用户列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/user")
    @RequiresPermissions("user/list")
    public String index(Model model) {

        return "system/user/userlist";
    }


    /**
     * 获得当前登陆的用户
     * @return
     */
    @PostMapping("/user/getCurrentUser")
    public User getCurrentUser() {
        User user = super.getCurrentUser();
        return user;
    }

    /**
     * 新增用户
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/add")
    @RequiresPermissions("user/add")
    public String addUser(Model model) {
        List<Role> roleList = roleService.getRoleList();
        model.addAttribute("roleList", roleList);
        return "system/user/userAdd";

    }

    @RequestMapping("/user/checkUserName")
    @ResponseBody
    public boolean checkUserName(String username, String oldusername) {
        if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
            return true;
        }
        User result = this.userService.findByName(username);
        return result == null;
    }

    @RequestMapping("/user/getUser")
    @ResponseBody
    public ResponseBo getUser(Integer userId) {
        try {
            User user = this.userService.findById(userId);
            return ResponseBo.ok(user);
        } catch (Exception e) {
            log.error("获取用户失败", e);
            return ResponseBo.error("获取用户失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/user/list")
    @ResponseBody
    public Map<String, Object> userList(int pageNumber, int pageSize) {

        return userService.selectByPage(pageNumber, pageSize);
    }


    @PostMapping("/user/save")
    @ResponseBody
    public ResponseBo addUser(User user, Integer[] roles, Integer[] infos) {
        try {
            if (ON.equalsIgnoreCase(user.getStatus()))
                user.setStatus(User.STATUS_VALID);
            else
                user.setStatus(User.STATUS_LOCK);
            this.userService.addUser(user, roles, infos);
            return ResponseBo.ok("新增用户成功！");
        } catch (Exception e) {
            log.error("新增用户失败", e);
            return ResponseBo.error("新增用户失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("user:update")
    @RequestMapping("/user/update")
    @ResponseBody
    public ResponseBo updateUser(User user, Integer[] rolesSelect) {
        try {
            if (ON.equalsIgnoreCase(user.getStatus()))
                user.setStatus(User.STATUS_VALID);
            else
                user.setStatus(User.STATUS_LOCK);
            this.userService.updateUser(user, rolesSelect);
            return ResponseBo.ok("修改用户成功！");
        } catch (Exception e) {
            log.error("修改用户失败", e);
            return ResponseBo.error("修改用户失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("user/delete")
    @RequestMapping("/user/delete")
    @ResponseBody
    public ResponseBo deleteUsers(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
            String[] str = request.getParameter("ids").split(",");
            //将String数组转成Integer数组
            Integer[] userIds = (Integer[]) ConvertUtils.convert(str, Integer.class);
            System.out.println(userIds);
            this.userService.deleteUsers(userIds);
            return ResponseBo.ok("删除用户成功！");
        } catch (Exception e) {
            log.error("删除用户失败", e);
            return ResponseBo.error("删除用户失败，请联系网站管理员！");
        }
    }

    @RequestMapping("user/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password) {
        User user = getCurrentUser();
        String encrypt = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
        return user.getPassword().equals(encrypt);
    }

    @RequestMapping("/user/updatePassword")
    @ResponseBody
    public ResponseBo updatePassword(String newPassword) {
        try {
            this.userService.updatePassword(newPassword);
            return ResponseBo.ok("更改密码成功！");
        } catch (Exception e) {
            log.error("修改密码失败", e);
            return ResponseBo.error("更改密码失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/user/profile")
    public String profileIndex(Model model) {
        User user = super.getCurrentUser();
        user = this.userService.findUserProfile(user);
        String ssex = user.getSsex();
        if (User.SEX_MALE.equals(ssex)) {
            user.setSsex("性别：男");
        } else if (User.SEX_FEMALE.equals(ssex)) {
            user.setSsex("性别：女");
        } else {
            user.setSsex("性别：保密");
        }
        model.addAttribute("user", user);
        return "system/user/profile";
    }

    @RequestMapping("/user/getUserProfile")
    @ResponseBody
    public ResponseBo getUserProfile(Integer userId) {
        try {
            User user = new User();
            user.setId(userId);
            return ResponseBo.ok(this.userService.findUserProfile(user));
        } catch (Exception e) {
            log.error("获取用户信息失败", e);
            return ResponseBo.error("获取用户信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/user/updateUserProfile")
    @ResponseBody
    public ResponseBo updateUserProfile(User user) {
        try {
            this.userService.updateUserProfile(user);
            return ResponseBo.ok("更新个人信息成功！");
        } catch (Exception e) {
            log.error("更新用户信息失败", e);
            return ResponseBo.error("更新用户信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/user/changeAvatar")
    @ResponseBody
    public ResponseBo changeAvatar(String imgName) {
        try {
            String[] img = imgName.split("/");
            String realImgName = img[img.length - 1];
            User user = getCurrentUser();
            user.setAvatar(realImgName);
            this.userService.updateNotNull(user);
            return ResponseBo.ok("更新头像成功！");
        } catch (Exception e) {
            log.error("更换头像失败", e);
            return ResponseBo.error("更新头像失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/user/excel")
    @ResponseBody
    public ResponseBo userExcel() {
        try {
            List<User> list = this.userService.findUser();
            return FileUtils.createExcelByPOIKit("用户表", list, User.class);
        } catch (Exception e) {
            log.error("导出用户信息Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

}
