package com.lssg.model.sys;

import java.util.List;

public class RoleWithMenu extends Role{

	private static final long serialVersionUID = 2298642536698168510L;

	private Integer menuid;
	
	private List<Integer> menuids;

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public List<Integer> getMenuids() {
		return menuids;
	}

	public void setMenuids(List<Integer> menuids) {
		this.menuids = menuids;
	}
}
