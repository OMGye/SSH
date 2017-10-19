package cn.itcast.shop.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.CategorySecondService;
import cn.itcast.shop.service.ProductService;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.CategorySecond;
import cn.itcast.shop.vo.Product;
/**
 * 后台商品action和前台商品action共用service和dao
 * @author OMG丶爱月
 *
 */
public class AdminProductAction extends SuperAction implements ModelDriven<Product>{

	private Product product = new Product();
	public Product getModel() {		
		return product;
	}
    //注入productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//注入categorySecondService
	private CategorySecondService categorySecondService;
	
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	//接收page参数
	private Integer page;	
	public void setPage(Integer page) {
		this.page = page;
	}
	//接收csid
	private Integer csid;
	
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	//接受上传文件
	private File upload;
	private String uploadFileName;
	private String uploadContextType;
	
    public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	//返回所有商品
	public String findAllByPage() {
	    //调用service，完成查询操作
		PageBean<Product> pageBean = productService.findByPage(page);
		//将数据传递到页面上
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//页面跳转
		return "findAllByPage";
	}
	//到添加商品页面
	public String toaddPage() {
		//调用二级分类service查询所有二级分类
		List<CategorySecond> csList = categorySecondService.findAll();
		//用值栈进行保存数据
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "toaddPage";
	}
	//保存商品
	public String save() throws IOException {	
		CategorySecond categorySecond = new CategorySecond();
		categorySecond.setCsid(csid);
		product.setCategorySecond(categorySecond);
		if(upload!=null){
			//获取文件上传磁盘绝对路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			//创建一个文件
			File diskFile = new File(realPath+"//"+uploadFileName);
			//文件上传
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		productService.save(product);
		return "save";
	}
	public String toeditPage() {
		product = productService.findOne(product.getPid());
		//调用二级分类service查询所有二级分类
		List<CategorySecond> csList = categorySecondService.findAll();
		//用值栈进行保存数据
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "toeditPage";
	}
	public String update() throws IOException {
		CategorySecond categorySecond = new CategorySecond();
		categorySecond.setCsid(csid);
		product.setCategorySecond(categorySecond);
		if(upload!=null){
			//获取文件上传磁盘绝对路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			//创建一个文件
			File diskFile = new File(realPath+"//"+uploadFileName);
			//文件上传
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		productService.update(product);
		return "update";
	}
	public String delete() {
		product = productService.findOne(product.getPid());
		productService.delete(product);
		return "delete";
	}
}
