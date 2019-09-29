package org.oa.controler.dwr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.model.Department;



public class departmentDwr extends CRUD {

	public List<String> getPart() {
		List<String> list = new ArrayList<String>();
		String sql = "select departmentName from department";
		ResultSet rs = execute_Query(sql, null);
		try {
			while (rs.next()) {
				String str = rs.getString("departmentName");
                   list.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close_ResultSet(rs);
		}
		return list;
	}
  
	 public List<Department> getDepartment() {
		 List<Department> list=new ArrayList<Department>();
		String sql="select departmentId,departmentName from department";
		ResultSet rs = execute_Query(sql, null);
		try {
			while(rs.next()) {
				int departmentId = rs.getInt("departmentId");
				String departmentName=rs.getString("departmentName");
				Department department=new Department(departmentId, departmentName, null);
				list.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return list;
	 }
	


}
