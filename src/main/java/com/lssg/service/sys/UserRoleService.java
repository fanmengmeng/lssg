package com.lssg.service.sys;

import com.lssg.model.sys.UserRole;
import com.lssg.service.iservice.IService;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {


	void deleteUserRolesByUserId(Integer[] userIds);
}
