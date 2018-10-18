package com.bwf.entity;

import java.util.List;

public class Auth {

	private Integer authId;
	private String authName;
	private String menuUrl;
	private List<Auth> childAuth;
	private List<Operate> ops;
	
	public Auth() {
	}
	
	public Auth(Integer authId, String authName, String menuUrl, List<Auth> childAuth, List<Operate> ops) {
		this.authId = authId;
		this.authName = authName;
		this.menuUrl = menuUrl;
		this.childAuth = childAuth;
		this.ops = ops;
	}
	
	@Override
	public String toString() {
		return "Auth [authId=" + authId + ", authName=" + authName + ", menuUrl=" + menuUrl + ", childAuth=" + childAuth
				+ ", ops=" + ops + "]";
	}
	
	public Integer getAuthId() {
		return authId;
	}
	
	public void setAuthId(Integer authId) {
		this.authId = authId;
	}
	
	public String getAuthName() {
		return authName;
	}
	
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	public String getMenuUrl() {
		return menuUrl;
	}
	
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	public List<Auth> getChildAuth() {
		return childAuth;
	}
	
	public void setChildAuth(List<Auth> childAuth) {
		this.childAuth = childAuth;
	}
	
	public List<Operate> getOps() {
		return ops;
	}
	
	public void setOps(List<Operate> ops) {
		this.ops = ops;
	}
	
}
