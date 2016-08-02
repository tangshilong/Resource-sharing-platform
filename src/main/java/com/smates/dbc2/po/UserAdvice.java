package com.smates.dbc2.po;

import java.util.Date;
import java.util.Map;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

@Entity(noClassnameStored = true)
public class UserAdvice {
	@Id
	private ObjectId id;
	private String message;
	private Integer userId;
	private Integer hosueId;
	private Map<String, String> paraMap;
	@Indexed(options = @IndexOptions(unique = false, dropDups = false, background = true))
	private Date createDate;
	
	public UserAdvice(String message, Integer userId, Integer hosueId, Map<String, String> paraMap,
			Date createDate) {
		this.message = message;
		this.userId = userId;
		this.hosueId = hosueId;
		this.paraMap = paraMap;
		this.createDate = createDate;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHosueId() {
		return hosueId;
	}

	public void setHosueId(Integer hosueId) {
		this.hosueId = hosueId;
	}

	public Map<String, String> getParaMap() {
		return paraMap;
	}

	public void setParaMap(Map<String, String> paraMap) {
		this.paraMap = paraMap;
	}
	
}