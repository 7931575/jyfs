package org.oa.controler.iDao.inter;
import org.oa.controler.model.Department;

public interface DepartmentDao {

	 public boolean addDepartment(Department department);
	 public boolean updateDepartment(Department department);
	 public boolean deleteDepartment(int departmentId);
	 public Department searchById(int departmentId);
	 public int searchByName(String departmentName);
	 
}
