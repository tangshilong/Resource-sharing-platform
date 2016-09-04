package com.smates.dbc2.po;

import java.io.Serializable;
import java.util.Date;

public class Game implements Serializable {

	/**
	 * 游戏资源类
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private int type;
	private String name;
	private String content;
	private String descibe;
	private String owner;
	private Date createTime;
	private int userId;
	
	
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
	public String getDescibe() {
		return descibe;
	}
	public void setDescibe(String descibe) {
		this.descibe = descibe;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", type=" + type + ", name=" + name + ", content=" + content + ", descibe=" + descibe
				+ ", owner=" + owner + ", createTime=" + createTime + ", userId=" + userId + "]";
	}
	public Game() {
		super();
	}
	
	

}
