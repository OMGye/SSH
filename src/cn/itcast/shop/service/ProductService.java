package cn.itcast.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.ProductDao;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.Product;
/**
 * 商品业务层
 * @author OMG丶爱月
 *
 */
@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
    //热门商品查询
	public List<Product> findHotProduct() {
		
		return productDao.findHotProduct();
	}
   //首页最新商品查询
	public List<Product> findNewProduct() {
		 
		return productDao.findNewProduct();
	}
  //根据商品id查询商品
	public Product findOne(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findOne(pid);
	}
   //根据一级分类的cid查询带有分页商品
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页
		pageBean.setPage(page);
		//设置每页记录数
		int limit = 12;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit ==0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 从哪开始:
	    int begin = (page - 1) * limit;
		//每页显示数据集合
		List<Product> list = productDao.findByPageCid(cid,begin,limit);
		//添加到pageBean里面
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页
		pageBean.setPage(page);
		//设置每页记录数
		int limit = 8;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit ==0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 从哪开始:
	    int begin = (page - 1) * limit;
		//每页显示数据集合
		List<Product> list = productDao.findByPageCsid(csid,begin,limit);
		//添加到pageBean里面
		pageBean.setList(list);
		return pageBean;
		
	}
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页
		pageBean.setPage(page);
		//设置每页显示记录数
		int limit = 10; 
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit ==0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//设置开始位置
		int begin = (page-1)*limit;
		//每页显示数据集合
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
