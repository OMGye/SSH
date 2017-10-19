package cn.itcast.shop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.vo.Category;

/**
 * 后台一级分类action，共用前台的service和dao
 * @author OMG丶爱月
 *
 */
public class AdminCategoryAction extends SuperAction implements ModelDriven<Category>{
    //模型驱动使用的类
	Category category = new Category();
	public Category getModel() {		
		return category;
	}
	//注入service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//查询所有一级分类
	public String findAll() {
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	//到添加一级分类的页面
	public String toaddPage() {
		return "toaddPage";
	}
	//添加一级分类
    public String save(){
    	categoryService.save(category);
    	 return "save";
    }
    //删除一级分类
    public String delete() {
    	category = categoryService.findOne(category.getCid());
    	categoryService.delete(category);
    	return "delete";
    }
    //到一级分类的修改页面
    public String toeditPage() {
    	return "toeditPage";
    }
    //更新一级分类
    public String update() {
      categoryService.update(category);
    	return "update";
    }
}
