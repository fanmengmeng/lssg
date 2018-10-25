package com.lssg.service.sys;

import java.util.List;
import java.util.Map;

import com.lssg.model.sys.Menu;
import com.lssg.pojo.Tree;
import com.lssg.service.iservice.IService;

public interface MenuService extends IService<Menu> {

    List<Menu> findUserPermissions(String userName);

    List<Menu> findUserMenus(String userName);

    List<Menu> findAllMenus(Menu menu);

    Tree<Menu> getMenuButtonTree();

    Tree<Menu> getMenuTree();

    Tree<Menu> getUserMenu(String userName);

    Menu findById(Integer menuId);

    Menu findByNameAndType(String menuName, String type);

    void addMenu(Menu menu);

    void updateMenu(Menu menu);

  /*  void deleteMeuns(String menuIds);*/

    List<Map<String, String>> getAllUrl(String p1);
}
