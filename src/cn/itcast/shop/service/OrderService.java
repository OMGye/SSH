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
	//�õ���ǰҳ
	pageBean.setPage(page);
	//�õ�ÿҳ��¼��
	Integer limit = 6;
	pageBean.setLimit(limit);
	//�õ��ܼ�¼��
	int totalCount = orderDao.findCountByuid(uid);
	pageBean.setTotalCount(totalCount);
	//�õ���ҳ��
	int totalPage = 0;
    if(totalCount % limit==0){
    	totalPage = totalCount/limit;
    }
    else{
    	totalPage = totalCount/limit + 1;
    }
    pageBean.setTotalPage(totalPage);
    //���ÿ�ʼλ��
    int begin = (page-1)*limit;
    //�õ�order��list����
    List<Order> list = orderDao.findAllByuid(uid,begin,limit);
    pageBean.setList(list);
	return pageBean;
}

public Order findByid(Integer oid) {
	
	return orderDao.findOne(oid);
}

public PageBean<Order> findAllByPage(Integer page) {
	PageBean<Order> pageBean = new PageBean<Order>();
	//���õ�ǰҳ
	pageBean.setPage(page);
	//����ÿҳ��ʾ��
	int limit = 5;
	pageBean.setLimit(limit);
	//�����ܼ�¼��
	int totalCount = 0;
	totalCount = orderDao.findCount();
	pageBean.setTotalCount(totalCount);
	//������ҳ��
	int totalPage = 0;
	if(totalCount%limit == 0) {
		totalPage = totalCount / limit;		
	}else{
		totalPage = totalCount / limit + 1;		
	}
	pageBean.setTotalPage(totalPage);
	//���ÿ�ʼλ��
	int begin = (page-1)*limit;
	//���÷��ؼ���
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
