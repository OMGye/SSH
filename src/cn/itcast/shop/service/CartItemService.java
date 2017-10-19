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
	//���õ�ǰҳ
	pageBean.setPage(page);
	//����ÿҳ��¼��
	int limit = 5;
	pageBean.setLimit(limit);
	//�����ܼ�¼��
	int totalCount = 0;
	totalCount = cartItemDao.findCountByuid(uid);
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
	List<CartItem> list = cartItemDao.findByPageuid(uid,begin,limit);
	//��ӵ�pageBean����
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
