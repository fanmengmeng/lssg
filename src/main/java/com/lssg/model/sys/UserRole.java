package com.lssg.model.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_user_role")
public class UserRole implements Serializable{

	private static final long serialVersionUID = -8536450709197436736L;

	@Column(name = "userid")
		private Integer userid;

	@Column(name = "roleid")
	private Integer roleid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
}