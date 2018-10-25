package com.lssg.dao.sys;

import com.lssg.common.config.MyMapper;
import com.lssg.model.sys.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper extends MyMapper<UserRole> {
   void deleteUserRolesByUserId(Integer[] userIds);
}