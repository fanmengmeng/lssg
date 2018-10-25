package com.lssg.model.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_dict")
public class Dict implements Serializable{

	private static final long serialVersionUID = 2983678069690605026L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "id")
	private Integer id;

	@Column(name = "key")
	private String key;

	@Column(name = "value")
	private String value;

	@Column(name = "tablename")
	private String tablename;

	@Column(name = "fieledname")
	private String fieledname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getFieledname() {
		return fieledname;
	}

	public void setFieledname(String fieledname) {
		this.fieledname = fieledname;
	}
}