package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.vo.Order;
import cn.itcast.shop.vo.OrderItem;

public interface OrderDao extends BaseDao<Order>{

	int findCountByuid(Integer uid);

	List<Order> findAllByuid(Integer uid, int begin, Integer limit);

	int findCount();

	List<Order> findAllByPage(int begin, int limit);

	List<OrderItem> findOrderItem(Integer oid);

}
