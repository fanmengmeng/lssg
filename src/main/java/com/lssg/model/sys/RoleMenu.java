package com.lssg.model.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_role_menu")
public class RoleMenu implements Serializable {


    private static final long serialVersionUID = -1482247706712091577L;
    @Column(name = "roleid")
    private Integer roleid;

    @Column(name = "menuid")
    private Integer menuid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
}