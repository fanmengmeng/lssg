package com.lssg.hikvision.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 开通直播功能返回字段
 * @author fanrui
 * 2018年6月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLiveResponse {
	//设备序列号
	private String deviceSerial;
	//通道号
	private String channelNo;
	//设备开通状态码，参考下方返回码
	private String ret;
	//设备开通状态描述
	private String desc;
	public String getDeviceSerial() {
		return deviceSerial;
	}
	public void setDeviceSerial(String deviceSerial) {
		this.deviceSerial = deviceSerial;
	}
	public String getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "OpenLiveResponse [deviceSerial=" + deviceSerial + ", channelNo=" + channelNo + ", ret=" + ret
				+ ", desc=" + desc + "]";
	}
	
}
