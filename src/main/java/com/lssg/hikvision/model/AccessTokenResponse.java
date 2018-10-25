package com.lssg.hikvision.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 获取accessToken返回字段
 * @author fanrui
 * 2018年6月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessTokenResponse implements Serializable{

	private static final long serialVersionUID = -1825027573750712807L;
	/**
	 * 
	 */

	private String accessToken;
	private Long expireTime;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}
	
	}