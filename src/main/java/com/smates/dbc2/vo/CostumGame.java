package com.smates.dbc2.vo;

public class CostumGame {
	private int startCount;
	private int pageSize;
	private String resourceName;
	private String type;
	private String accountNum;
	private String describe;

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
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

	public CostumGame(int page, int pageSize, String resourceName, String type, String accountNum,
			String describe) {
		super();
		this.startCount = (page - 1) * pageSize;
		this.pageSize = pageSize;
		this.resourceName = resourceName;
		this.type = type;
		this.accountNum = accountNum;
		this.describe = describe;
	}
	
	@Override
	public String toString() {
		return "CostumGame [startCount=" + startCount + ", pageSize=" + pageSize + ", resourceName=" + resourceName
				+ ", type=" + type + ", accountNum=" + accountNum + ", describe=" + describe + "]";
	}
}
