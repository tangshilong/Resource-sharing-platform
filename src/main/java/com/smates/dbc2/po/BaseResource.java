package com.smates.dbc2.po;

import java.io.Serializable;
import java.util.Date;

public class BaseResource implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private int type;
	private String name;
	private String content;
	private String describe;
	private String owner;
	private Date createTime;

	public BaseResource() {
	}

	public BaseResource(String id, int type, String name, String content, String describe, String owner,
			Date createTime) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.content = content;
		this.describe = describe;
		this.owner = owner;
		this.createTime = createTime;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	@Override
	public String toString() {
		return "BaseResource [id=" + id + ", type=" + type + ", name=" + name + ", content=" + content + ", describe="
				+ describe + ", owner=" + owner + ", createTime=" + createTime + "]";
	}
	
}
