package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.DepartmentDao;
import org.oa.controler.model.Department;

public class DepartmentImpl extends CRUD implements DepartmentDao {
	/**
	 * 添加部门信息
	 */
	@Override
	public boolean addDepartment(Department department) {
		String departmentName = department.getDepartmentName();
		String departmentDesc = department.getDepartmentDesc();
		String sql = "insert into department(departmentName,departmentDesc) values(?,?)";
		Object[] objects = { departmentName, departmentDesc };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		close_ResultSet(null);
		return b;
	}

	/**
	 * 修改部门信息
	 */
	@Override
	public boolean updateDepartment(Department department) {
		String departmentName = department.getDepartmentName();
		String departmentDesc = department.getDepartmentDesc();
		int departmentId = department.getDepartmentId();
		String sql = "update  department set departmentName=?,departmentDesc=? where departmentId=?";
		Object[] objects = { departmentName, departmentDesc, departmentId };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		close_ResultSet(null);
		return b;
	}

	/**
	 * 删除该部门
	 */
	@Override
	public boolean deleteDepartment(int departmentId) {
		String sql = "delete from department where departmentId=?";
		Object[] objects = { departmentId };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		close_ResultSet(null);
		return b;
	}

	/**
	 * 查询部门信息
	 */
	@Override
	public Department searchById(int departmentId) {
		Department department = null;
		String sql = "select departmentName,departmentDesc from department where departmentId=?";
		Object[] objects = { departmentId };
		ResultSet rs = execute_Query(sql, objects);
		try {
			if (rs.next()) {
				String departmentName = rs.getString("departmentName");
				String departmentDesc = rs.getString("departmentDesc");
				department = new Department(departmentId,departmentName, departmentDesc);
			} else {
				department = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return department;
	}
	/**
	 * 通过部门名称查询部门Id
	 */

	@Override
	public int searchByName(String departmentName) {
		System.out.println(departmentName);
		int departmentId=0;
		String sql="select departmentId from department where departmentName=?";
		Object[] objects= {departmentName};
		ResultSet rs = execute_Query(sql, objects);
		try {
			if(rs.next()) {
				departmentId=rs.getInt("departmentId");
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		
		return departmentId;
	}

}
