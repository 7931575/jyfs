package org.oa.controler.model;
/*
 * ²¿ÃÅ
 */
public class Department {
	private int departmentId;     
	private String departmentName; 
	private String departmentDesc;
	public Department() {}
	public Department(String departmentName, String departmentDesc) {
		super();
		this.departmentName = departmentName;
		this.departmentDesc = departmentDesc;
	}
	
	public Department(int departmentId, String departmentName, String departmentDesc) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentDesc = departmentDesc;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	

}
