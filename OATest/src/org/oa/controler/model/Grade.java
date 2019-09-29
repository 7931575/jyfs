package org.oa.controler.model;
/*
 * 职务级别
 */
public class Grade {
	private int gradeId;
	private int grade;
	private String gradeDescribe;
	public Grade() {}
	public Grade(int gradeId, int grade, String gradeDescribe) {
		super();
		this.gradeId = gradeId;
		this.grade = grade;
		this.gradeDescribe = gradeDescribe;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getGradeDescribe() {
		return gradeDescribe;
	}
	public void setGradeDescribe(String gradeDescribe) {
		this.gradeDescribe = gradeDescribe;
	}
	
	
}
