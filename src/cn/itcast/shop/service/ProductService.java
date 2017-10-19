package cn.itcast.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.ProductDao;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.Product;
/**
 * ��Ʒҵ���
 * @author OMGؼ����
 *
 */
@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
    //������Ʒ��ѯ
	public List<Product> findHotProduct() {
		
		return productDao.findHotProduct();
	}
   //��ҳ������Ʒ��ѯ
	public List<Product> findNewProduct() {
		 
		return productDao.findNewProduct();
	}
  //������Ʒid��ѯ��Ʒ
	public Product findOne(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findOne(pid);
	}
   //����һ�������cid��ѯ���з�ҳ��Ʒ
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ
		pageBean.setPage(page);
		//����ÿҳ��¼��
		int limit = 12;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount % limit ==0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ���Ŀ�ʼ:
	    int begin = (page - 1) * limit;
		//ÿҳ��ʾ���ݼ���
		List<Product> list = productDao.findByPageCid(cid,begin,limit);
		//��ӵ�pageBean����
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ
		pageBean.setPage(page);
		//����ÿҳ��¼��
		int limit = 8;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount % limit ==0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ���Ŀ�ʼ:
	    int begin = (page - 1) * limit;
		//ÿҳ��ʾ���ݼ���
		List<Product> list = productDao.findByPageCsid(csid,begin,limit);
		//��ӵ�pageBean����
		pageBean.setList(list);
		return pageBean;
		
	}
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼��
		int limit = 10; 
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount % limit ==0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//���ÿ�ʼλ��
		int begin = (page-1)*limit;
		//ÿҳ��ʾ���ݼ���
		List<Product> list = productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public void save(Product product) {
	
		productDao.add(product);
	}
	public void update(Product product) {
		productDao.update(product);
		
	}
	public void delete(Product product) {
		productDao.delete(product);
		
	}
}
