package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.GradeDao;

public class GradeImpl extends CRUD implements GradeDao {
  /**
   * 通过级别来查 级别所对应的Id
   */
	@Override
	public int getGrade(int grade) {
		int gradeId=0;
		String sql="select gradeId from grade where grade=?";
		Object[] objects= {grade};
		ResultSet rs = execute_Query(sql, objects);
		try {
			if(rs.next()) {
				gradeId=rs.getInt("gradeId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return gradeId;
	}

@Override
public int searchByGrade(int gradeId) {
	int grade=0;
	String sql="select grade from grade where gradeId=?";
	Object[] objects= {gradeId};
	ResultSet rs = execute_Query(sql, objects);
	try {
		if(rs.next()) {
			grade=rs.getInt("grade");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close_ResultSet(rs);
	}
	return grade;
}

}
