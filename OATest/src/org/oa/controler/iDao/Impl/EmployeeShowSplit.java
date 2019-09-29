package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Employee;

public class EmployeeShowSplit extends CRUD implements SplitDao<Employee> {

	/**
	 * 获得总页数
	 **/
	@Override
	public int AllPageNumber(int size) {
		int num = 0;
		String sql = "select count(*) from employee e inner join department d on e.departmentId=d.departmentId";
		
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

	/**
	 * 开始的下标
	 */
	@Override
	public int BeginPage(int size, int cruentPage) {
		int xb = (cruentPage - 1) * size;
		return xb;
	}

	/**
	 * 获取内容
	 */
	@Override
	public List<Employee> ShowList(int size, int cruentPage) {
		List<Employee> list = new ArrayList<Employee>();
		String sql = "select e.*,d.departmentName from employee e inner join department d on e.departmentId=d.departmentId limit ?,? ";
		Object[] objects = { cruentPage, size };
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
