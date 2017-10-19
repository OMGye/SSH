package cn.itcast.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.CategoryDao;
import cn.itcast.shop.vo.Category;
/**
 * 一级目录业务层
 * @author OMG丶爱月
 *
 */
@Transactional
public class CategoryService {
   private CategoryDao categoryDao;

public void setCategoryDao(CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
}

public List<Category> findAll() {
	// TODO Auto-generated method stub
	return categoryDao.findAll();
}

public void save(Category category) {
	// TODO Auto-generated method stub
	categoryDao.add(category);
}

public Category findOne(Integer cid) {
	
	return categoryDao.findOne(cid);
}

public void delete(Category category) {
	categoryDao.delete(category);
	
}

public void update(Category category) {
	categoryDao.update(category);
	
}
   
}
