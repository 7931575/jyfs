package org.oa.controler.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oa.controler.Factory.Factory;
import org.oa.controler.iDao.Impl.DepartmentSplitImpl;
import org.oa.controler.iDao.inter.DepartmentDao;
import org.oa.controler.iDao.inter.SplitDao;
import org.oa.controler.model.Department;

@WebServlet("/deparementServer")
public class DeparementServer extends HttpServlet {
	String op = "";
	String path = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		op = request.getParameter("op");
		if (op == "show" || op.equals("show")) {
			this.show(request, response);
		} else if (op == "add" || op.equals("add")) {
			this.addDepartment(request, response);
		} else if (op == "update" || op.equals("update")) {
			this.update(request, response);
		}else if(op=="doUpdate" || op.equals("doUpdate")) {
			this.doUpdate(request, response);
		}else if(op=="delete"||op.equals("delete")) {
			this.doDelete(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * 显示部门信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("cruentPage");
		int page = 1;
		int size = 4;
		if (str != null) {
			page = Integer.parseInt(str);
		}
		SplitDao<Department> department = new DepartmentSplitImpl();
		int allPageNumber = department.AllPageNumber(size);
		int beginPage = department.BeginPage(size, page);
		List<Department> departmentList = department.ShowList(size, beginPage);
		request.setAttribute("allPageNumber", allPageNumber);
		request.setAttribute("page", page);

		request.setAttribute("departmentList", departmentList);
		path = "PartMan.jsp";

	}

	/**
	 * 添加部门
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departmentName = request.getParameter("departmentName");
		String departmentDesc = request.getParameter("departmentDesc");
		Department department = new Department(departmentName, departmentDesc);
		Factory factory = Factory.getFactory();
		DepartmentDao departmentDao = factory.getDepartmentDao();
		boolean b = departmentDao.addDepartment(department);
		if (b) {
			path = "deparementServer?op=show";
		} else {
			path = "login.jsp";
		}
	}

	/**
	 * 部门查询
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String str = request.getParameter("departmentId");
		int departmentId = Integer.parseInt(str);
		
		Factory factory = Factory.getFactory();
		DepartmentDao departmentDao = factory.getDepartmentDao();
		Department department = departmentDao.searchById(departmentId);
		request.setAttribute("department",department );
		path="PartUpda.jsp";
	}
	/**
	 * 修改部门信息
	 */
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("departmentId");
		int departmentId = Integer.parseInt(str);
		String departmentName = request.getParameter("departmentName");
		String departmentDesc = request.getParameter("departmentDesc");
		Department department = new Department(departmentId,departmentName, departmentDesc);
		Factory factory = Factory.getFactory();
		DepartmentDao departmentDao = factory.getDepartmentDao();
		boolean b = departmentDao.updateDepartment(department);
		if(b) {
			path = "deparementServer?op=show";
		}else {
			path = "login.jsp";
		}
	}
	/**
	 * 删除部门
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("departmentId");
		int departmentId = Integer.parseInt(str);
		System.out.println(departmentId);
		Factory factory=Factory.getFactory();
		DepartmentDao departmentDao = factory.getDepartmentDao();
		boolean b = departmentDao.deleteDepartment(departmentId);
		if(b) {
			path="deparementServer?op=show";
		}else {
			path="login.jsp";
		}
	}
}
