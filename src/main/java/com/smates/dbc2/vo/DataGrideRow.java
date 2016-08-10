package com.smates.dbc2.vo;

import java.util.List;

import com.smates.dbc2.po.Menu;

public class DataGrideRow {
	private int total;
	private List<Menu> rows;
	
	public DataGrideRow(int total, List<Menu> rows) {
		this.total = total;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Menu> getRows() {
		return rows;
	}

	public void rows(List<Menu> rows) {
		this.rows = rows;
	}

	public void setRows(List<Menu> rows) {
		this.rows = rows;
	}
	
}
