package com.bwf.entity;

import java.util.List;

public class Role {

	private Integer roleId;
	private String roleName;
	private List<Auth> authes;
	
	public Role() {
	}
	
	public Role(Integer roleId, String roleName, List<Auth> authes) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.authes = authes;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", authes=" + authes + "]";
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public List<Auth> getAuthes() {
		return authes;
	}
	
	public void setAuthes(List<Auth> authes) {
		this.authes = authes;
	}
	
}
