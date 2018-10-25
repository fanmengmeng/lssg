package com.lssg.service.sys.impl;

import java.util.*;

import com.github.pagehelper.PageHelper;
import com.lssg.common.util.MD5Utils;
import com.lssg.dao.sys.UserInfoMapper;
import com.lssg.dao.sys.UserMapper;
import com.lssg.dao.sys.UserRoleMapper;
import com.lssg.model.sys.User;
import com.lssg.model.sys.UserInfo;
import com.lssg.model.sys.UserRole;
import com.lssg.model.sys.UserWithRole;
import com.lssg.service.iservice.impl.BaseService;
import com.lssg.service.sys.UserRoleService;
import com.lssg.service.sys.UserService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

import javax.security.auth.Subject;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseService<User> implements UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRoleService userRoleService;


    @Override
    public List<User> findUser() {
        try {
            return this.userMapper.getUserAll();
        } catch (Exception e) {
            log.error("error", e);
            return new ArrayList<>();
        }
    }


    @Override
    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        List<User> list = this.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 查询所有的用户
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> selectByPage(int pageNumber, int pageSize) {
        Map<String, Object> result = new HashMap<String, Object>();
        int total = userMapper.userTotal();
        // 分页查询
        PageHelper.startPage(pageNumber, pageSize);
        List<User> rows = userMapper.getUserAll();
        result.put("total", total);
        result.put("rows", rows);
        return result;
    }

    @Override
    @Transactional
    public void addUser(User user, Integer[] roles,Integer[] infos) {
        User user1 = (User) SecurityUtils.getSubject().getPrincipal();
        user.setCreatetime(new Date());
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        user.setCreateuser(user1.getUsername());
        userMapper.insertUser(user);
        setUserRoles(user, roles);

    }

    private void setUserRoles(User user, Integer[] roles) {
        Arrays.stream(roles).forEach(roleid -> {
            UserRole ur = new UserRole();
            ur.setUserid(user.getId());
            ur.setRoleid(roleid);
            this.userRoleMapper.insert(ur);
        });
    }

    private void setUserInfos(User user, Integer[] infos) {
        Arrays.stream(infos).forEach(projectid -> {
            UserInfo ui = new UserInfo();
            ui.setUserid(user.getId());
            ui.setProjectid(projectid);
            this.userInfoMapper.insert(ui);
        });
    }

    @Override
    @Transactional
    public void updateUser(User user, Integer[] roles) {
        user.setPassword(null);
        user.setUsername(null);
        user.setUpdatetime(new Date());
        this.updateNotNull(user);
        Example example = new Example(UserRole.class);
        example.createCriteria().andCondition("user_id=", user.getId());
        this.userRoleMapper.deleteByExample(example);
        setUserRoles(user, roles);
    }

    @Override
    @Transactional
    public void deleteUsers(Integer[] userIds) {
        userMapper.batchDeleteUser(userIds);


        userRoleMapper.deleteUserRolesByUserId(userIds);
    }

    @Override
    @Transactional
    public void updateLoginTime(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        User user = new User();
        user.setLastlogintime(new Date());
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Override
    @Transactional
    public void updatePassword(String password) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", user.getUsername());
        String newPassword = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
        user.setPassword(newPassword);
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Override
    public UserWithRole findById(Integer userId) {
        List<UserWithRole> list = this.userMapper.findUserWithRole(userId);
        List<Integer> roleList = new ArrayList<>();
        for (UserWithRole uwr : list) {
            roleList.add(uwr.getRoleid());
        }
        if (list.isEmpty()) {
            return null;
        }
        UserWithRole userWithRole = list.get(0);
        userWithRole.setRoleids(roleList);
        return userWithRole;
    }

    @Override
    public User findUserProfile(User user) {
        return this.userMapper.findUserProfile(user);
    }

    @Override
    @Transactional
    public void updateUserProfile(User user) {
        user.setUsername(null);
        user.setPassword(null);
        this.updateNotNull(user);
    }

}
