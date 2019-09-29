package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.LimitDao;
import org.oa.controler.model.Limit;

public class LimitImpl extends CRUD implements LimitDao {

	@Override
	public boolean updateLimit(Limit limit) {
		int limitId = limit.getLimitId();
		String limitName = limit.getLimitName();
		String limitDesc = limit.getLimitDesc();
		String sql = "update limits set limitName=?,limitDesc=? where limitId=?";
		Object[] objects = { limitName, limitDesc, limitId };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		close_ResultSet(null);
		return b;
	}

	@Override
	public Limit searchById(int limitId) {
		Limit limit = null;
		String sql = "select limitName,limitDesc from limits where limitId=?";
		Object[] objects = { limitId };
		ResultSet rs = execute_Query(sql, objects);
		try {
			if (rs.next()) {
				String limitName = rs.getString("limitName");
				String limitDesc = rs.getString("limitDesc");
				limit = new Limit(limitId, limitName, limitDesc);
			} else {
				limit = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return limit;
	}

	@Override
	public boolean deleteLimit(int limitId) {
		String sql = "delete from limits where limitId=?";
		Object[] objects = { limitId };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		close_ResultSet(null);
		return b;
	}

	@Override
	public boolean addLimit(Limit limit) {
		String limitName = limit.getLimitName();
		String limitDesc = limit.getLimitDesc();
		String sql="insert into limits(limitName,limitDesc)  values(?,?)";
		Object[] objects = {limitName, limitDesc};
		 boolean b = execute_Insert_Update_Delete(sql, objects);
		return b;
	}

}
