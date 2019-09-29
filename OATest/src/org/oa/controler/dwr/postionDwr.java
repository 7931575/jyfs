package org.oa.controler.dwr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.model.Job;
public class postionDwr extends CRUD {

	 public List<String> getPostion(String departmentName){
		 List<String> list=new ArrayList<String>();
		 String sql="select departmentId from department where departmentName=?";
		Object[] object= {departmentName};
		
		 ResultSet set = execute_Query(sql, object);
		 try {
			if(set.next()) {
				 int departmentId=set.getInt("departmentId");
				 sql="select jobName from job where departmentId=?";
					Object[] objects= {departmentId};
					 ResultSet rs = execute_Query(sql, objects);
					 while(rs.next()) {
							String string = rs.getString("jobName");
							list.add(string);
						 }
					 
			 }
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} 
		
		
		 return list;
	 }
	 public List<Job> getPostionObj(int departmentId){
		 List<Job> list=new ArrayList<Job>();
		 String sql="select jobId,jobName from job where departmentId=?";
		Object[] object= {departmentId};
		
		 ResultSet rs = execute_Query(sql, object);
		try {
			while(rs.next()) {
				int jobId = rs.getInt("jobId");
				String jobName=rs.getString("jobName");
				Job job=new Job(jobId, departmentId, 0, jobName, null, null);
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
