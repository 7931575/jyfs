package org.oa.controler.model;

/*
 * Ö°Îñ
 */
public class Job {
	private int jobId;
	private int departmentId;
	private int gradeId;
	private String jobName;
	private String jobDesc;
	private String departmentName;
	public Job() {}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Job(int jobId, int departmentId, int gradeId, String jobName, String jobDesc, String departmentName) {
		super();
		this.jobId = jobId;
		this.departmentId = departmentId;
		this.gradeId = gradeId;
		this.jobName = jobName;
		this.jobDesc = jobDesc;
		this.departmentName = departmentName;
	}
	public Job(int departmentId, int gradeId, String jobName, String jobDesc, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.gradeId = gradeId;
		this.jobName = jobName;
		this.jobDesc = jobDesc;
		this.departmentName = departmentName;
	}
	
}
