package com.smates.dbc2.vo;

public class CostumResource {
	private int startCount;
	private int pageSize;
	private String resourceName;
	private String type;
	private String accountNum;

	public CostumResource(int page, int pageSize, String resourceName, String type, String accountNum) {
		this.startCount = (page - 1) * pageSize;
		this.pageSize = pageSize;
		this.resourceName = resourceName;
		this.type = type;
		this.accountNum = accountNum;
	}

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

}
