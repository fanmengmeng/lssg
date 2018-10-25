package com.lssg.service.sys.impl;

import java.util.Arrays;
import java.util.List;

import com.lssg.dao.sys.RoleMenuMapper;
import com.lssg.model.sys.RoleMenu;
import com.lssg.service.iservice.impl.BaseService;
import com.lssg.service.sys.RoleMenuServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("roleMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends BaseService<RoleMenu> implements RoleMenuServie {
@Autowired
private RoleMenuMapper roleMenuMapper;
	@Override
	@Transactional
	public void deleteRoleMenusByRoleId(Integer[] roleIds) {

		roleMenuMapper.batchDeleteByRoleId(roleIds);
	}

	@Override
	@Transactional
	public void deleteRoleMenusByMenuId(Integer[] menuIds) {
		roleMenuMapper.batchDeleteByMenuId(menuIds);
	}

}
