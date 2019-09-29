package org.oa.controler.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oa.controler.Factory.Factory;
import org.oa.controler.iDao.Impl.PositionByNameSplit;
import org.oa.controler.iDao.Impl.PositionListSplit;
import org.oa.controler.iDao.Impl.PositionsAllSplit;
import org.oa.controler.iDao.inter.DepartmentDao;
import org.oa.controler.iDao.inter.EmployeeDao;
import org.oa.controler.iDao.inter.JobDao;
import org.oa.controler.iDao.inter.PostionCallDao;
import org.oa.controler.model.Department;
import org.oa.controler.model.Details;
import org.oa.controler.model.Employee;
import org.oa.controler.model.Job;
import org.oa.controler.model.Position;

@WebServlet("/postionCallServer")
public class PostionCallServer extends HttpServlet {
	String op = "";
	String path = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		op = request.getParameter("op");
		if (op == "insert" || op.equals("insert")) {
			this.callPosition(request, response);
		} else if (op == "showAll" || op.equals("showAll")) {
			this.allPositionCall(request, response);
		} else if (op == "showDetail" || op.equals("showDetail")) {
			this.showList(request, response);
		} else if (op == "employeePostionDeatil" || op.equals("employeePostionDeatil")) {
			this.showOneDetail(request, response);
		}else if(op=="searchByName"||op.equals("searchByName")) {
			this.searchByName(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);

	}
	/**
	 * 通过员工名字查询记录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void searchByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  String employeeName = request.getParameter("employeeName");
	  int size=5;
	  int cruentPage=1;
	  String string = request.getParameter("cruentPage");
	  if(string!=null) {
		  cruentPage=Integer.parseInt(string);
	  }
	  PositionByNameSplit byNameSplit=new PositionByNameSplit();
	  int allPageNumber = byNameSplit.AllPageNumber(size, employeeName);
	  int beginPage = byNameSplit.BeginPage(size, cruentPage);
	  List<Employee> showList = byNameSplit.ShowList(size, beginPage, employeeName);
	  
	  request.setAttribute("cruentPage", cruentPage);
	  request.setAttribute("allPageNumber",allPageNumber);
	  request.setAttribute("showList",showList);
	  request.setAttribute("employeeName",employeeName);
	  path="PostionSearchByName.jsp";
		
	}

	/**
	 * 查看某条详细记录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showOneDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = request.getParameter("positionId");
		Factory factory = Factory.getFactory();
		PostionCallDao postion = factory.getPostion();
		int postionId = Integer.parseInt(string);
		Position position = postion.searchByEmployeeId(postionId);

		int jobId = position.getJobId();
		int departmentId = position.getDepartmentId();
		JobDao jobDao = factory.getJobDao();
		Job job = jobDao.searchById(jobId);

		DepartmentDao departmentDao = factory.getDepartmentDao();
		Department department = departmentDao.searchById(departmentId);
		position.setNewJobName(job.getJobName());
		position.setNewDepartmentName(department.getDepartmentName());

		request.setAttribute("position", position);
		path = "CheckPostion.jsp";
	}

	/*
	 * 显示某一员工的所有岗位调用记录清单
	 */
	protected void showList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(string);
		String str = request.getParameter("cruentPage");
		int cruentPage = 1;
		int size = 5;
		if (str != null) {
			cruentPage = Integer.parseInt(str);
		}
		PositionListSplit listSplit = new PositionListSplit();
		int allPageNumber = listSplit.AllPageNumber(size, employeeId);
		int beginPage = listSplit.BeginPage(size, cruentPage);
		List<Position> showList = listSplit.ShowList(size, beginPage, employeeId);
		request.setAttribute("showList", showList);
		request.setAttribute("allPageNumber", allPageNumber);
		request.setAttribute("cruentPage", cruentPage);
		request.setAttribute("employeeId", employeeId);
		path = "ShowPositionDetail.jsp";
	}

	/*
	 * 显示所有员工的岗位调用记录
	 */
	protected void allPositionCall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("cruentPage");
		int cruentPage = 1;
		int size = 5;
		if (str != null) {
			cruentPage = Integer.parseInt(str);
		}
		PositionsAllSplit allSplit = new PositionsAllSplit();
		int allPageNumber = allSplit.AllPageNumber(size);
		int beginPage = allSplit.BeginPage(size, cruentPage);
		List<Employee> showList = allSplit.ShowList(size, beginPage);

		request.setAttribute("showList", showList);
		request.setAttribute("allPageNumber", allPageNumber);
		request.setAttribute("cruentPage", cruentPage);
		path = "ShowMyEmplyee.jsp";

	}

	/**
	 * 调职位
	 */

	protected void callPosition(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldDepartment = request.getParameter("departmentId");
		int oldDepartmentId = Integer.parseInt(oldDepartment);
		Factory factory = Factory.getFactory();
		DepartmentDao departmentDao = factory.getDepartmentDao();
		Department searchById = departmentDao.searchById(oldDepartmentId);
		/*---*/ String oldDepartmentName = searchById.getDepartmentName();
		String string = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(string);
		EmployeeDao employeeDao = factory.getEmployeeDao();
		Details details = employeeDao.showEmployee(employeeId);
		int employeeJobId = details.getEmployeeJobId();
		JobDao jobDao = factory.getJobDao();
		Job searchById2 = jobDao.searchById(employeeJobId);
		String oldJobName = searchById2.getJobName();
		String parameter = request.getParameter("newDepartmentName");
		int newDepartmentId = Integer.parseInt(parameter);
		String string2 = request.getParameter("newJobName");
		int newJobId = Integer.parseInt(string2);
		String desc = request.getParameter("desc");
		Position position = new Position(employeeId, newDepartmentId, newJobId, desc, oldDepartmentName, oldJobName);
		PostionCallDao postion = factory.getPostion();
		boolean b = postion.updatePostion(position);
		if (b) {
			path = "postionCallServer?op=showDetail&employeeId=" + employeeId;
		} else {
			path = "login.jsp";
		}
	}
}
