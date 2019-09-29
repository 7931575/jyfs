package org.oa.controler.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oa.controler.Factory.Factory;
import org.oa.controler.iDao.Impl.AllLimitsSplits;
import org.oa.controler.iDao.inter.LimitDao;
import org.oa.controler.model.Limit;

@WebServlet("/limitServer")
public class LimitServer extends HttpServlet {
	String op = "";
	String path = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		op = request.getParameter("op");
		if (op == "add" || op.equals("add")) {
			this.addLimits(request, response);
		} else if (op == "showAllLimits" || op.equals("showAllLimits")) {
			this.showAllLimits(request, response);
		} else if (op == "limitDelete" || op.equals("limitDelete")) {
			this.deleteLimits(request, response);
		} else if (op == "beforeUpda" || op.equals("beforeUpda")) {
			this.boforeUpdateShow(request, response);
		} else if (op == "update" || op.equals("update")) {
			this.doUpdate(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * 权限更新
	 */
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String limitName = request.getParameter("limitName");
		String limitDesc = request.getParameter("limitDesc");
		String str = request.getParameter("limitId");
		int limitId = Integer.parseInt(str);
		Factory factory = Factory.getFactory();
		LimitDao limitDao = factory.getLimitDao();
		Limit limit = new Limit(limitId, limitName, limitDesc);
		boolean b = limitDao.updateLimit(limit);
		if (b) {
			path = "limitServer?op=showAllLimits";
		} else {
			path = "login.jsp";
		}
	}

	/**
	 * 删除前的回显
	 */
	protected void boforeUpdateShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("limitId");
		int limitId = Integer.parseInt(str);
		Factory factory = Factory.getFactory();
		LimitDao limitDao = factory.getLimitDao();
		Limit list = limitDao.searchById(limitId);
		request.setAttribute("list", list);
	
		path = "updateLimit.jsp";
		
	}

	/**
	 * 删除权限
	 */
	protected void deleteLimits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str = request.getParameter("limitId");
		int limitId = Integer.parseInt(str);
		Factory factory = Factory.getFactory();
		LimitDao limitDao = factory.getLimitDao();
		boolean b = limitDao.deleteLimit(limitId);
		if (b) {
			path = "limitServer?op=showAllLimits";
		} else {
			path = "logon.jsp";
		}
	}

	/**
	 * 添加新的权限
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addLimits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String limitName = request.getParameter("limitName");
		String limitDesc = request.getParameter("limitDesc");
		Factory factory = Factory.getFactory();
		LimitDao limitDao = factory.getLimitDao();
		Limit limit = new Limit(limitName, limitDesc);
		boolean b = limitDao.addLimit(limit);
		if (b) {
			path = "limitServer?op=showAllLimits";
		} else {
			path = "login.jsp";
		}

	}

	/**
	 * 显示所有的权限列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showAllLimits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("cruentPage");
		int size = 8;
		int cruentPage = 1;
		if (str != null) {
			cruentPage = Integer.parseInt(str);
		}
		AllLimitsSplits allLimitsSplits = new AllLimitsSplits();
		int allPageNumber = allLimitsSplits.AllPageNumber(size);
		int beginPage = allLimitsSplits.BeginPage(size, cruentPage);
		List<Limit> showList = allLimitsSplits.ShowList(size, beginPage);
		request.setAttribute("showList", showList);
		request.setAttribute("allPageNumber", allPageNumber);
		request.setAttribute("cruentPage", cruentPage);
		
		path = "showAllLimit.jsp";
	}

}
