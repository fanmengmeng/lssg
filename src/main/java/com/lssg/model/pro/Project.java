package com.lssg.model.pro;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 项目信息实体类
 *
 * @author fanrui
 * @version 1.0
 * @date 2018/9/13 0013 13:00
 */
@Table(name = "pro_info")
public class Project implements Serializable {


    private static final long serialVersionUID = 2729028826256142701L;
    /**
     * 编号
     */
    private Long id;
    /**
     * 项目名称
     */
    private String projectname;
    /**
     * 日期
     */
    private Date projectdate;
    /**
     * 项目经理
     */
    private String manager;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 管理人
     */
    private String administrator;
    /**
     * 省份
     */
    private String province;
    /**
     * 国家
     */
    private String country;
    /**
     * 城市
     */
    private String city;
    /**
     * 建筑面积
     */
    private Double area;
    /**
     * 地区
     */
    private String region;
    /**
     * 合同造价
     */
    private Double dealcost;
    /**
     * 开工日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startworkdate;
    /**
     * 竣工日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date completiondate;
    /**
     * 结构类型
     */
    private String structuretype;
    /**
     * 建筑层数
     */
    private String buildinglayers;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 施工许可证批准号
     */
    private String license;
    /**
     * 监督电话
     */
    private String monitorphone;
    /**
     * 建设单位
     */
    private String buildunit;
    /**
     * 施工单位
     */
    private String constructionunit;
    /**
     * 设计单位
     */
    private String designunit;
    /**
     * 质检单位
     */
    private String qualityunit;
    /**
     * 安监单位
     */
    private String securityunit;
    /**
     * 监理单位
     */
    private String supervisionunit;
    /**
     * 基础施工开始日期
     */
    private Date basestartdate;
    /**
     * 基础施工结束日期
     */
    private Date baseenddate;
    /**
     * 主体施工开始日期
     */
    private Date mainbodystartdate;
    /**
     * 主体施工结束日期
     */
    private Date mainbodyenddate;
    /**
     * 装饰装修开始时间
     */
    private Date deckstartdate;
    /**
     * 装饰装修结束时间
     */
    private Date deckenddate;
    /**
     * 周边情况
     */
    private String roundstate;
    /**
     * 备注
     */
    private String remark;
    /**
     * 0正常 1删除 2停用
     */
    private Integer status;
    /**
     * 创建用户
     */
    private String createby;
    /**
     * 创建日期
     */
    private Date createtime;
    /**
     * 修改用户
     */
    private String updateby;
    /**
     * 修改日期
     */
    private Date updatetime;

    private List<Device> devices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public Date getProjectdate() {
        return projectdate;
    }

    public void setProjectdate(Date projectdate) {
        this.projectdate = projectdate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getDealcost() {
        return dealcost;
    }

    public void setDealcost(Double dealcost) {
        this.dealcost = dealcost;
    }

    public Date getStartworkdate() {
        return startworkdate;
    }

    public void setStartworkdate(Date startworkdate) {
        this.startworkdate = startworkdate;
    }

    public Date getCompletiondate() {
        return completiondate;
    }

    public void setCompletiondate(Date completiondate) {
        this.completiondate = completiondate;
    }

    public String getStructuretype() {
        return structuretype;
    }

    public void setStructuretype(String structuretype) {
        this.structuretype = structuretype;
    }

    public String getBuildinglayers() {
        return buildinglayers;
    }

    public void setBuildinglayers(String buildinglayers) {
        this.buildinglayers = buildinglayers;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getMonitorphone() {
        return monitorphone;
    }

    public void setMonitorphone(String monitorphone) {
        this.monitorphone = monitorphone;
    }

    public String getBuildunit() {
        return buildunit;
    }

    public void setBuildunit(String buildunit) {
        this.buildunit = buildunit;
    }

    public String getConstructionunit() {
        return constructionunit;
    }

    public void setConstructionunit(String constructionunit) {
        this.constructionunit = constructionunit;
    }

    public String getDesignunit() {
        return designunit;
    }

    public void setDesignunit(String designunit) {
        this.designunit = designunit;
    }

    public String getQualityunit() {
        return qualityunit;
    }

    public void setQualityunit(String qualityunit) {
        this.qualityunit = qualityunit;
    }

    public String getSecurityunit() {
        return securityunit;
    }

    public void setSecurityunit(String securityunit) {
        this.securityunit = securityunit;
    }

    public String getSupervisionunit() {
        return supervisionunit;
    }

    public void setSupervisionunit(String supervisionunit) {
        this.supervisionunit = supervisionunit;
    }

    public Date getBasestartdate() {
        return basestartdate;
    }

    public void setBasestartdate(Date basestartdate) {
        this.basestartdate = basestartdate;
    }

    public Date getBaseenddate() {
        return baseenddate;
    }

    public void setBaseenddate(Date baseenddate) {
        this.baseenddate = baseenddate;
    }

    public Date getMainbodystartdate() {
        return mainbodystartdate;
    }

    public void setMainbodystartdate(Date mainbodystartdate) {
        this.mainbodystartdate = mainbodystartdate;
    }

    public Date getMainbodyenddate() {
        return mainbodyenddate;
    }

    public void setMainbodyenddate(Date mainbodyenddate) {
        this.mainbodyenddate = mainbodyenddate;
    }

    public Date getDeckstartdate() {
        return deckstartdate;
    }

    public void setDeckstartdate(Date deckstartdate) {
        this.deckstartdate = deckstartdate;
    }

    public Date getDeckenddate() {
        return deckenddate;
    }

    public void setDeckenddate(Date deckenddate) {
        this.deckenddate = deckenddate;
    }

    public String getRoundstate() {
        return roundstate;
    }

    public void setRoundstate(String roundstate) {
        this.roundstate = roundstate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
