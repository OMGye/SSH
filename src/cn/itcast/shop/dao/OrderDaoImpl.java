package cn.itcast.shop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.vo.Order;
import cn.itcast.shop.vo.OrderItem;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int findCountByuid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = hibernateTemplate.find(hql,uid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Order> findAllByuid(Integer uid, int begin, Integer limit) {
		String hql = "from Order o where o.user.uid = ? order by date desc";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, uid);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		List<Order> list = query.list();
		session.close();
		return list;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = hibernateTemplate.find(hql);
		if(list!=null&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Order> findAllByPage(int begin, int limit) {
		String hql = "from Order order by date desc";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		List<Order> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem o where o.order.oid = ?";
		List<OrderItem> list = hibernateTemplate.find(hql,oid);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
}
