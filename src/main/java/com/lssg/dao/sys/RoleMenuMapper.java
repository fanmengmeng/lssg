package com.lssg.dao.sys;

import com.lssg.common.config.MyMapper;
import com.lssg.model.sys.RoleMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuMapper extends MyMapper<RoleMenu> {
    void batchDeleteByRoleId(Integer[] roleIds);

    void batchDeleteByMenuId(Integer[] menuIds);

    int insertRolemenu(RoleMenu roleMenu);
}