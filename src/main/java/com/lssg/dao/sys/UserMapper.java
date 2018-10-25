package com.lssg.dao.sys;

import java.util.List;

import com.lssg.common.config.MyMapper;
import com.lssg.model.sys.Role;
import com.lssg.model.sys.User;
import com.lssg.model.sys.UserWithRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MyMapper<User> {

	int userTotal();

	List<User> getUserAll();
	
	List<UserWithRole> findUserWithRole(Integer userId);
	
	User findUserProfile(User user);

	void batchDeleteUser(Integer[] userIds);

	int insertUser(User user);
}