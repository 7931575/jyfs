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
	 * @param sql SQL��䣬��SQL����������PreparedStatement�Ĳ�����ʽ
	 * @param objects objects�еĲ��������SQL����е��ʺ�һһ��Ӧ
	 * @return �ɹ�����trueʧ�ܷ���false
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
	 * ר�����ڹر�execute_query��������֮���ResultSet
	 * @param rs
	 */
	public void close_ResultSet(ResultSet rs) {
		close(rs, pstmt, con);
	}
	
}




























