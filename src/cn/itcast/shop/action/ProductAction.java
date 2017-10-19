package cn.itcast.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.ProductService;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.Product;
public class ProductAction extends SuperAction implements ModelDriven<Product>{
  private ProductService productService;
  private CategoryService categoryService;
  
public void setCategoryService(CategoryService categoryService) {
	this.categoryService = categoryService;
}
public void setProductService(ProductService productService) {
	this.productService = productService;
}
    private Product product = new Product();

	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	public String findOne() {
		product = productService.findOne(product.getPid());
		return "findOne";
	}
	//����һ��Ŀ¼id
	private Integer cid;
	
    public void setCid(Integer cid) {
		this.cid = cid;
	}
    
   public Integer getCid() {
		return cid;
	}
	// ���յ�ǰҳ��:
 	private int page;

 	public void setPage(int page) {
 			this.page = page;
 		}
 	//����һ��Ŀ¼id��ѯproduct
	public String findByPagecid() {
    	PageBean<Product> pageBean = productService.findByPageCid(cid,page);
    	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
    	return "findByPagecid";
    }
	private Integer csid;
	//����ͨ��get����csid��ֵzai��
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	//���ݶ���Ŀ¼id��ѯproduct
	public String findByPagecsid() {
		PageBean<Product> pageBean = productService.findByPageCsid(csid,page);
    	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByPagecsid";
	}
}
