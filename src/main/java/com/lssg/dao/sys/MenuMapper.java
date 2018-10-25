package com.lssg.dao.sys;

import java.util.List;

import com.lssg.common.config.MyMapper;
import com.lssg.model.sys.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuMapper extends MyMapper<Menu> {
	
	List<Menu> findUserPermissions(String userName);
	
	List<Menu> findUserMenus(String userName);
	
	// 删除父节点，子节点变成顶级节点（根据实际业务调整）
	void changeToTop(List<String> menuIds);
}