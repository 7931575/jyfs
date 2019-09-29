package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Employee;
import org.oa.controler.model.Limit;

public class AllLimitsSplits extends CRUD implements SplitDao<Limit> {
	/**
	 * 获得总页数
	 **/
	@Override
	public int AllPageNumber(int size) {
		int num = 0;
		String sql = "select  count(*) from limits ";
		
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
	public List<Limit> ShowList(int size, int cruentPage) {
		List<Limit> list = new ArrayList<Limit>();
		String sql = "select limitId,limitName,limitDesc from limits limit ?,?";
		Object[] objects = { cruentPage, size };
		ResultSet rs = execute_Query(sql, objects);
		try {
			while (rs.next()) {
				int limitId = rs.getInt("limitId");
				String limitName = rs.getString("limitName");
				String limitDesc = rs.getString("limitDesc");
			Limit limit=new Limit(limitId, limitName, limitDesc);	
			 list.add(limit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return list;
	}
}
