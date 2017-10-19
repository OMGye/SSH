package cn.itcast.shop.action;

import cn.itcast.shop.service.CategoryService;
 /**
  * 一级目录的action
  * @author OMG丶爱月
  *
  */
public class CategoryAction {
	/**
	 * 注入categoryService对象
	 */
     private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
     
}
