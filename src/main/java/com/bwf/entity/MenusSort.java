package com.bwf.entity;

public class MenusSort {
	private Integer userId;
	
	private String newMenus;

	public Integer getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "MenusSort [userId=" + userId + ", newMenus=" + newMenus + "]";
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNewMenus() {
		return newMenus;
	}

	public void setNewMenus(String newMenus) {
		this.newMenus = newMenus;
	}
	
}
