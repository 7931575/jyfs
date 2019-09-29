package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.ArchivesDao;
import org.oa.controler.model.Archives;

public class ArchivesImpl extends CRUD implements ArchivesDao {
	/**
	 * 添加档案
	 */
	@Override
	public boolean addArchives(Archives archives) {
		boolean b = false;
		int employeeId = archives.getEmployeeId();
		String title = archives.getTitle();
		String content = archives.getContent();
		String sql = "insert into archives(employeeId,title,content,createTime) values(?,?,?,now())";
		Object[] objects = { employeeId, title, content };
		boolean c = execute_Insert_Update_Delete(sql, objects);
		if (c) {
			b = true;
		}

		return b;

	}

	/**
	 * 删除档案
	 */
	@Override
	public boolean deleteArchives(int archivesId) {
		boolean b = false;
		String sql = "delete from archives where archivesId=?";
		Object[] objects = { archivesId };
		boolean c = execute_Insert_Update_Delete(sql, objects);
		if (c) {
			b = true;
		}
		return b;
	}

	/**
	 * 更新档案
	 */
	@Override
	public boolean updateArchives(Archives archives) {
		boolean b = false;
		int archivesId = archives.getArchivesId();
		String title = archives.getTitle();
		String content = archives.getContent();
		String sql = "update archives set title=?,content=? where archivesId=?";
		Object[] objects = { title, content, archivesId };
		boolean c = execute_Insert_Update_Delete(sql, objects);
		if (c) {
			b = true;
		}
		return b;
	}

	/**
	 * 搜寻档案
	 */
	@Override
	public Archives searchById(int archivesId) {
		Archives archives = null;
		String sql = "select employeeId,createTime,title,content from archives where archivesId=?";
		Object[] objects = { archivesId };
		ResultSet rs = execute_Query(sql, objects);
		try {
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String createTime = rs.getString("createTime");
				int employeeId = rs.getInt("employeeId");
				archives = new Archives(archivesId,employeeId, title, content, createTime, null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return archives;
	}

}
