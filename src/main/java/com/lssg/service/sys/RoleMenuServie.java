package com.lssg.service.sys;

import com.lssg.model.sys.RoleMenu;
import com.lssg.service.iservice.IService;

public interface RoleMenuServie extends IService<RoleMenu> {

	void deleteRoleMenusByRoleId(Integer[] roleIds);

	void deleteRoleMenusByMenuId(Integer[] menuIds);
}
