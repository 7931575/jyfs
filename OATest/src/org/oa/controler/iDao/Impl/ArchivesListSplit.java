package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Archives;

public class ArchivesListSplit extends CRUD implements SplitDao<Archives> {

	@Override
	public int AllPageNumber(int size) {
		
		return 0;
	}
	
	public int AllPageNumber(int size,int employeeId) {
		int num = 0;
		String sql = "select  count(*) from archives  where employeeId=?";
		Object[] objects= {employeeId};
		
		ResultSet set = execute_Query(sql, objects);
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
	
	
	@Override
	public int BeginPage(int size, int cruentPage) {
		int xb = (cruentPage - 1) * size;
		return xb;
	}


	@Override
	public List<Archives> ShowList(int size, int cruentPage) {
		
		return null;
	}

	public List<Archives> ShowList(int size, int cruentPage,int employeeId) {
		List<Archives> list=new ArrayList<Archives>();
		String sql="select archivesId,title,createTime from archives where employeeId=? order by createTime desc limit ?,?";
		Object[] objects= {employeeId,cruentPage,size};
		ResultSet rs = execute_Query(sql, objects);
		
		try {
			while(rs.next()) {
			int archivesId=rs.getInt("archivesId");
			   String title = rs.getString("title");
			   String createTime = rs.getString("createTime");
			   Archives archives=new Archives(archivesId, employeeId, title, null, createTime, null);
			   list.add(archives);
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
