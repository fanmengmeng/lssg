package com.lssg.dao.sys;

import java.util.List;

import com.lssg.common.config.MyMapper;
import com.lssg.model.sys.Role;
import com.lssg.model.sys.RoleWithMenu;
import com.lssg.model.sys.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends MyMapper<Role> {

	int roleTotal();

	List<Role> getRoleAll();

	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Integer roleId);

	void batchDeleteRole(Integer[] roleIds);

	int insertRole(Role role);
}