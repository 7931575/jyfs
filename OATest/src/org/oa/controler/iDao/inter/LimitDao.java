package org.oa.controler.iDao.inter;

import org.oa.controler.model.Limit;

public interface LimitDao {

	public boolean updateLimit(Limit limit);
	public Limit searchById(int limitId);
	public boolean deleteLimit(int limitId);
	public boolean addLimit(Limit limit);
}
