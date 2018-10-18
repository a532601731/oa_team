package com.bwf.entity;

public class Group {

	private Integer groupId;
	private String groupName;
	private Integer	level;
	
	public Integer getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", level=" + level + "]";
	}
	
	public Group(Integer groupId, String groupName, Integer level) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.level = level;
	}
	
	public Group() {
	}

}
