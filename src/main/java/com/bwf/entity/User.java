package com.bwf.entity;

public class User {

	private int userId;
	private String userName;
	private String departmentName;
	private String nickname;
	private String password;
	private Role role;
	private Group group;
	
	public User() {
	}
	
	public User(int userId, String userName, String departmentName, String nickname, String password, Role role,
			Group group) {
		this.userId = userId;
		this.userName = userName;
		this.departmentName = departmentName;
		this.nickname = nickname;
		this.password = password;
		this.role = role;
		this.group = group;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", departmentName=" + departmentName
				+ ", nickname=" + nickname + ", password=" + password + ", role=" + role + ", group=" + group + "]";
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}

}
