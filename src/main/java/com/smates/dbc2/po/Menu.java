package com.smates.dbc2.po;

import java.util.List;

public class Menu {
	private String menuId;
	private String menuName;
	private String parentId;
	private String menuUrl;
	private int order;
	private String permition;
	private List<Menu> submenus;

	public Menu() {
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<Menu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(List<Menu> submenus) {
		this.submenus = submenus;
	}

	public String getPermition() {
		return permition;
	}

	public void setPermition(String permition) {
		this.permition = permition;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", parentId=" + parentId + ", menuUrl=" + menuUrl
				+ ", order=" + order + ", submenus=" + submenus + "]";
	}
	
}