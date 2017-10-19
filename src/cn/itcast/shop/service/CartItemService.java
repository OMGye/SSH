package cn.itcast.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.CartItemDao;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.CartItem;
import cn.itcast.shop.vo.Product;
@Transactional
public class CartItemService {
   private CartItemDao cartItemDao;

public void setCartItemDao(CartItemDao cartItemDao) {
	this.cartItemDao = cartItemDao;
}

public CartItem findBypidAnduid(Integer pid, Integer uid) {
	 
	return cartItemDao.findBypidAnduid(pid,uid);
}

public void update(CartItem selectCartItem) {
	cartItemDao.update(selectCartItem);
	
}

public void add(CartItem cartItem) {
	cartItemDao.add(cartItem);
	
}

public PageBean<CartItem> findAllByuid(Integer uid,Integer page) {
	PageBean<CartItem> pageBean = new PageBean<CartItem>();
	//设置当前页
	pageBean.setPage(page);
	//设置每页记录数
	int limit = 5;
	pageBean.setLimit(limit);
	//设置总记录数
	int totalCount = 0;
	totalCount = cartItemDao.findCountByuid(uid);
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
	List<CartItem> list = cartItemDao.findByPageuid(uid,begin,limit);
	//添加到pageBean里面
	pageBean.setList(list);
	return pageBean;
}

public void deleteByid(CartItem cartItem) {
	cartItemDao.delete(cartItem);
	
}

public void deleteByuid(Integer uid) {
	cartItemDao.deleteByuid(uid);
	
}
}
