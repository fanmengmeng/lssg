package com.lssg.model.pro;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 摄像头设备
 *
 * @author fanrui 2018年7月20日
 */
@Table(name="p_device")
public class Device implements Serializable {

    private static final long serialVersionUID = 8813840169716979713L;
    /*
     * 主键id
     */
    private Integer id;
    /*
     * 设备序列号
     */
    private String deviceserial;

    /*
     * 设备名称
     */
    private String devicename;

    /*
     * 设备型号，如CS-C2S-21WPFR-WX
     */
    private String model;
    /*
     * 设备类型
     */
    private String devicetype;

    /*
     * 通道号
     */
    private Integer channelno;

    /*
     * 通道名
     */
    private String channelname;
    /*
     * 图片地址（大图），若在萤石客户端设置封面则返回封面图片，未设置则返回默认图片
     */
    private String picurl;

    /*
     * 设备版本号
     */
    private String deviceversion;

    /*
     * 具有防护能力的设备布撤防状态：0-睡眠，8-在家，16-外出，普通IPC布撤防状态：0-撤防，1-布防
     */
    private Integer defence;

    /*
     * 视频质量：0-流畅，1-均衡，2-高清，3-超清
     */
    private Integer videolevel;

    /*
     * 分享状态：1-分享所有者，0-未分享，2-分享接受者（表示此摄像头是别人分享给我的）
     */
    private String isshared;

    /*
     * 在线状态：0-不在线，1-在线
     */
    private Integer status;

    /*
     * 云存储状态: -2:设备不支持;-1: 未开通;0: 未激活;1: 激活;2: 过期
     */
    private Integer cloudstatus;

    /*
     * sd硬盘状态:0:正常;1:存储介质错;2:未格式化;3:正在格式化;返回形式:一个硬盘表示为"0---------------",
     * 两个硬盘表示为"00--------------",以此类推;-1:设备没有上报或者设备不支持该状态
     */
    private Integer diskstate;

    /*
     * 挂载的sd硬盘数量,-1:设备没有上报或者设备不支持该状态
     */
    private Integer disknum;

    /*
     * 设备验证码
     */
    private String devicecode;

    /*
     * 设备下线是否通知：0-不通知 1-通知
     */
    private Integer offlinenotify;

    /*
     * 是否加密，0：不加密，1：加密
     */
    private Integer isencrypt;

    /*
     * 告警声音模式：0-短叫，1-长叫，2-静音
     */
    private Integer alarmsoundmode;

    /*
     * 创建日期
     */
    private Date createtime;

    /*
     * 创建用户
     */
    private String createuser;

    /*
     * 修改日期
     */
    private Date updatetime;

    /*
     * 修改用户
     */
    private String updateuser;

    /*
     * 删除标记
     */

    private Boolean delflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceserial() {
        return deviceserial;
    }

    public void setDeviceserial(String deviceserial) {
        this.deviceserial = deviceserial;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public Integer getChannelno() {
        return channelno;
    }

    public void setChannelno(Integer channelno) {
        this.channelno = channelno;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getDeviceversion() {
        return deviceversion;
    }

    public void setDeviceversion(String deviceversion) {
        this.deviceversion = deviceversion;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getVideolevel() {
        return videolevel;
    }

    public void setVideolevel(Integer videolevel) {
        this.videolevel = videolevel;
    }

    public String getIsshared() {
        return isshared;
    }

    public void setIsshared(String isshared) {
        this.isshared = isshared;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCloudstatus() {
        return cloudstatus;
    }

    public void setCloudstatus(Integer cloudstatus) {
        this.cloudstatus = cloudstatus;
    }

    public Integer getDiskstate() {
        return diskstate;
    }

    public void setDiskstate(Integer diskstate) {
        this.diskstate = diskstate;
    }

    public Integer getDisknum() {
        return disknum;
    }

    public void setDisknum(Integer disknum) {
        this.disknum = disknum;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public Integer getOfflinenotify() {
        return offlinenotify;
    }

    public void setOfflinenotify(Integer offlinenotify) {
        this.offlinenotify = offlinenotify;
    }

    public Integer getIsencrypt() {
        return isencrypt;
    }

    public void setIsencrypt(Integer isencrypt) {
        this.isencrypt = isencrypt;
    }

    public Integer getAlarmsoundmode() {
        return alarmsoundmode;
    }

    public void setAlarmsoundmode(Integer alarmsoundmode) {
        this.alarmsoundmode = alarmsoundmode;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    public Boolean getDelflag() {
        return delflag;
    }

    public void setDelflag(Boolean delflag) {
        this.delflag = delflag;
    }

}
