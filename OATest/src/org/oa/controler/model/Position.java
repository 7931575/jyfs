package org.oa.controler.model;
/*
 * ¸ÚÎ»
 */
public class Position {
private int positionId;
	private int employeeId;
	private int departmentId;
	private int jobId;
	private String postionCreateTime;
	private String postionDescribe;
	private String oldDepartmentName;    
	private String  oldJobName ;
	private String newDepartmentName;    
	private String  newJobName ;
	private String employeeName;
	
	public String getEmployeeName() {
		return employeeName;
	}









	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}









	public Position() {
		
	}
	

	


	



	public Position(int employeeId, int departmentId, int jobId, String postionDescribe, String oldDepartmentName,
			String oldJobName) {
		super();
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.jobId = jobId;
		this.postionDescribe = postionDescribe;
		this.oldDepartmentName = oldDepartmentName;
		this.oldJobName = oldJobName;
	}









	public String getNewDepartmentName() {
		return newDepartmentName;
	}





	public void setNewDepartmentName(String newDepartmentName) {
		this.newDepartmentName = newDepartmentName;
	}





	public String getNewJobName() {
		return newJobName;
	}





	public void setNewJobName(String newJobName) {
		this.newJobName = newJobName;
	}





	public Position(int positionId, int employeeId, int departmentId, int jobId, String postionCreateTime,
			String postionDescribe, String oldDepartmentName, String oldJobName, String newDepartmentName,
			String newJobName) {
		super();
		this.positionId = positionId;
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.jobId = jobId;
		this.postionCreateTime = postionCreateTime;
		this.postionDescribe = postionDescribe;
		this.oldDepartmentName = oldDepartmentName;
		this.oldJobName = oldJobName;
		this.newDepartmentName = newDepartmentName;
		this.newJobName = newJobName;
	}





	public String getOldDepartmentName() {
		return oldDepartmentName;
	}


	public void setOldDepartmentName(String oldDepartmentName) {
		this.oldDepartmentName = oldDepartmentName;
	}


	public String getOldJobName() {
		return oldJobName;
	}


	public void setOldJobName(String oldJobName) {
		this.oldJobName = oldJobName;
	}


	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
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
	public String getPostionCreateTime() {
		return postionCreateTime;
	}
	public void setPostionCreateTime(String postionCreateTime) {
		this.postionCreateTime = postionCreateTime;
	}
	public String getPostionDescribe() {
		return postionDescribe;
	}
	public void setPostionDescribe(String postionDescribe) {
		this.postionDescribe = postionDescribe;
	}
	
}
