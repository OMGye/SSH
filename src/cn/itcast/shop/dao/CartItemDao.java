package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.CartItem;

public interface CartItemDao extends BaseDao<CartItem>{

	CartItem findBypidAnduid(Integer pid, Integer uid);

	void deleteByuid(Integer uid);

	int findCountByuid(Integer uid);

	List<CartItem> findByPageuid(Integer uid, Integer page, int limit);

}
