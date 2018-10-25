package com.lssg.service.sys;

import com.lssg.model.sys.User;
import com.lssg.model.sys.UserWithRole;
import com.lssg.service.iservice.IService;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    List<User> findUser();

    UserWithRole findById(Integer userId);

    User findByName(String userName);

    public Map<String, Object> selectByPage(int pageNumber, int pageSize);

    void addUser(User user, Integer[] roles,Integer[] infos);

    void updateUser(User user, Integer[] roles);

    void deleteUsers(Integer[] userIds);

    void updateLoginTime(String userName);

    void updatePassword(String password);

    User findUserProfile(User user);

    void updateUserProfile(User user);
}
