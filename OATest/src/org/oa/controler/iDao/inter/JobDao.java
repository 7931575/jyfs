package org.oa.controler.iDao.inter;


import org.oa.controler.model.Job;

public interface JobDao {
    
	public Job searchById(int JobId);
	public boolean deleteById(int JobId);
	public boolean addJob(Job job);
	public boolean updateJob(Job job);
}
