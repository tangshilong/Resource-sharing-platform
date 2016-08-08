package com.smates.dbc2.vo;

import com.smates.dbc2.po.Menu;
import com.smates.dbc2.utils.SysConst;

public class CostumMenu extends Menu {
	private int pageNo;
	private int pageSize;
	private int startCount;

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		setStartCount((pageNo-1)*(SysConst.PAGESIZE));
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
