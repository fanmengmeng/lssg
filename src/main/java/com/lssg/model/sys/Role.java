package com.lssg.model.sys;

import com.lssg.common.annotion.ExportConfig;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色实体类
 *
 * @author fanrui
 * @version 1.0
 * @date 2018/9/20 0020 14:38
 */

@Table(name = "t_role")
public class Role implements Serializable {


    private static final long serialVersionUID = -2883236298113127869L;
    /**
     * 编号
     */
    private Integer id;
    /**
     * 角色名称
     */
    @ExportConfig(value = "角色")
    private String rolename;
    /**
     * 备注
     */
    @ExportConfig(value = "描述")
    private String remark;
    /**
     * 创建用户
     */
    private String createuser;
    /**
     * 创建日期
     */
    @ExportConfig(value = "创建时间", convert = "c:com.lssg.common.util.poi.convert.TimeConvert")
    private Date createtime;
    /**
     * 更新用户
     */
    private String updateuser;
    /**
     * 更新日期
     */
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}