package com.lssg.service.sys.impl;

import java.util.Arrays;
import java.util.List;

import com.lssg.dao.sys.UserRoleMapper;
import com.lssg.model.sys.UserRole;
import com.lssg.service.iservice.impl.BaseService;
import com.lssg.service.sys.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {
@Autowired
private UserRoleMapper userRoleMapper;

	@Override
	@Transactional
	public void deleteUserRolesByUserId(Integer[] userIds) {
		userRoleMapper.deleteUserRolesByUserId(userIds);
	}

}
