package cn.itcast.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.OrderDao;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.Order;
import cn.itcast.shop.vo.OrderItem;
import cn.itcast.shop.vo.User;
@Transactional
public class OrderService {
   private OrderDao orderDao;

public void setOrderDao(OrderDao orderDao) {
	this.orderDao = orderDao;
}

public void save(Order order) {
	
	orderDao.add(order);
}

public PageBean<Order> findAllByuid(Integer uid, Integer page) {
	PageBean<Order> pageBean = new PageBean<Order>();
	//得到当前页
	pageBean.setPage(page);
	//得到每页记录数
	Integer limit = 6;
	pageBean.setLimit(limit);
	//得到总记录数
	int totalCount = orderDao.findCountByuid(uid);
	pageBean.setTotalCount(totalCount);
	//得到总页数
	int totalPage = 0;
    if(totalCount % limit==0){
    	totalPage = totalCount/limit;
    }
    else{
    	totalPage = totalCount/limit + 1;
    }
    pageBean.setTotalPage(totalPage);
    //设置开始位置
    int begin = (page-1)*limit;
    //得到order的list集合
    List<Order> list = orderDao.findAllByuid(uid,begin,limit);
    pageBean.setList(list);
	return pageBean;
}

public Order findByid(Integer oid) {
	
	return orderDao.findOne(oid);
}

public PageBean<Order> findAllByPage(Integer page) {
	PageBean<Order> pageBean = new PageBean<Order>();
	//设置当前页
	pageBean.setPage(page);
	//设置每页显示数
	int limit = 5;
	pageBean.setLimit(limit);
	//设置总记录数
	int totalCount = 0;
	totalCount = orderDao.findCount();
	pageBean.setTotalCount(totalCount);
	//设置总页数
	int totalPage = 0;
	if(totalCount%limit == 0) {
		totalPage = totalCount / limit;		
	}else{
		totalPage = totalCount / limit + 1;		
	}
	pageBean.setTotalPage(totalPage);
	//设置开始位置
	int begin = (page-1)*limit;
	//设置返回集合
	List<Order> list = orderDao.findAllByPage(begin,limit);
	pageBean.setList(list);
	return pageBean;
}

public List<OrderItem> findOrderItem(Integer oid) {
	
	return orderDao.findOrderItem(oid);
}

public void update(Order order) {
	
	orderDao.update(order);
}
   
}
