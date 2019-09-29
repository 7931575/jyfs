package org.oa.controler.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oa.controler.Factory.Factory;
import org.oa.controler.iDao.Impl.EmployeeDepartSplit;
import org.oa.controler.iDao.Impl.EmployeeNameSplit;
import org.oa.controler.iDao.Impl.EmployeeShowSplit;
import org.oa.controler.iDao.inter.DepartmentDao;
import org.oa.controler.iDao.inter.EmployeeDao;
import org.oa.controler.iDao.inter.JobDao;
import org.oa.controler.model.Department;
import org.oa.controler.model.Details;
import org.oa.controler.model.Employee;
import org.oa.controler.model.Job;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/employeeServer")
public class EmplyeeServer extends HttpServlet {
	String path = "";
	String op = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op == "addEmployee" || op.equals("addEmployee")) {
			this.addEmployee(request, response);
		}else if(op=="show" || op.equals("show")) {
			this.allShow(request, response);
		}else if(op=="delete" ||op.equals("delete")) {
			 this.deleteEmployee(request, response);
		}else if(op=="update"||op.equals("update")) {
		  this.update(request, response);
		}else if(op=="showInfor"||op.equals("showInfor")) {
			this.showInfor(request, response);
		}else if(op=="doUpdate"||op.equals("doUpdate")) {
			this.updateEmployee(request, response);
		}else if(op=="searchName"||op.equals("searchName")){
			this.searchByName(request, response);
		}else if(op=="searchByDepartmentName"||op.equals("searchByDepartmentName")) {
			this.searchByDepartmentName(request, response);
		}else if(op=="login"||op.equals("login")) {
			this.doLogin(request, response);
		}else if(op=="personInfor"||op.equals("personInfor")) {
			this.personInfor(request, response);
		}else if(op=="updatePass"||op.equals("updatePass")){
			this.updatePass(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	

	/**
	 * 修改密码
	 */
	protected void updatePass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      String employeePassWord = request.getParameter("newPassWord");
	        Employee employe = (Employee) request.getSession().getAttribute("employee");
	      
	        if(employe!=null) {
	        	  Employee employee=new Employee(employe.getEmployeeId(), 0, 0, null, employeePassWord, null, null);
	        	Factory factory=Factory.getFactory();
	        	EmployeeDao employeeDao = factory.getEmployeeDao();
	        	boolean b = employeeDao.updatePass(employee);
	        	if(b) {
	        		path="employeeServer?op=personInfor";
	        	}else {
	        		path="login.jsp";
	        	}
       	
	        	
	        }else{
	        	path="login.jsp";
	        }
	      
		
	}
	/*
	 * 员工登录
	 */
	protected void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 String employeeAccount=request.getParameter("employeeAccount");
	 String employeePassWord=request.getParameter("employeePassWord");
	    Factory factory=Factory.getFactory();
	    EmployeeDao employeeDao = factory.getEmployeeDao();
	    Employee employee=new Employee(0, 0, null, employeePassWord, employeeAccount, null);
	    Employee login = employeeDao.login(employee);
	    
	    if(login!=null) {
	    	request.getSession().setAttribute("employee", login);
	    	path="sy.jsp";
	    }else {
	    	path="login.jsp";
	    }
	}
	/**
	 *查询个人信息 
	 */
	

	protected void personInfor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee!=null) {
			Factory factory=Factory.getFactory();
			EmployeeDao employeeDao = factory.getEmployeeDao();
			Details details = employeeDao.showEmployee(employee.getEmployeeId());
			request.setAttribute("details", details);
			path="PersonInfo.jsp";	
		}else {
			path="login.jsp";	
		}
		
	}
	/**
	 *通过部门查询员工信息 
	 */
	protected void searchByDepartmentName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departmentName = request.getParameter("departmentName");
		 String str = request.getParameter("cruentPage");
		   int cruentPage=1;
		   int size=5;
		   if(str!=null) {
			   cruentPage=Integer.parseInt(str);
		   }
		EmployeeDepartSplit departSplit=new EmployeeDepartSplit();
		int allPageNumber = departSplit.AllPageNumber(size, departmentName);
		int beginPage = departSplit.BeginPage(size, cruentPage);
		List<Employee> showList = departSplit.ShowList(size,beginPage, departmentName);
		   request.setAttribute("showList", showList);
		   request.setAttribute("allPageNumber", allPageNumber);
		   request.setAttribute("cruentPage", cruentPage);
		   request.setAttribute("departmentName", departmentName);
		   path="ShowInforByDepartment.jsp";
	}
	/**
	 * 通过名字查询员工信息
	 */
	protected void searchByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String employeeName = request.getParameter("employeeName");
		   String str = request.getParameter("cruentPage");
		   int cruentPage=1;
		   int size=5;
		   if(str!=null) {
			   cruentPage=Integer.parseInt(str);
		   }
		   EmployeeNameSplit employeeNameSplit=new EmployeeNameSplit();
		   int allPageNumber = employeeNameSplit.AllPageNumber(size, employeeName);
		 
		  int beginPage = employeeNameSplit.BeginPage(size, cruentPage);
		   List<Employee> showlist = employeeNameSplit.ShowList(size, beginPage, employeeName);
		  
		  request.setAttribute("showList", showlist);
		   request.setAttribute("allPageNumber", allPageNumber);
		   request.setAttribute("cruentPage", cruentPage);
		   request.setAttribute("employeeName", employeeName);
		   path="ShowInforByName.jsp";
		   
		  
	}
	/**
	 * 修改员工信息
	 */
	protected void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(str);
		String employeeIphone = request.getParameter("employeeIphone");
		String employeePassWord =request.getParameter("employeePassWord");
		String employeeAddress =request.getParameter("employeeAddress");
		String jh = request.getParameter("jh");
		int marry = Integer.parseInt(jh);
		Details details=new Details(employeeId, employeeIphone, employeeAddress, marry, employeePassWord);
		Factory factory=Factory.getFactory();
		EmployeeDao employeeDao = factory.getEmployeeDao();
		boolean b = employeeDao.updateEmployee(details);
		if(b) {
			path="employeeServer?op=showInfor&employeeId="+employeeId;
		}else {
			path="login.jsp";
		}
		
	}

	/**
	 * 显示员工详细信息
	 */
	protected void showInfor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String string = request.getParameter("employeeId");
		  int employeeId = Integer.parseInt(string);
		  Factory factory=Factory.getFactory();
		EmployeeDao employeeDao = factory.getEmployeeDao();
		Details details = employeeDao.showEmployee(employeeId);
		DepartmentDao departmentDao = factory.getDepartmentDao();
		JobDao jobDao = factory.getJobDao();
		Job job = jobDao.searchById(details.getEmployeeJobId());
		Department department = departmentDao.searchById(details.getEmployeeDepartmentId());
		details.setDepartmentName(department.getDepartmentName());
		details.setJobName(job.getJobName());		
		request.setAttribute("details", details);
		path="PersonInforShow.jsp";
	}
	/**
	 * 更新前的回显
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String employeeid = request.getParameter("employeeId");
	      int employeeId=Integer.parseInt(employeeid);
		 Factory factory=Factory.getFactory();
		 EmployeeDao employeeDao = factory.getEmployeeDao();
		 Details details = employeeDao.showEmployee(employeeId);
		 DepartmentDao departmentDao = factory.getDepartmentDao();
			JobDao jobDao = factory.getJobDao();
	
			Job job = jobDao.searchById(details.getEmployeeJobId());
			Department department = departmentDao.searchById(details.getEmployeeDepartmentId());
			details.setDepartmentName(department.getDepartmentName());
			details.setJobName(job.getJobName());		
		 
		
		 request.setAttribute("details", details);
	      path="PersonUpdateInfo.jsp";
	}
	/**
	 * 根据员工id删除员工信息
	 */

	protected void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String employeeid = request.getParameter("employeeId");
		 String name = request.getParameter("employeeName");
		 String dname = request.getParameter("departmentName");
	      int employeeId=Integer.parseInt(employeeid);
		 Factory factory=Factory.getFactory();
		 EmployeeDao employeeDao = factory.getEmployeeDao();
		 boolean b = employeeDao.deleteEmployee(employeeId);
		 
		 if(b) {
			 if(name!=null) {
				 path="employeeServer?op=searchName&employeeName="+name;
			 }else if(dname!=null){
				 path="employeeServer?op=searchByDepartmentName&departmentName="+dname;
			 }else {
				 path="employeeServer?op=show";
			 }
			
		 }else {
			 path="login.jsp";
		 }
		 
		 
	}

	/**
	 * 显示员工所有信息
	 */

	protected void allShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeShowSplit employeeShowSplit=new EmployeeShowSplit();
		String str = request.getParameter("cruentPage");
		int cruentPage=1;
		int size=5;
		if(str!=null) {
			cruentPage=Integer.parseInt(str);
		}
		int allPageNumber = employeeShowSplit.AllPageNumber(size);
		int beginPage = employeeShowSplit.BeginPage(size, cruentPage);
		List<Employee> showList = employeeShowSplit.ShowList(size, beginPage);
		    request.setAttribute("allPageNumber", allPageNumber);
		    request.setAttribute("cruentPage", cruentPage);
		    request.setAttribute("showList", showList);
		    path="ShowPersonInfo.jsp";
	  }
	/**
	 * 添加员工
	 */
	protected void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(getServletConfig(), request, response);
		try {
			smartUpload.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		long currentTimeMillis=0;
		String name = null;
		Request requestS = smartUpload.getRequest();
		Files files = smartUpload.getFiles();
		for (int i = 0; i < 1; i++) {
			File file = files.getFile(i);
			name = file.getFileName();
			try {
			currentTimeMillis = System.currentTimeMillis();
				
				file.saveAs("img/" + currentTimeMillis+name, SmartUpload.SAVE_VIRTUAL);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}

		}
		String employeeName = requestS.getParameter("employeeName");
		String employeeNation = requestS.getParameter("employeeNation");
		String employeeAccount = requestS.getParameter("employeeAccount");
		String employeePassWord = requestS.getParameter("employeePassWord");
		String employeeBirthday = requestS.getParameter("employeeBirthday");
		String sex = requestS.getParameter("sex");
		int gender = Integer.parseInt(sex);
		String employeeIphone = requestS.getParameter("employeeIphone");
		String employeeIdNumber = requestS.getParameter("employeeIdNumber");
		String employeeAddress = requestS.getParameter("employeeAddress");
		String jh = requestS.getParameter("jh");
		int JH = Integer.parseInt(jh);
		String employeeEduBackground = requestS.getParameter("employeeEduBackground");		
		String department = requestS.getParameter("departmentId");	
		int departmenId = Integer.parseInt(department);
		String employeeGraduateSchool =requestS.getParameter("employeeGraduateSchool");
		String job = requestS.getParameter("jobId");	
		int jobId = Integer.parseInt(job);
		String employeeEntryTiime = requestS.getParameter("employeeEntryTiime");
         
    	Employee employee=new Employee(departmenId, jobId, employeeName, employeePassWord, employeeAccount, null);
    		Factory factory=Factory.getFactory();
    		EmployeeDao employeeDao = factory.getEmployeeDao();
    		int employeeId = employeeDao.addBaseEmployeeInfor(employee);
	       Details details=new Details(employeeId, employeeBirthday, employeeNation, gender, 0, employeeIdNumber, employeeIphone, employeeAddress, employeeEduBackground, employeeGraduateSchool, jobId, departmenId, JH, employeeEntryTiime, "img/" + currentTimeMillis+name, employeeName, employeePassWord, employeeAccount);
            boolean b = employeeDao.addEmployee(details);
            if(b) {
            	path="employeeServer?op=show";
            }else {
            	path="login.jsp";
            }
	}

}
