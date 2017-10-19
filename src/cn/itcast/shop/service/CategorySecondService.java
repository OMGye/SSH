package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.dao.CategorySecondDao;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.CategorySecond;

public class CategorySecondService {
  private CategorySecondDao categorySecondDao;

public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
	this.categorySecondDao = categorySecondDao;
}

public PageBean<CategorySecond> findAllByPage(Integer page) {
	PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
	//设置当前页数
	pageBean.setPage(page);
	//设置每页最多显示条数
	int limit = 10;
	pageBean.setLimit(limit);
	//设置总纪录数
	int totalCount = categorySecondDao.findCount();
	pageBean.setTotalCount(totalCount);
	//设置总页数
	int totalPage = 0;
	if(totalCount % limit == 0){
		totalPage = totalCount/limit;
	}else{
		totalPage = totalCount/limit + 1;
	}
	pageBean.setTotalPage(totalPage);
	//设置每页显示的集合
	int begin = (page-1)*limit;
	List<CategorySecond> list = categorySecondDao.findAllByPage(begin,limit);
	pageBean.setList(list);
	return pageBean;
}

public CategorySecond findOne(Integer csid) {

	return categorySecondDao.findOne(csid);
}

public void save(CategorySecond categorySecond) {
	
	categorySecondDao.add(categorySecond);
}

public void update(CategorySecond categorySecond) {
   
	categorySecondDao.update(categorySecond);
}

public void delete(CategorySecond categorySecond) {
	categorySecondDao.delete(categorySecond);
	
}

public List<CategorySecond> findAll() {
	
	return categorySecondDao.findAll();
}
  
}
