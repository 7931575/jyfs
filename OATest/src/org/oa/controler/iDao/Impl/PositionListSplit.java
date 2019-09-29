package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Position;

public class PositionListSplit extends CRUD implements SplitDao<Position> {

	@Override
	public int AllPageNumber(int size) {

		return 0;
	}

	public int AllPageNumber(int size, int employeeId) {
		int num = 0;
		String sql = "select  count(*) from positions  where employeeId=?";
		Object[] objects = { employeeId };

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
	public List<Position> ShowList(int size, int cruentPage) {

		return null;
	}

	public List<Position> ShowList(int size, int cruentPage, int employeeId) {
		List<Position> list = new ArrayList<Position>();
		String sql = "select  positionId ,employeeId,postionCreateTime from positions where employeeId=? order by postionCreateTime desc limit ?,?";
		Object[] objects = { employeeId, cruentPage, size };
		String employeeName="";
		ResultSet rs = execute_Query(sql, objects);
		sql="select employeeName from employee where employeeId=?";
		Object[] objects2= {employeeId};
		ResultSet rm = execute_Query(sql, objects2);
		try {
			if(rm.next()) {
				employeeName=rm.getString("employeeName");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				int positionId = rs.getInt("positionId");			
				String postionCreateTime = rs.getString("postionCreateTime");
				Position position=new Position(positionId, employeeId, 0, 0, postionCreateTime, null, null, null, null, null);
				position.setEmployeeName(employeeName);
				list.add(position);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
