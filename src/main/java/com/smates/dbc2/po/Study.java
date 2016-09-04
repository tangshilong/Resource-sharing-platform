package com.smates.dbc2.po;

import java.io.Serializable;
import java.util.Date;

public class Study implements Serializable{

	/**
	 *学习资料类 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private int type;
	private String name;
	private String context;
	private String describe;
	private String  owner;
	private Date createTime;
	private String url;

	public Study() {
		super();
	}
	
	@Override
	public String toString() {
		return "Study [id=" + id + ", type=" + type + ", name=" + name + ", context=" + context + ", describe="
				+ describe + ", owner=" + owner + ", createTime=" + createTime + ", url=" + url + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
