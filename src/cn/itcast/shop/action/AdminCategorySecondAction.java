package cn.itcast.shop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.CategorySecondService;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.Category;
import cn.itcast.shop.vo.CategorySecond;

/**
 * 后台二级分类，共用service和dao
 * @author OMG丶爱月
 *
 */
public class AdminCategorySecondAction extends SuperAction implements ModelDriven<CategorySecond>{

	private CategorySecond categorySecond = new CategorySecond();
	public CategorySecond getModel() {		
		return categorySecond;
	}
    private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	private Integer page;
	
    public void setPage(Integer page) {
		this.page = page;
	}
    private Integer cid;
    
    public void setCid(Integer cid) {
		this.cid = cid;
	}
	//分页查询所有二级分类
	public String findAllByPage() {
		PageBean<CategorySecond> pageBean = categorySecondService.findAllByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAllByPage";
    }

	//到添加页面
	public String toaddPage() {
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "toaddPage";
	}
	//添加二级分类
	public String save() {
		Category category = new Category();
		category.setCid(cid);
		categorySecond.setCategory(category);
		categorySecondService.save(categorySecond);
		return "save";
	}
	//到修改页面
	public String toeditPage() {
		categorySecond = categorySecondService.findOne(categorySecond.getCsid());
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);		
		return "toeditPage";
	}
	//修改二级分类
	public String update() {
		Category category = new Category();
		category.setCid(cid);
		categorySecond.setCategory(category);
		categorySecondService.update(categorySecond);
		return "update";
	}
	//删除二级分类
	public String delete() {
		categorySecond = categorySecondService.findOne(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "delete";
	}
	
}
