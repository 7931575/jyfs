package org.oa.controler.dwr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;

public class GradeDwr extends CRUD{

	 public List<Integer> getGrade(){
		 List<Integer> list=new ArrayList<Integer>();
		  String sql="select grade from grade";
		 ResultSet rs = execute_Query(sql, null);
		 try {
			while(rs.next()) {
				  int grade = rs.getInt("grade");
				  list.add(grade);
			 }
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		 return list;
	 }
}
