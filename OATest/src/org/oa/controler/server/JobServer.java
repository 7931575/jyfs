package org.oa.controler.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oa.controler.Factory.Factory;
import org.oa.controler.iDao.Impl.JobSplitImpl;
import org.oa.controler.iDao.Impl.SearchJobNameSplit;
import org.oa.controler.iDao.inter.DepartmentDao;
import org.oa.controler.iDao.inter.GradeDao;
import org.oa.controler.iDao.inter.JobDao;
import org.oa.controler.model.Job;

@WebServlet("/jobServer")
public class JobServer extends HttpServlet {
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
		} else if (op == "searchName" || op.equals("searchName")) {
			this.searchName(request, response);
		}else if(op=="addPart"||op.equals("addPart")) {
			this.addPart(request, response);
		}else if(op=="delete"||op.equals("delete")) {
			this.jobDelete(request, response);
		}else if(op=="update"||op.equals("update")) {
			this.jobUpdate(request, response);
		}else if(op=="doUpdate"||op.equals("doUpdate")) {
			this.update(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);

	}

	/**
	 * 通过分页的形式显示职务
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("cruentPage");
		int cruentPage = 1;
		int size = 5;
		if (str != null) {
			cruentPage = Integer.parseInt(str);
		}
		JobSplitImpl impl = new JobSplitImpl();
		int allPageNumber = impl.AllPageNumber(size);
		int beginPage = impl.BeginPage(size, cruentPage);
		List<Job> showList = impl.ShowList(size, beginPage);
		request.setAttribute("allPageNumber", allPageNumber);
		request.setAttribute("cruentPage", cruentPage);
		request.setAttribute("showList", showList);
		path = "ShowPostion.jsp";

	}

	/**
	 * 通过部门名字查询职务
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void searchName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jobName = request.getParameter("jobName");
		String cruentPageStr = request.getParameter("cruentPage");
		int cruentPage=1;
		if(cruentPageStr!=null) {
			cruentPage=Integer.parseInt(cruentPageStr);
		}
	
		int size=5;
		SearchJobNameSplit jobNameSplit=new SearchJobNameSplit();
		int allPageNumber = jobNameSplit.AllPageNumber(size, jobName);
		int beginPage = jobNameSplit.BeginPage(size, cruentPage);
		List<Job> job = jobNameSplit.ShowList(size, beginPage, jobName);
		request.setAttribute("allPageNumber", allPageNumber);
		request.setAttribute("job", job);
		request.setAttribute("jobName", jobName);
		request.setAttribute("cruentPage", cruentPage);
		path = "showPostionOne.jsp";

	}
	/**
	 * 添加新的职务
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addPart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jobName = request.getParameter("jobName");
		String departmentName = request.getParameter("departmentName");
		String jobDesc=request.getParameter("jobDesc");
		String grade = request.getParameter("grade");	
		Factory factory=Factory.getFactory();
		DepartmentDao departmentDao = factory.getDepartmentDao();
		int departmentId = departmentDao.searchByName(departmentName);
		GradeDao gradeDao = factory.getGradeDao();
		int gradeId = gradeDao.getGrade(Integer.parseInt(grade));
		Job job=new Job(departmentId,gradeId, jobName, jobDesc, departmentName);
		JobDao jobDao = factory.getJobDao();
		boolean b = jobDao.addJob(job);
		if(b) {
			path="jobServer?op=show";
		}else {
		path="login.jsp";
		}
		
	}
	/**
	 * 删除相应的职务
	 */
	protected void jobDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jobName = request.getParameter("jobName");
		String str = request.getParameter("jobId");
		int jobId = Integer.parseInt(str);
		Factory factory=Factory.getFactory();
		JobDao jobDao = factory.getJobDao();
		boolean b = jobDao.deleteById(jobId);
		if(b) {
			if(jobName!=null) {
				request.setAttribute("jobName", jobName);
				path="jobServer?op=searchName";
			}else {
				path="jobServer?op=show";
			}
			
		}else {
			path="login.jsp";
		}
	}
	/**
	 * 更新职务之前的回显
	 */
	protected void jobUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("jobId");
		int jobId = Integer.parseInt(str);
		Factory factory=Factory.getFactory();
		JobDao jobDao = factory.getJobDao();
		Job job = jobDao.searchById(jobId);
		request.setAttribute("job", job);
		path="PostionUpd.jsp";
		
	}
	/**
	 * 修改职务
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str=request.getParameter("jobId");
		int jobId=Integer.parseInt(str);
		System.out.println(jobId);
		String jobName = request.getParameter("jobName");
		String departmentName = request.getParameter("departmentName");
		String jobDesc=request.getParameter("jobDesc");
		String grade = request.getParameter("grade");
		Factory factory=Factory.getFactory();
		DepartmentDao departmentDao = factory.getDepartmentDao();
		int departmentId = departmentDao.searchByName(departmentName);
		GradeDao gradeDao = factory.getGradeDao();
		int gradeId = gradeDao.getGrade(Integer.parseInt(grade));
		Job job=new Job(jobId, departmentId, gradeId, jobName, jobDesc, departmentName);
	     JobDao jobDao = factory.getJobDao();
	     boolean b = jobDao.updateJob(job);
	     if(b) {
	    	 path="jobServer?op=show";
	     }else {
	    	 path="login.jsp";
	     }
		
		
		
	}


}
