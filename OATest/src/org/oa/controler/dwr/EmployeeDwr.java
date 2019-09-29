package org.oa.controler.dwr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.model.Employee;

public class EmployeeDwr extends CRUD  {

	 public List<Employee> getEmployeeObj(int departmentId) {
		 List<Employee> list=new ArrayList<Employee>();
		 String sql="select employeeAccount,employeeId,employeeName from employee where departmentId=?";
		 Object[] objects= {departmentId};
		 ResultSet rs = execute_Query(sql, objects);
		 try {
			while(rs.next()) {
			String employeeAccount=	 rs.getString("employeeAccount");
			String employeeName= rs.getString("employeeName");
		  int employeeId=	rs.getInt("employeeId");
		  Employee employee=new Employee(employeeId, employeeName, employeeAccount, null);
		  list.add(employee);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close_ResultSet(rs);
		}
		 return list;
	 }
	 public Employee getEmployeeO(int employeeId) {
		 Employee employee=null;
		 String sql="select employeeName from employee where employeeId=?";
	 Object[] objects= {employeeId};
	 ResultSet rs = execute_Query(sql, objects);
	 try {
		if(rs.next()) {
			String employeeName=rs.getString("employeeName");
			employee=new Employee(employeeId, employeeName, null, null);
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close_ResultSet(rs);
	}
				
			return employee;	 
				 
				 
				
	 }
	 public int isExit(String employeeAccount) {
		int num=0;
		 String sql="select count(*) from employee where employeeAccount=?";
		 Object[] objects= {employeeAccount};
		 ResultSet rs = execute_Query(sql, objects);
		 try {
			if(rs.next()) {
				 num=rs.getInt(1);
			 }
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		 
		 return num;
	 }
}
