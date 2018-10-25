package com.lssg.model.sys;

import java.io.Serializable;

/**
 * 用户和项目关联实体类
 *
 * @author fanrui
 * @version 1.0
 * @date 2018/9/27  15:56
 */

public class UserInfo implements Serializable {

    private static final long serialVersionUID = -8475994529686772717L;
    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 项目id
     */
    private Integer projectid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
}
