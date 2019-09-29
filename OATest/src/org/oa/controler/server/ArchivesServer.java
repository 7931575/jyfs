package org.oa.controler.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oa.controler.Factory.Factory;
import org.oa.controler.iDao.Impl.ArchivesAllSplit;
import org.oa.controler.iDao.Impl.ArchivesByDepartmentSplit;
import org.oa.controler.iDao.Impl.ArchivesListSplit;
import org.oa.controler.iDao.Impl.ArchviesByNameSplit;
import org.oa.controler.iDao.inter.ArchivesDao;
import org.oa.controler.model.Archives;
import org.oa.controler.model.Employee;
@WebServlet("/archivesServer")
public class ArchivesServer extends HttpServlet {
	String path = "";
	String op = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		op = request.getParameter("op");
		if (op == "addArchives" || op.equals("addArchives")) {
			this.addArchives(request, response);
		} else if (op == "showAll" || op.equals("showAll")) {
			this.showAll(request, response);
		} else if (op == "detail" || op.equals("detail")) {
			this.showOneEmployee(request, response);
		} else if (op == "employeeDetai" || op.equals("employeeDetai")) {
			this.oneArchivesDetail(request, response);
		} else if (op == "delete" || op.equals("delete")) {
			this.deleteOne(request, response);
		}else if(op=="update"||op.equals("update")) {
		    this.update(request, response);
		}else if(op=="updateRecode"||op.equals("updateRecode")) {
			this.doUpdate(request, response);
		}else if(op=="searchByName"||op.equals("searchByName")) {
			this.searchByName(request, response);
		}else if(op=="searchByDepartName"||op.equals("searchByDepartName")) {
			this.searchByDemartmentName(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	/**
	 * 通过部门查找
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void searchByDemartmentName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("cruentPage");
		String departmentName = request.getParameter("departmentName");
	
		int size=5;
		int cruentPage=1;
		if(str!=null) {
			cruentPage=Integer.parseInt(str);
		}
		ArchivesByDepartmentSplit archivesByDepartmentSplit=new ArchivesByDepartmentSplit();
		int allPageNumber = archivesByDepartmentSplit.AllPageNumber(size, departmentName);
		int beginPage = archivesByDepartmentSplit.BeginPage(size, cruentPage);
		List<Employee> showList = archivesByDepartmentSplit.ShowList(size, beginPage, departmentName);
		request.setAttribute("allPageNumber",allPageNumber);
		request.setAttribute("cruentPage", cruentPage);
		request.setAttribute("showList", showList);
		path="RecordShow.jsp";
		
	}
	
	/*
	 *按名字查找 
	 */
	
	protected void searchByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("cruentPage");
		int size=5;
		int cruentPage=1;
		if(str!=null) {
			cruentPage=Integer.parseInt(str);
		}
		String employeeName = request.getParameter("employeeName");
		
		ArchviesByNameSplit archviesByNameSplit=new ArchviesByNameSplit();
		int allPageNumber = archviesByNameSplit.AllPageNumber(size, employeeName);
		int beginPage = archviesByNameSplit.BeginPage(size, cruentPage);
		List<Employee> showList = archviesByNameSplit.ShowList(size, beginPage, employeeName);
		
		request.setAttribute("allPageNumber",allPageNumber);
		request.setAttribute("cruentPage", cruentPage);
		request.setAttribute("showList", showList);
		path="RecordShow.jsp";
	}
	/*
	 *修改某条记录 
	 */

	protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = request.getParameter("archivesId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int archivesId = Integer.parseInt(string);
		Archives archives=new Archives(archivesId, 0, title, content, null, null);
		Factory factory=Factory.getFactory();
		ArchivesDao archivesDao = factory.getArchivesDao();
		boolean b = archivesDao.updateArchives(archives);
		if(b) {
			path="archivesServer?op=employeeDetai&archivesId="+archivesId;
		}else {
			path="login.jsp";
		}
	}


	/*
	 * 详细的某条档案记录
	 */
	protected void oneArchivesDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = request.getParameter("archivesId");
		int archivesId = Integer.parseInt(string);
		Factory factory = Factory.getFactory();
		ArchivesDao archivesDao = factory.getArchivesDao();
		Archives archives = archivesDao.searchById(archivesId);

		request.setAttribute("archives", archives);

		path = "ShowDetailRecode.jsp";
	}

	/**
	 * 删除某条记录
	 */
	protected void deleteOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("archivesId");
		String employee = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(employee);
        int archivesId = Integer.parseInt(str);
        Factory factory=Factory.getFactory();
        ArchivesDao archivesDao = factory.getArchivesDao();
        boolean b = archivesDao.deleteArchives(archivesId);
        if(b) {
        	path="archivesServer?op=detail&employeeId="+employeeId;
        }else {
        	path="login.jsp";
        }
	}
/**
 * 修改前的回显
 */
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("archivesId");
		int archivesId = Integer.parseInt(str);
		Factory factory=Factory.getFactory();
		ArchivesDao archivesDao = factory.getArchivesDao();
		Archives archives = archivesDao.searchById(archivesId);		
		request.setAttribute("archives", archives);	
		path="UpdateRecodeOpe.jsp";
	}
	/**
	 * 详细显示某员工的档案
	 */
	protected void showOneEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("cruentPage");
		String employee = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(employee);
		int cruentPage = 1;
		int size = 4;
		if (str != null) {
			cruentPage = Integer.parseInt(str);
		}
		ArchivesListSplit archivesListSplit = new ArchivesListSplit();
		int allPageNumber = archivesListSplit.AllPageNumber(size, employeeId);
		int beginPage = archivesListSplit.BeginPage(size, cruentPage);
		List<Archives> showList = archivesListSplit.ShowList(size, beginPage, employeeId);
		request.setAttribute("showList", showList);
		request.setAttribute("cruentPage", cruentPage);
		request.setAttribute("employeeId", employeeId);
		request.setAttribute("allPageNumber", allPageNumber);
		path = "UpdateRecord.jsp";

	}

	/**
	 * 显示所有员工的档案
	 */
	protected void showAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("cruentPage");

		int cruentPage = 1;
		int size = 5;
		if (str != null) {
			cruentPage = Integer.parseInt(str);
		}
		ArchivesAllSplit allSplit = new ArchivesAllSplit();
		int allPageNumber = allSplit.AllPageNumber(size);
		int beginPage = allSplit.BeginPage(size, cruentPage);
		List<Employee> showList = allSplit.ShowList(size, beginPage);
		request.setAttribute("allPageNumber", allPageNumber);
		request.setAttribute("showList", showList);
		request.setAttribute("cruentPage", cruentPage);
		path = "RecordShow.jsp";
	}

	/**
	 * 添加员工档案
	 */
	protected void addArchives(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(string);
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		Factory factory = Factory.getFactory();
		ArchivesDao archivesDao = factory.getArchivesDao();
		Archives archives = new Archives(employeeId, title, context, null, null);
		boolean b = archivesDao.addArchives(archives);
		if (b) {
			path = "archivesServer?op=detail&employeeId=" + employeeId;
		} else {
			path = "login.jsp";
		}
	}

}
