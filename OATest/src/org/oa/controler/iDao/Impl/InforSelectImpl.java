package org.oa.controler.iDao.Impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.InforSelectDao;
import org.oa.controler.model.Details;


public class InforSelectImpl extends CRUD implements InforSelectDao {

	

	@Override
	public Details searchByEmployeeId(int employeeId) {
		Details details = null;
		String sql = "select d.employeeIphone,employeeJobId,employeeDepartmentId,year(now())-year(employeeEntryTiime) as workAge,year(now())-year(employeeBirthday) as age,e.employeeName,e.employeeAccount from details d inner join employee e on d.employeeId=e.employeeId and d.employeeId=? ";
		Object[] objects = { employeeId};
		ResultSet rs = execute_Query(sql, objects);
		try {
			if (rs.next()) {
				String employeeName = rs.getString("employeeName");
			
				String employeeAccount = rs.getString("employeeAccount");
				int workAge = rs.getInt("workAge");
				int age = rs.getInt("age");
				
				String employeeIphone = rs.getString("employeeIphone");
				int employeeJobId = rs.getInt("employeeJobId");
				int employeeDepartmentId = rs.getInt("employeeDepartmentId");
				details=new Details(employeeId, age, employeeIphone, employeeJobId, employeeDepartmentId, employeeName, employeeAccount, workAge);
			
				
			} else {
				details = null;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return details;
	}

}
