package com.lssg.model.sys;

import java.util.List;

public class UserWithRole extends User{

	private static final long serialVersionUID = 3912474378717186257L;

	private Integer roleid;
	
	private List<Integer> roleids;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public List<Integer> getRoleids() {
		return roleids;
	}

	public void setRoleids(List<Integer> roleids) {
		this.roleids = roleids;
	}
}