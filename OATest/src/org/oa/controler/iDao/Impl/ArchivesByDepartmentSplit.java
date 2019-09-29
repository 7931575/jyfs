package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Employee;

public class ArchivesByDepartmentSplit extends CRUD implements SplitDao<Employee> {
	@Override
	public int AllPageNumber(int size) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int AllPageNumber(int size,String departmentName) {
		int num=0;
		String sql="select count(distinct e.employeeId) from employee e,archives a,department d where e.employeeId=a.employeeId and e.departmentId=d.departmentId and d.departmentName like '%"+departmentName+"%'";

		ResultSet rs = execute_Query(sql, null);
		try {
			if(rs.next()) {
				int m=rs.getInt(1);
				if(m%size==0) {
					num=m/size;
				}else{
					num=num/size+1;
			}
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int BeginPage(int size, int cruentPage) {
		int b=(cruentPage-1)*size;
		return b;
	}

	@Override
	public List<Employee> ShowList(int size, int cruentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employee> ShowList(int size, int cruentPage,String name) {
		List<Employee> list = new ArrayList<Employee>();
		String sql = "select distinct(e.employeeId),e.employeeAccount,e.employeeName,d.departmentName from employee e,archives a,department d where e.employeeId=a.employeeId and e.departmentId=d.departmentId and d.departmentName like '%"+name+"%' limit ?,?";
		Object[] objects = {cruentPage, size };
		ResultSet rs = execute_Query(sql, objects);
		try {
			while (rs.next()) {
				int employeeId = rs.getInt("employeeId");
				String employeeAccount = rs.getString("employeeAccount");
				String departmentName = rs.getString("departmentName");
				String employeeName = rs.getString("employeeName");
				Employee employee=new Employee(employeeId, employeeName, employeeAccount, departmentName);
			 list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return list;
	}
}
