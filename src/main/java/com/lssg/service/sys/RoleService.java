package com.lssg.service.sys;

import com.lssg.model.sys.Role;
import com.lssg.model.sys.RoleWithMenu;
import com.lssg.service.iservice.IService;

import java.util.List;
import java.util.Map;


public interface RoleService extends IService<Role> {

	List<Role> findUserRole(String userName);

	List<Role> getRoleList();

	Map<String, Object> selectByPage(int pageNumber, int pageSize);
	
	RoleWithMenu findRoleWithMenus(Integer roleId);

	Role findByName(String roleName);

	void addRole(Role role, Integer[] menuIds);
	
	void updateRole(Role role, Integer[] menuIds);

	void batchDeleteRole(Integer[] roleIds);
}
