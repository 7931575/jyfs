package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.PostionCallDao;
import org.oa.controler.model.Position;

public class PostionCallImpl extends CRUD implements PostionCallDao {

	@Override
	public boolean updatePostion(Position position) {
		boolean b=false;
		int employeeId = position.getEmployeeId();
		int departmentId = position.getDepartmentId();
		int jobId = position.getJobId();
		String postionDescribe = position.getPostionDescribe();
		String oldDepartmentName = position.getOldDepartmentName();
		String oldJobName = position.getOldJobName();
		System.out.println(oldDepartmentName+" "+oldJobName);
		String sql="insert into positions(employeeId,departmentId,jobId,postionDescribe,oldDepartmentName,oldJobName,postionCreateTime) values(?,?,?,?,?,?,now())";
		Object[] objects= {employeeId,departmentId,jobId,postionDescribe,oldDepartmentName,oldJobName};
		boolean c = execute_Insert_Update_Delete(sql, objects);
		if(c) {
			sql="update employee set jobId=?,departmentId=? where employeeId=?";
			Object[] objects2= {jobId,departmentId,employeeId};
			boolean d = execute_Insert_Update_Delete(sql, objects2);
			if(d) {
				sql="update details set employeeJobId=?,employeeDepartmentId=? where employeeId=?";
				Object[] objects3= {jobId,departmentId,employeeId};
				boolean e = execute_Insert_Update_Delete(sql, objects3);
				if(e) {
					b=true;
				}
			}
			
		}
		return b;
	}

	@Override
	public Position searchByEmployeeId(int postionId) {
		Position position=null;
		 String sql="select departmentId,jobId,postionCreateTime,postionDescribe,oldDepartmentName,oldJobName,employeeId from positions where positionId=?";
		 Object[] objects= {postionId};
		 ResultSet rs = execute_Query(sql, objects);
		 try {
			if(rs.next()) {
				 int departmentId = rs.getInt("departmentId");
				 int jobId = rs.getInt("jobId");
				 int employeeId = rs.getInt("employeeId");
				 String postionCreateTime = rs.getString("postionCreateTime");
				 String postionDescribe = rs.getString("postionDescribe");
				 String oldDepartmentName = rs.getString("oldDepartmentName");
				 String oldJobName = rs.getString("oldJobName");
				 
				position=new Position(postionId, employeeId, departmentId, jobId, postionCreateTime, postionDescribe, oldDepartmentName, oldJobName, null, null);
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		
		return position;
	}

}
