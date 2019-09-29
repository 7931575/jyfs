package org.oa.controler.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oa.controler.Factory.Factory;
import org.oa.controler.iDao.Impl.BaseAllInforSplit;
import org.oa.controler.iDao.Impl.InforSelectAllSplit;
import org.oa.controler.iDao.Impl.MyEmplSearchNameSplit;
import org.oa.controler.iDao.inter.DepartmentDao;
import org.oa.controler.iDao.inter.GradeDao;
import org.oa.controler.iDao.inter.InforSelectDao;
import org.oa.controler.iDao.inter.JobDao;
import org.oa.controler.model.Department;
import org.oa.controler.model.Details;
import org.oa.controler.model.Employee;
import org.oa.controler.model.Job;

@WebServlet("/inforSelect")
public class InforSelect extends HttpServlet {
	String path = "";
	String op = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		op = request.getParameter("op");
		if (op == "endLine" || op.equals("endLine")) {
			this.search(request, response);
		} else if (op == "showDetail" || op.equals("showDetail")) {
			this.showDetail(request, response);
		} else if (op == "allInfor" || op.equals("allInfor")) {
			this.showAll(request, response);
		} else if (op == "searchByName" || op.equals("searchByName")) {
			this.searchByName(request, response);
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * 按照名字搜索下属
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void searchByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Factory factory = Factory.getFactory();
		JobDao jobDao = factory.getJobDao();
		GradeDao gradeDao = factory.getGradeDao();
		if (employee != null) {
			int departmentId = employee.getDepartmentId();
			Job job = jobDao.searchById(employee.getJobId());
			int grade = gradeDao.searchByGrade(job.getGradeId());

			String employeeName = request.getParameter("employeeName");
			String str = request.getParameter("cruentPage");
			DepartmentDao departmentDao = factory.getDepartmentDao();
			Department department = departmentDao.searchById(departmentId);
			String departmentName = department.getDepartmentName();

			int size = 5;
			int cruentPage = 1;
			if (str != null) {
				cruentPage = Integer.parseInt(str);
			}
			MyEmplSearchNameSplit emplSearchNameSplit = new MyEmplSearchNameSplit();
			int allPageNumber = emplSearchNameSplit.AllPageNumber(size, departmentId, grade, employeeName);
			int beginPage = emplSearchNameSplit.BeginPage(size, cruentPage);
			List<Employee> showList = emplSearchNameSplit.ShowList(size, beginPage, departmentId, grade, departmentName,
					employeeName);

			request.setAttribute("allPageNumber", allPageNumber);
			request.setAttribute("cruentPage", cruentPage);
			request.setAttribute("showList", showList);
			request.setAttribute("employeeName", employeeName);
			path = "MyEmploByName.jsp";

		} else {
			path = "login.jsp";
		}

	}

	/**
	 * 显示所有信息
	 */
	protected void showAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("cruentPage");

		int size = 5;
		int cruentPage = 1;
		if (str != null) {
			cruentPage = Integer.parseInt(str);
		}
		BaseAllInforSplit allInforSplit = new BaseAllInforSplit();
		int allPageNumber = allInforSplit.AllPageNumber(size);
		int beginPage = allInforSplit.BeginPage(size, cruentPage);
		List<Employee> showList = allInforSplit.ShowList(size, beginPage);

		request.setAttribute("allPageNumber", allPageNumber);
		request.setAttribute("cruentPage", cruentPage);
		request.setAttribute("showList", showList);

		path = "BaseAllInfor.jsp";

	}

	/**
	 * 
	 * 显示详细的信息
	 */

	protected void showDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(str);
		Factory factory = Factory.getFactory();
		InforSelectDao inforSelectDao = factory.getInforSelectDao();
		Details details = inforSelectDao.searchByEmployeeId(employeeId);
		int employeeDepartmentId = details.getEmployeeDepartmentId();
		int employeeJobId = details.getEmployeeJobId();
		DepartmentDao departmentDao = factory.getDepartmentDao();
		Department department = departmentDao.searchById(employeeDepartmentId);
		details.setDepartmentName(department.getDepartmentName());
		JobDao jobDao = factory.getJobDao();
		Job job = jobDao.searchById(employeeJobId);
		details.setJobName(job.getJobName());

		request.setAttribute("details", details);
		path = "CheckInfor.jsp";
	}

	/**
	 * 查询下属列表
	 */
	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Factory factory = Factory.getFactory();
		JobDao jobDao = factory.getJobDao();
		DepartmentDao departmentDao = factory.getDepartmentDao();

		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if (employee != null) {
			int departmentId = employee.getDepartmentId();
			int jobId = employee.getJobId();
			Job job = jobDao.searchById(jobId);
			GradeDao gradeDao = factory.getGradeDao();
			int grade = gradeDao.searchByGrade(job.getGradeId());
			Department department = departmentDao.searchById(departmentId);
			String departmentName = department.getDepartmentName();
			String str = request.getParameter("cruentPage");

			int size = 5;
			int cruentPage = 1;
			if (str != null) {
				cruentPage = Integer.parseInt(str);
			}
			InforSelectAllSplit allSplit = new InforSelectAllSplit();
			int allPageNumber = allSplit.AllPageNumber(size, departmentId, grade);
			int beginPage = allSplit.BeginPage(size, cruentPage);
			List<Employee> showList = allSplit.ShowList(size, beginPage, departmentId, grade, departmentName);

			request.setAttribute("allPageNumber", allPageNumber);
			request.setAttribute("cruentPage", cruentPage);
			request.setAttribute("showList", showList);
			path = "InforShowMy.jsp";
		} else {
			path = "login.jsp";
		}

	}

}
