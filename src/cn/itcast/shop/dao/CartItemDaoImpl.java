package cn.itcast.shop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.CartItem;
import cn.itcast.shop.vo.Product;
import cn.itcast.shop.vo.User;
/**
 *  购物项持久成对象
 * @author OMG丶爱月
 *
 */
public class CartItemDaoImpl extends BaseDaoImpl<CartItem> implements CartItemDao{
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate = hibernateTemplate;
	}

	//根据用户和商品查询是否存在该购物项
	public CartItem findBypidAnduid(Integer pid, Integer uid) {
		String hql ="select c from CartItem c where c.product.pid = ? and c.user.uid= ?";
		List<CartItem> list = (List<CartItem>) hibernateTemplate.find(hql,pid,uid);
		if(list!=null&list.size()>0){
			//防止指针异常
			CartItem cartItem = list.get(0);
			return cartItem;
		}
		return null;
	}

	
	

	//通过用户id删除购物项
	public void deleteByuid(Integer uid) {
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		 String hql = "delete CartItem c where c.user.uid = ?";
		 Query query = session.createQuery(hql);
		 query.setParameter(0, uid);
		 query.executeUpdate();
		 session.close();
	}

	//查询该用户的购物项数量
	public int findCountByuid(Integer uid) {
		String hql = "select count(*) from CartItem c where c.user.uid = ?";
		List<Long> list = hibernateTemplate.find(hql,uid);
		if(list!=null&&list.size()>0){
		return list.get(0).intValue();
		}
		return 0;
		
	}

	// 分页查询用户所有购物项
	public List<CartItem> findByPageuid(Integer uid, Integer begin, int limit) {
		// select p from product p ,category c,categorysecond cs where c.cid =
		// cs.cid and cs.cid = p.csid and c.cid=1;
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("select c from CartItem c where c.user.uid = ? ");
		query.setParameter(0, uid);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		List<CartItem> list = query.list();
		session.close();
		return list;
	}

}
