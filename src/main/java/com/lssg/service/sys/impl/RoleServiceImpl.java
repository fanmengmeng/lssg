package com.lssg.service.sys.impl;

import java.util.*;

import com.github.pagehelper.PageHelper;
import com.lssg.dao.sys.RoleMapper;
import com.lssg.dao.sys.RoleMenuMapper;
import com.lssg.dao.sys.UserRoleMapper;
import com.lssg.model.sys.*;
import com.lssg.service.iservice.impl.BaseService;
import com.lssg.service.sys.RoleMenuServie;
import com.lssg.service.sys.RoleService;
import com.lssg.service.sys.UserRoleService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleMenuServie roleMenuService;

    @Override
    public List<Role> findUserRole(String userName) {
        return this.roleMapper.findUserRole(userName);
    }

    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoleAll();
    }

    @Override
    public Map<String, Object> selectByPage(int pageNumber, int pageSize) {
        Map<String, Object> result = new HashMap<String, Object>();
        int total = roleMapper.roleTotal();
        // 分页查询
        PageHelper.startPage(pageNumber, pageSize);
        List<Role> rows = roleMapper.getRoleAll();
        result.put("total", total);
        result.put("rows", rows);
        return result;
    }

    @Override
    public Role findByName(String roleName) {
        Example example = new Example(Role.class);
        example.createCriteria().andCondition("lower(role_name)=", roleName.toLowerCase());
        List<Role> list = this.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    @Transactional
    public void addRole(Role role, Integer[] menuIds) {
        User user1 = (User) SecurityUtils.getSubject().getPrincipal();
        role.setCreatetime(new Date());
        role.setCreateuser(user1.getUsername());
        roleMapper.insertRole(role);
        setRoleMenus(role, menuIds);
    }

    private void setRoleMenus(Role role, Integer[] menuIds) {
        Arrays.stream(menuIds).forEach(menuId -> {
            RoleMenu rm = new RoleMenu();
            rm.setMenuid(menuId);
            rm.setRoleid(role.getId());
            this.roleMenuMapper.insert(rm);
        });
    }

    @Override
    @Transactional
    public void batchDeleteRole(Integer[] roleIds) {
        roleMapper.batchDeleteRole(roleIds);

        roleMenuService.deleteRoleMenusByRoleId(roleIds);
        userRoleService.deleteUserRolesByUserId(roleIds);

    }

    @Override
    public RoleWithMenu findRoleWithMenus(Integer roleId) {
        List<RoleWithMenu> list = this.roleMapper.findById(roleId);
        List<Integer> menuList = new ArrayList<>();
        for (RoleWithMenu rwm : list) {
            menuList.add(rwm.getMenuid());
        }
        if (list.isEmpty()) {
            return null;
        }
        RoleWithMenu roleWithMenu = list.get(0);
        roleWithMenu.setMenuids(menuList);
        return roleWithMenu;
    }

    @Override
    @Transactional
    public void updateRole(Role role, Integer[] menuIds) {
        role.setUpdatetime(new Date());
        this.updateNotNull(role);
        Example example = new Example(RoleMenu.class);
        example.createCriteria().andCondition("role_id=", role.getId());
        this.roleMenuMapper.deleteByExample(example);
        setRoleMenus(role, menuIds);
    }

}
