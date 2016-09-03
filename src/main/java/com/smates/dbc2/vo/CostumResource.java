package com.smates.dbc2.vo;

public class CostumResource {
	private Integer startCount;
	private Integer pageSize;
	private String resourceName;
	private int type;
	public CostumResource(Integer page, Integer pageSize, String resourceName, int type) {
		this.startCount = (page-1)*pageSize;
		this.pageSize = pageSize;
		this.resourceName = resourceName;
		this.type = type;
	}

	public Integer getStartCount() {
		return startCount;
	}

	public void setStartCount(Integer startCount) {
		this.startCount = startCount;
	}

	public Integer getpageSize() {
		return pageSize;
	}

	public void setpageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public CostumResource() {
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
