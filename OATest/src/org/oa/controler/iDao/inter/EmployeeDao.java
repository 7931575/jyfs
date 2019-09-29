package org.oa.controler.iDao.inter;
import org.oa.controler.model.Details;
import org.oa.controler.model.Employee;

public interface EmployeeDao {
 
	 public  Details showEmployee(int employeeId);
	 public boolean addEmployee(Details details);
	 public boolean deleteEmployee(int employeeId);
	 public int addBaseEmployeeInfor( Employee employee); 
	 public boolean updateEmployee(Details details);
	 public Employee login(Employee employee);
	 public boolean updatePass(Employee employee);
}
