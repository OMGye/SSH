package cn.itcast.shop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.ProductService;
import cn.itcast.shop.vo.Category;
import cn.itcast.shop.vo.Product;
/**
 * ��ҳ����action����
 * @author OMGؼ����
 *
 */
public class IndexAction extends SuperAction{
     /**
      * ������ҳ�ķ���
      */
    private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public String execute() throws Exception {
		List<Category> clist = categoryService.findAll();
	   ActionContext.getContext().getSession().put("clist",clist);
	    List<Product> plist = productService.findHotProduct();
	    ActionContext.getContext().getValueStack().set("plist", plist);
	    List<Product> nlist = productService.findNewProduct();
	    ActionContext.getContext().getValueStack().set("nlist", nlist);
		return "index";
	}
	
	
}
