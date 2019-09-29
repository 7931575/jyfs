package org.oa.controler.iDao.inter;

import java.util.List;

public interface SplitDao<T> {

	 public int AllPageNumber(int size);
	 public int BeginPage(int size,int cruentPage);
	 public List<T> ShowList(int size,int cruentPage);
}
