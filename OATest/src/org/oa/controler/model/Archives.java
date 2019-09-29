package org.oa.controler.model;
/*
 * µµ°¸
 */
public class Archives {
/*
 * create table archives
(
   archivesId           int not null auto_increment,
   employeeId           int,
   title                varchar(255),
   content              text,
   createTime           date,
   primary key (archivesId)
);
 */
	private int archivesId;
	private int employeeId;
	private String title;
	private String content;
	private String createTime;
	private String employeeName;
	
	public Archives(int employeeId, String title, String content, String createTime, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.employeeName = employeeName;
	}

	public Archives(int archivesId, int employeeId, String title, String content, String createTime,
			String employeeName) {
		super();
		this.archivesId = archivesId;
		this.employeeId = employeeId;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.employeeName = employeeName;
	}

	public int getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(int archivesId) {
		this.archivesId = archivesId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
}
