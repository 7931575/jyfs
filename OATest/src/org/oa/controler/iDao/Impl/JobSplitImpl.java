package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Job;

public class JobSplitImpl extends CRUD implements SplitDao<Job> {

	/**
	 * 获得总页数
	 **/
	@Override
	public int AllPageNumber(int size) {
		int num = 0;
		String sql = "select count(*) from job ";
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
		List<Job> list = new ArrayList<Job>();
		String sql = "select j.*,d.departmentName from job j inner join department d on d.departmentId=j.departmentId  limit ?,? ";
		Object[] objects = { cruentPage, size };
		ResultSet rs = execute_Query(sql, objects);
		try {
			while (rs.next()) {				
				String departmentName = rs.getString("departmentName");
				 int jobId = rs.getInt("jobId");
					String jobName= rs.getString("jobName");
					
			
				Job job=new Job(jobId, 0, 0, jobName, null, departmentName);
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
