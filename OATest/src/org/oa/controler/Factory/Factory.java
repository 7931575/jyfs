package org.oa.controler.Factory;

import org.oa.controler.iDao.Impl.ArchivesImpl;
import org.oa.controler.iDao.Impl.DepartmentImpl;
import org.oa.controler.iDao.Impl.EmployeeImpl;
import org.oa.controler.iDao.Impl.GradeImpl;
import org.oa.controler.iDao.Impl.InforSelectImpl;
import org.oa.controler.iDao.Impl.JobImpl;
import org.oa.controler.iDao.Impl.LimitImpl;
import org.oa.controler.iDao.Impl.PostionCallImpl;
import org.oa.controler.iDao.inter.ArchivesDao;
import org.oa.controler.iDao.inter.DepartmentDao;
import org.oa.controler.iDao.inter.EmployeeDao;
import org.oa.controler.iDao.inter.GradeDao;
import org.oa.controler.iDao.inter.InforSelectDao;
import org.oa.controler.iDao.inter.JobDao;
import org.oa.controler.iDao.inter.LimitDao;
import org.oa.controler.iDao.inter.PostionCallDao;

public class Factory {

	private static Factory factory;
	private DepartmentDao departmentDao;
	private JobDao jobDao;
	private GradeDao gradeDao;
	private EmployeeDao employeeDao;
	private ArchivesDao archivesDao;
	private PostionCallDao callDao;
	private InforSelectDao inforSelectDao;
    private LimitDao limitDao;
  
	public static Factory getFactory() {
		if (factory == null) {
			factory = new Factory();
		}
		return factory;
	}
	  public LimitDao getLimitDao() {
	    	if(limitDao == null) {
	    		limitDao=new LimitImpl();
	    	}
	    	return limitDao;
	    }
	public InforSelectDao getInforSelectDao() {
		if (inforSelectDao == null) {
			inforSelectDao = new InforSelectImpl();
		}
		return inforSelectDao;
	}

	public DepartmentDao getDepartmentDao() {
		if (departmentDao == null) {
			departmentDao = new DepartmentImpl();
		}
		return departmentDao;
	}

	public JobDao getJobDao() {
		if (jobDao == null) {
			jobDao = new JobImpl();
		}
		return jobDao;
	}

	public GradeDao getGradeDao() {
		if (gradeDao == null) {
			gradeDao = new GradeImpl();
		}
		return gradeDao;
	}

	public EmployeeDao getEmployeeDao() {
		if (employeeDao == null) {
			employeeDao = new EmployeeImpl();
		}
		return employeeDao;
	}

	public ArchivesDao getArchivesDao() {
		if (archivesDao == null) {
			archivesDao = new ArchivesImpl();
		}
		return archivesDao;
	}

	public PostionCallDao getPostion() {
		if (callDao == null) {
			callDao = new PostionCallImpl();
		}
		return callDao;
	}
}
