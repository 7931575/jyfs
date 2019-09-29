package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Employee;

public class MyEmplSearchNameSplit extends CRUD implements SplitDao<Employee> {
	@Override
	public int AllPageNumber(int size) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int AllPageNumber(int size,int departmentId,int grade,String employeeName) {
		int num=0;
		String sql="select count(*) from  employee e,job j, grade g where e.jobId=j.jobId and j.gradeId=g.gradeId and e.departmentId=? and employeeName like '%"+employeeName+"%'  and g.grade<?";
		Object[] objects= {departmentId,grade};
		ResultSet set = execute_Query(sql, objects);
		try {
			if (set.next()) {
				int i = set.getInt(1);
				if (i % size == 0) {
					num = i / size;
				} else {
					num = i / size + 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(set);
		}
		return num;
	}


	@Override
	public int BeginPage(int size, int cruentPage) {
		int num=(cruentPage-1)*size;
		return num;
	}

	public List<Employee> ShowList(int size, int cruentPage) {
		return null;
	}
	
	public List<Employee> ShowList(int size, int cruentPage,int departmentId,int grade,String departmentName,String employeeName) {
		List<Employee> list=new ArrayList<Employee>();
		String sql="select e.jobId,employeeAccount,employeeName,e.employeeId from  employee e,job j, grade g where e.jobId=j.jobId and j.gradeId=g.gradeId and e.departmentId=? and employeeName like '%"+employeeName+"%' and g.grade<? limit ?,?";
		Object[] objects= {departmentId,grade,cruentPage,size};
		ResultSet rs = execute_Query(sql, objects);
		try {
			while(rs.next()) {
			 int employeeId = rs.getInt("employeeId");
			 String name = rs.getString("employeeName");
			 String employeeAccount = rs.getString("employeeAccount");
			 int jobId = rs.getInt("jobId");
			 Employee employee=new Employee(employeeId, departmentId, jobId, name, null, employeeAccount, null);
			 employee.setDepartmentName(departmentName);
			 sql="select jobName from job where jobId=?";
			 Object[] objects2= {jobId};
			 ResultSet set = execute_Query(sql, objects2);
			 if(set.next()) {
				 String jobName = set.getString("jobName");
				 employee.setJobName(jobName);
			 }
			 list.add(employee);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
		
	}
}
