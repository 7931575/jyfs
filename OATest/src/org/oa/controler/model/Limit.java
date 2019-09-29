package org.oa.controler.model;

public class Limit {
	private int limitId;
	private String limitName;
	private String limitDesc;
	public Limit() {}
	public Limit(int limitId, String limitName, String limitDesc) {
		super();
		this.limitId = limitId;
		this.limitName = limitName;
		this.limitDesc = limitDesc;
	}
	public Limit(String limitName, String limitDesc) {
		super();
		this.limitName = limitName;
		this.limitDesc = limitDesc;
	}
	public int getLimitId() {
		return limitId;
	}
	public void setLimitId(int limitId) {
		this.limitId = limitId;
	}
	public String getLimitName() {
		return limitName;
	}
	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}
	public String getLimitDesc() {
		return limitDesc;
	}
	public void setLimitDesc(String limitDesc) {
		this.limitDesc = limitDesc;
	}
	
	
}
