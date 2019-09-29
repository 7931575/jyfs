package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Department;

public class DepartmentSplitImpl extends CRUD implements SplitDao<Department> {
	/**
	 * 获得总页数
	 **/
	@Override
	public int AllPageNumber(int size) {
		int num = 0;
		String sql = "select count(*) from department ";
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
	public List<Department> ShowList(int size, int cruentPage) {
		List<Department> list = new ArrayList<Department>();
		String sql = "select departmentId,departmentName,departmentDesc from department limit ?,? ";
		Object[] objects = { cruentPage, size };
		ResultSet rs = execute_Query(sql, objects);
		try {
			while (rs.next()) {
				int departmentId = rs.getInt("departmentId");
				String departmentName = rs.getString("departmentName");
				String departmentDesc = rs.getString("departmentDesc");
				Department department = new Department(departmentId, departmentName, departmentDesc);
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
