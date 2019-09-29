package org.oa.controler.iDao.inter;


import org.oa.controler.model.Position;

public interface PostionCallDao {

	 public boolean updatePostion(Position position);
	 public Position searchByEmployeeId(int postionId);
}
