package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.JobDao;
import org.oa.controler.model.Job;

public class JobImpl extends CRUD implements JobDao {
	
	/**
	 * 通过Id查询工作
	 */
	@Override
	public Job searchById(int JobId) {
		Job job = null;
		String sql = "select j.*,d.departmentName from job j inner join department d on d.departmentId=j.departmentId and j.jobId=?";
		Object[] objects = { JobId };
		ResultSet rs = execute_Query(sql, objects);
		try {
			if (rs.next()) {
				String jobName = rs.getString("jobName");
				String jobDesc = rs.getString("jobDesc");
				int gradeId = rs.getInt("gradeId");
				String departmentName = rs.getString("departmentName");
				job = new Job(JobId, 0, gradeId, jobName, jobDesc, departmentName);

			} else {
				job = null;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}

		return job;
	}

	/**
	 * 通过id删除
	 */
	@Override
	public boolean deleteById(int JobId) {
		String sql = "delete from job where jobId=?";
		Object[] objects = { JobId };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		return b;
	}

	/**
	 * 添加新的职务
	 */
	@Override
	public boolean addJob(Job job) {
		String jobName = job.getJobName();
		String jobDesc = job.getJobDesc();
		int departmentId = job.getDepartmentId();
		int gradeId = job.getGradeId();
		String sql = "insert into job(jobName,jobDesc,departmentId,gradeId) values(?,?,?,?)";
		Object[] objects = { jobName, jobDesc, departmentId, gradeId };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		return b;
	}

	/**
	 * 修改职务
	 */
	@Override
	public boolean updateJob(Job job) {
		String jobName = job.getJobName();
		String jobDesc = job.getJobDesc();
		int departmentId = job.getDepartmentId();
		int gradeId = job.getGradeId();
		int jobId = job.getJobId();
		String sql = "update job set jobName=?,jobDesc=?,departmentId=?,gradeId=? where jobId=?";
		Object[] objects = { jobName, jobDesc, departmentId, gradeId, jobId };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		return b;
	}
 
}
