package com.lssg.model.pro;

import java.io.Serializable;

/**
 * 项目和设备关联表
 *
 * @author       fanrui
 * @version      1.0
 * @date         2018/9/20  14:42
 */

public class ProjectDevice implements Serializable {

    private static final long serialVersionUID = 6221905250144990362L;
    /**
     *项目id
     */
    private Integer projectid;
    /**
     *设备id
     */
    private Integer deviceid;

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }
}
