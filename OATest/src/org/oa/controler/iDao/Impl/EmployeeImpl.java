package org.oa.controler.iDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.oa.controler.Utils.CRUD;
import org.oa.controler.iDao.inter.EmployeeDao;
import org.oa.controler.model.Details;
import org.oa.controler.model.Employee;

public class EmployeeImpl extends CRUD implements EmployeeDao {
	/**
	 * 查看员工详细信息
	 */
	@Override
	public Details showEmployee(int employeeId) {
		Details details = null;
		String sql = "select d.*, year(now())-year(employeeBirthday) as age,e.employeeName,e.employeePassWord,e.employeeAccount from details d inner join employee e on d.employeeId=e.employeeId and d.employeeId=? ";
		Object[] objects = { employeeId };
		ResultSet rs = execute_Query(sql, objects);
		try {
			if (rs.next()) {
				String employeeName = rs.getString("employeeName");
				String employeeNation = rs.getString("employeeNation");
				String employeeAccount = rs.getString("employeeAccount");
				String employeePassWord = rs.getString("employeePassWord");
				int age = rs.getInt("age");
				int employeeGender = rs.getInt("employeeGender");
				String employeeIphone = rs.getString("employeeIphone");
				String employeeIdNumber = rs.getString("employeeIdNumber");
				String employeeAddress = rs.getString("employeeAddress");
				String employeeGraduateSchool = rs.getString("employeeGraduateSchool");
				String employeeEduBackground = rs.getString("employeeEduBackground");
				int employeeMarry = rs.getInt("employeeMarry");
				int employeeJobId = rs.getInt("employeeJobId");
				int employeeDepartmentId = rs.getInt("employeeDepartmentId");
				String employeeEntryTiime = rs.getString("employeeEntryTiime");
				String employeeHeadImg = rs.getString("employeeHeadImg");
				details = new Details(employeeId, employeeNation, employeeGender, age, employeeIdNumber, employeeIphone,
						employeeAddress, employeeEduBackground, employeeGraduateSchool, employeeJobId,
						employeeDepartmentId, employeeMarry, employeeEntryTiime, employeeName, employeePassWord,
						employeeAccount, employeeHeadImg);
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

	/**
	 * 增加新的员工详细信息
	 */
	@Override
	public boolean addEmployee(Details details) {
		boolean a = false;
		int employeeId = details.getEmployeeId();
		String employeeBirthday = details.getEmployeeBirthday();
		String employeeNation = details.getEmployeeNation();
		int employeeGender = details.getEmployeeGender();
		String employeeIdNumber = details.getEmployeeIdNumber();
		String employeeIphone = details.getEmployeeIphone();
		String employeeAddress = details.getEmployeeAddress();
		String employeeEduBackground = details.getEmployeeEduBackground();
		String employeeGraduateSchool = details.getEmployeeGraduateSchool();
		int employeeJobId = details.getEmployeeJobId();
		int employeeDepartmentId = details.getEmployeeDepartmentId();
		int employeeMarry = details.getEmployeeMarry();
		String employeeEntryTiime = details.getEmployeeEntryTiime();
		String employeeHeadImg = details.getEmployeeHeadImg();
		String sql = "insert into details(employeeId, employeeBirthday, employeeNation, employeeGender, employeeIdNumber,\r\n"
				+ "				employeeIphone, employeeAddress, employeeEduBackground, employeeGraduateSchool, employeeJobId,\r\n"
				+ "				employeeDepartmentId, employeeMarry, employeeEntryTiime,employeeHeadImg) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objects = { employeeId, employeeBirthday, employeeNation, employeeGender, employeeIdNumber,
				employeeIphone, employeeAddress, employeeEduBackground, employeeGraduateSchool, employeeJobId,
				employeeDepartmentId, employeeMarry, employeeEntryTiime, employeeHeadImg };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		if (b) {

			a = true;
		}
		return a;
	}

	/**
	 * 删除员工信息
	 */
	@Override
	public boolean deleteEmployee(int employeeId) {
		boolean b = false;
		String sql = "delete from details where employeeId=?";
		Object[] objects = { employeeId };
		boolean c = execute_Insert_Update_Delete(sql, objects);
		if (c) {
			sql = "delete from employee where employeeId=?";
			boolean d = execute_Insert_Update_Delete(sql, objects);
			if (d) {
				b = true;
			}
		}
		return b;
	}

	/**
	 * 添加员工基本信息
	 */
	@Override
	public int addBaseEmployeeInfor(Employee employee) {
		int employeeId = 0;
		int departmentId = employee.getDepartmentId();
		String employeeAccount = employee.getEmployeeAccount();
		String employeePassWord = employee.getEmployeePassWord();
		String employeeName = employee.getEmployeeName();
		int jobId = employee.getJobId();
		String sql = "insert into employee(departmentId,jobId,employeeName,employeePassWord,employeeAccount) values(?,?,?,?,?)";
		Object[] objects = { departmentId, jobId, employeeName, employeePassWord, employeeAccount };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		if (b) {
			sql = "select employeeId from employee order by employeeId desc limit 0,1";
			ResultSet rs = execute_Query(sql, null);
			try {
				if (rs.next()) {
					employeeId = rs.getInt("employeeId");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close_ResultSet(rs);
			}
		}
		return employeeId;
	}

	/**
	 * 修改员工信息
	 */
	@Override
	public boolean updateEmployee(Details details) {
		boolean a = false;
		String employeeAddress = details.getEmployeeAddress();
		int employeeId = details.getEmployeeId();
		String employeePassWord = details.getEmployeePassWord();
		int employeeMarry = details.getEmployeeMarry();
		String employeeIphone = details.getEmployeeIphone();
		String sql = "update employee set employeePassWord=? where employeeId=?";
		Object[] objects = { employeePassWord, employeeId };
		boolean b = execute_Insert_Update_Delete(sql, objects);
		if (b) {
			sql = "update details set employeeIphone=?,employeeAddress=?,employeeMarry=? where employeeId=?";
			Object[] object = { employeeIphone, employeeAddress, employeeMarry, employeeId };
			boolean c = execute_Insert_Update_Delete(sql, object);
			if (c) {
				a = true;
			}
		}
		return a;
	}

	/**
	 * 员工登录
	 */
	@Override
	public Employee login(Employee employee) {
		Employee employee2 =null;
		String employeeAccount = employee.getEmployeeAccount();
		String employeePassWord = employee.getEmployeePassWord();
		String sql="select employeeId,employeeName, departmentId,jobId from employee where employeeAccount=? and employeePassWord=?";
		Object[] objects= {employeeAccount,employeePassWord};
		ResultSet rs= execute_Query(sql, objects);
		try {
			if(rs.next()) {
				int employeeId = rs.getInt("employeeId");
				String employeeName = rs.getString("employeeName");
				int departmentId = rs.getInt("departmentId");
				int jobId = rs.getInt("jobId");
				employee2=new Employee(employeeId, departmentId, jobId, employeeName, employeePassWord, employeeAccount, null);
				
			}else {
				employee2=null;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close_ResultSet(rs);
		}
		return employee2;
	}

	@Override
	public boolean updatePass(Employee employee) {
		boolean b= false;
		int employeeId = employee.getEmployeeId();
		String employeePassWord = employee.getEmployeePassWord();
		String sql="update employee set employeePassWord=? where employeeId=?";
		Object[] objects= {employeePassWord,employeeId};
		boolean c = execute_Insert_Update_Delete(sql, objects);
		if(c) {
			b=true;
		}
		return b;
	}

}
