package com.lssg.controller.sys;

import java.util.List;
import java.util.Map;

import com.lssg.common.util.FileUtils;
import com.lssg.model.sys.Role;
import com.lssg.pojo.QueryRequest;
import com.lssg.pojo.ResponseBo;
import com.lssg.controller.common.BaseController;
import com.lssg.service.sys.RoleService;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoleController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    @RequestMapping("/role")
    @RequiresPermissions("role/list")
    public String index() {
        return "system/role/rolelist";
    }

    @RequestMapping("/role/add")
    @RequiresPermissions("role/add")
    public String addRole() {
        return "system/role/roleAdd";
    }

    /**
     * 角色列表
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @PostMapping("/role/list")
    @ResponseBody
    public Map<String, Object> roleList(int pageNumber,int pageSize) {

        return roleService.selectByPage(pageNumber,pageSize);
    }

    /**
     * 获取角色信息
     * @return
     */
    @PostMapping("/role/roles")
    @ResponseBody
    public List<Role> roleList() {

        return roleService.getRoleList();
    }

    @RequestMapping("/role/getRole")
    @ResponseBody
    public ResponseBo getRole(Integer roleId) {
        try {
            Role role = this.roleService.findRoleWithMenus(roleId);
            return ResponseBo.ok(role);
        } catch (Exception e) {
            log.error("获取角色信息失败", e);
            return ResponseBo.error("获取角色信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/role/checkRoleName")
    @ResponseBody
    public boolean checkRoleName(String roleName, String oldRoleName) {
        if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
            return true;
        }
        Role result = this.roleService.findByName(roleName);
        return result == null;
    }


    @RequestMapping("/role/save")
    @ResponseBody
    public ResponseBo addRole(Role role, Integer[] menuId) {
        try {
            this.roleService.addRole(role, menuId);
            return ResponseBo.ok("新增角色成功！");
        } catch (Exception e) {
            log.error("新增角色失败", e);
            return ResponseBo.error("新增角色失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("role/delete")
    @RequestMapping("/role/delete")
    @ResponseBody
    public ResponseBo deleteRoles(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
            String[] str = request.getParameter("ids").split(",");
            //将String数组转成Integer数组
            Integer[] roleIds = (Integer[])ConvertUtils.convert(str, Integer.class);
            this.roleService.batchDeleteRole(roleIds);
            return ResponseBo.ok("删除角色成功！");
        } catch (Exception e) {
            log.error("删除角色失败", e);
            return ResponseBo.error("删除角色失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("role:update")
    @RequestMapping("/update")
    @ResponseBody
    public ResponseBo updateRole(Role role, Integer[] menuId) {
        try {
            this.roleService.updateRole(role, menuId);
            return ResponseBo.ok("修改角色成功！");
        } catch (Exception e) {
            log.error("修改角色失败", e);
            return ResponseBo.error("修改角色失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/role/excel")
    @ResponseBody
    public ResponseBo roleExcel() {
        try {
            List<Role> list = this.roleService.getRoleList();
            return FileUtils.createExcelByPOIKit("角色表", list, Role.class);
        } catch (Exception e) {
            log.error("导出角色信息Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }
}
