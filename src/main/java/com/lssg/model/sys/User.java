package com.lssg.model.sys;

import com.lssg.common.annotion.ExportConfig;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 用户实体类
 *
 * @author fanrui
 * @version 1.0
 * @date 2018/9/20 0020 14:38
 */

@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 9014545292873923869L;

    /**
     * 账户状态
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    public static final String DEFAULT_THEME = "green";

    public static final String DEFAULT_AVATAR = "default.jpg";

    /**
     * 性别
     */
    public static final String SEX_MALE = "0";

    public static final String SEX_FEMALE = "1";

    public static final String SEX_UNKNOW = "2";


    /**
     * 编号
     */
    private Integer id;
    /**
     * 用户名称
     */
    @ExportConfig(value = "用户名")
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 所属公司（项目）
     */
    @ExportConfig(value = "所属公司(项目)")
    private String company;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    @ExportConfig(value = "手机")
    private String mobile;
    /**
     * 微信号
     */
    @ExportConfig(value = "微信号")
    private String wechat;
    /**
     * 状态
     */
    @ExportConfig(value = "状态", convert = "s:0=锁定,1=有效")
    private String status = STATUS_VALID;
    /**
     * 创建用户
     */
    private String createuser;
    /**
     * 创建时间
     */
    @ExportConfig(value = "创建时间", convert = "c:com.lssg.common.util.poi.convert.TimeConvert")
    private Date createtime;
    /**
     * 修改用户
     */
    private String updateuser;
    /**
     * 更新时间
     */
    private Date updatetime;
    /**
     * 最后登陆时间
     */
    private Date lastlogintime;
    /**
     * 性别
     */
    private String ssex;
    /**
     * 主题
     */
    private String theme;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 备注
     */
    private String remark;
    /**
     * 角色名
     */
    @Transient
    private String rolename;

    public static String getStatusValid() {
        return STATUS_VALID;
    }

    public static String getStatusLock() {
        return STATUS_LOCK;
    }

    public static String getDefaultTheme() {
        return DEFAULT_THEME;
    }

    public static String getDefaultAvatar() {
        return DEFAULT_AVATAR;
    }

    public static String getSexMale() {
        return SEX_MALE;
    }

    public static String getSexFemale() {
        return SEX_FEMALE;
    }

    public static String getSexUnknow() {
        return SEX_UNKNOW;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
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

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", wechat='" + wechat + '\'' +
                ", status='" + status + '\'' +
                ", createuser='" + createuser + '\'' +
                ", createtime=" + createtime +
                ", updateuser='" + updateuser + '\'' +
                ", updatetime=" + updatetime +
                ", lastlogintime=" + lastlogintime +
                ", ssex='" + ssex + '\'' +
                ", theme='" + theme + '\'' +
                ", avatar='" + avatar + '\'' +
                ", remark='" + remark + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}