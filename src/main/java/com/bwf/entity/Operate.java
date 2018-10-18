package com.bwf.entity;

public class Operate {

	private Integer opId;
	private String opName;
	private String opCode;
	private Integer authId;
	
	public Operate() {
	}
	
	public Operate(Integer opId, String opName, String opCode, Integer authId) {
		this.opId = opId;
		this.opName = opName;
		this.opCode = opCode;
		this.authId = authId;
	}
	
	@Override
	public String toString() {
		return "Operate [opId=" + opId + ", opName=" + opName + ", opCode=" + opCode + ", authId=" + authId + "]";
	}
	
	public Integer getOpId() {
		return opId;
	}
	
	public void setOpId(Integer opId) {
		this.opId = opId;
	}
	
	public String getOpName() {
		return opName;
	}
	
	public void setOpName(String opName) {
		this.opName = opName;
	}
	
	public String getOpCode() {
		return opCode;
	}
	
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	
	public Integer getAuthId() {
		return authId;
	}
	
	public void setAuthId(Integer authId) {
		this.authId = authId;
	}
	
}
