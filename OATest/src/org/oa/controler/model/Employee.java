package org.oa.controler.model;

/*
 * 员工基础信息表
 */
public class Employee {

	private int employeeId;
	private int departmentId;
	private int jobId;
	private String employeeName;
	private String employeePassWord;
	private String employeeAccount;
    private String departmentName;
    private String jobName;
    
	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public Employee() {
	}
	

	public Employee(int departmentId, int jobId, String employeeName, String employeePassWord, String employeeAccount,
			String departmentName) {
		super();
		this.departmentId = departmentId;
		this.jobId = jobId;
		this.employeeName = employeeName;
		this.employeePassWord = employeePassWord;
		this.employeeAccount = employeeAccount;
		this.departmentName = departmentName;
	}


	public Employee(int employeeId, String employeeName, String employeeAccount, String departmentName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAccount = employeeAccount;
		this.departmentName = departmentName;
	}


	public Employee(int employeeId, int departmentId, int jobId, String employeeName, String employeePassWord,
			String employeeAccount, String departmentName) {
		super();
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.jobId = jobId;
		this.employeeName = employeeName;
		this.employeePassWord = employeePassWord;
		this.employeeAccount = employeeAccount;
		this.departmentName = departmentName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassWord() {
		return employeePassWord;
	}
	public void setEmployeePassWord(String employeePassWord) {
		this.employeePassWord = employeePassWord;
	}
	public String getEmployeeAccount() {
		return employeeAccount;
	}
	public void setEmployeeAccount(String employeeAccount) {
		this.employeeAccount = employeeAccount;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}	
}
