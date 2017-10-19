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
 * ��̨��Ʒaction��ǰ̨��Ʒaction����service��dao
 * @author OMGؼ����
 *
 */
public class AdminProductAction extends SuperAction implements ModelDriven<Product>{

	private Product product = new Product();
	public Product getModel() {		
		return product;
	}
    //ע��productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//ע��categorySecondService
	private CategorySecondService categorySecondService;
	
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	//����page����
	private Integer page;	
	public void setPage(Integer page) {
		this.page = page;
	}
	//����csid
	private Integer csid;
	
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	//�����ϴ��ļ�
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
	//����������Ʒ
	public String findAllByPage() {
	    //����service����ɲ�ѯ����
		PageBean<Product> pageBean = productService.findByPage(page);
		//�����ݴ��ݵ�ҳ����
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//ҳ����ת
		return "findAllByPage";
	}
	//�������Ʒҳ��
	public String toaddPage() {
		//���ö�������service��ѯ���ж�������
		List<CategorySecond> csList = categorySecondService.findAll();
		//��ֵջ���б�������
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "toaddPage";
	}
	//������Ʒ
	public String save() throws IOException {	
		CategorySecond categorySecond = new CategorySecond();
		categorySecond.setCsid(csid);
		product.setCategorySecond(categorySecond);
		if(upload!=null){
			//��ȡ�ļ��ϴ����̾���·��
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			//����һ���ļ�
			File diskFile = new File(realPath+"//"+uploadFileName);
			//�ļ��ϴ�
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		productService.save(product);
		return "save";
	}
	public String toeditPage() {
		product = productService.findOne(product.getPid());
		//���ö�������service��ѯ���ж�������
		List<CategorySecond> csList = categorySecondService.findAll();
		//��ֵջ���б�������
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "toeditPage";
	}
	public String update() throws IOException {
		CategorySecond categorySecond = new CategorySecond();
		categorySecond.setCsid(csid);
		product.setCategorySecond(categorySecond);
		if(upload!=null){
			//��ȡ�ļ��ϴ����̾���·��
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			//����һ���ļ�
			File diskFile = new File(realPath+"//"+uploadFileName);
			//�ļ��ϴ�
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
