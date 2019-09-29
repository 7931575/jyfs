package org.oa.controler.iDao.inter;

import org.oa.controler.model.Archives;

public interface ArchivesDao {

	public boolean addArchives(Archives archives);
	public boolean deleteArchives(int archivesId);
	public boolean updateArchives(Archives archives);
	public Archives searchById(int archivesId);
}
