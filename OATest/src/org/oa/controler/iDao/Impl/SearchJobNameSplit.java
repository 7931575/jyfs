package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Job;

public class SearchJobNameSplit extends CRUD implements SplitDao<Job> {

	/**
	 * 获得总页数
	 **/
	@Override
	public int AllPageNumber(int size) {
		
		return 0;
	}
	public int AllPageNumber(int size,String departmentName) {
		String sql = "select count(*) from job j inner join department d on d.departmentId=j.departmentId and d.departmentName like '%"+departmentName+"%'";
	int num=0;
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
	public List<Job> ShowList(int size, int cruentPage) {
		
		return null;
	}
	public List<Job> ShowList(int size, int cruentPage,String departmentName) {
		List<Job> list = new ArrayList<Job>();
		String sql = "select j.*,d.departmentName from job j inner join department d on d.departmentId=j.departmentId and d.departmentName like '%"+departmentName+"%' limit ?,?";
		Object[] objects = { cruentPage, size };
		ResultSet rs = execute_Query(sql, objects);
		try {
			while (rs.next()) {				
				String department = rs.getString("departmentName");
				 int jobId = rs.getInt("jobId");
					String jobName= rs.getString("jobName");
					
			
				Job job=new Job(jobId, 0, 0, jobName, null, department);
				list.add(job);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return list;
	}

}
