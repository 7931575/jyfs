package org.oa.controler.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD extends DbUtils{
	
	private static Connection con ;
	private static PreparedStatement pstmt = null;
	

	/**
	 * 
	 * @param sql SQL语句，该SQL语句必须满足PreparedStatement的操作格式
	 * @param objects objects中的参数必须和SQL语句中的问号一一对应
	 * @return 成功返回true失败返回false
	 * insert into human (humanName , humanPass) values (?,?)
	 * object[] objects = {"admin" , "china"};
	 */
	public boolean execute_Insert_Update_Delete(String sql , Object[] objects) {
		boolean b = false;
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			if(objects != null) {
				for(int i = 0 ; i < objects.length ; i++) {
					pstmt.setObject(i + 1 , objects[i]);
				}
			}
			int row = pstmt.executeUpdate();
			if(row > 0) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(null, pstmt, con);
		}
		return b;
	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet execute_Query(String sql , Object[] objects) {
		ResultSet rs = null;
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			if(objects != null) {
				for(int i = 0 ; i < objects.length ; i++) {
					pstmt.setObject(i + 1, objects[i]);
				}
			}
			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 专门用于关闭execute_query方法操作之后的ResultSet
	 * @param rs
	 */
	public void close_ResultSet(ResultSet rs) {
		close(rs, pstmt, con);
	}
	
}




























