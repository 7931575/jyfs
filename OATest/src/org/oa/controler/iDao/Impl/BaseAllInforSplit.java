package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Employee;

public class BaseAllInforSplit extends CRUD implements SplitDao<Employee> {

	
	@Override
	public int AllPageNumber(int size) {
		int num=0;
		String sql="select count(*) from  employee";
		
		ResultSet set = execute_Query(sql, null);
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

	
	@Override
	public List<Employee> ShowList(int size, int cruentPage) {
		List<Employee> list=new ArrayList<Employee>();
		String sql="select e.jobId,e.departmentId,employeeAccount,employeeName,e.employeeId from  employee e inner join job j on e.jobId=j.jobId  limit ?,?";
		Object[] objects= {cruentPage,size};
		ResultSet rs = execute_Query(sql, objects);
		try {
			while(rs.next()) {
			 int employeeId = rs.getInt("employeeId");
			 String employeeName = rs.getString("employeeName");
			 String employeeAccount = rs.getString("employeeAccount");
			 int departmentId = rs.getInt("departmentId");
			 int jobId = rs.getInt("jobId");
			 Employee employee=new Employee(employeeId, departmentId, jobId, employeeName, null, employeeAccount, null);
			
			 sql="select jobName from job where jobId=?";
			 Object[] objects2= {jobId};
			 ResultSet set = execute_Query(sql, objects2);
			 if(set.next()) {
				 String jobName = set.getString("jobName");
				 employee.setJobName(jobName);
			 }
			 
           
			 sql="select departmentName from department where departmentId=?";
			 Object[] objects3= {departmentId};
			 ResultSet se = execute_Query(sql, objects3);
			if(se.next()) {
				 String departmentName = se.getString("departmentName");
				 employee.setDepartmentName(departmentName);
			 }
			 
			 list.add(employee);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
		
	}



}
