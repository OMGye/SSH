package cn.itcast.shop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.vo.Category;

/**
 * ��̨һ������action������ǰ̨��service��dao
 * @author OMGؼ����
 *
 */
public class AdminCategoryAction extends SuperAction implements ModelDriven<Category>{
    //ģ������ʹ�õ���
	Category category = new Category();
	public Category getModel() {		
		return category;
	}
	//ע��service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//��ѯ����һ������
	public String findAll() {
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	//�����һ�������ҳ��
	public String toaddPage() {
		return "toaddPage";
	}
	//���һ������
    public String save(){
    	categoryService.save(category);
    	 return "save";
    }
    //ɾ��һ������
    public String delete() {
    	category = categoryService.findOne(category.getCid());
    	categoryService.delete(category);
    	return "delete";
    }
    //��һ��������޸�ҳ��
    public String toeditPage() {
    	return "toeditPage";
    }
    //����һ������
    public String update() {
      categoryService.update(category);
    	return "update";
    }
}
