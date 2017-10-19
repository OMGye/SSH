package cn.itcast.shop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.vo.CategorySecond;
import cn.itcast.shop.vo.Product;

public class CategorySecondDaoImpl extends BaseDaoImpl<CategorySecond> implements CategorySecondDao{
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int findCount() {
	   String hql="select count(*) from CategorySecond";
	   List<Long> list = hibernateTemplate.find(hql);
	   if(list != null & list.size()>0){
		   int count = list.get(0).intValue();
		   return count;
	   }
		return 0;
	}

	
	public List<CategorySecond> findAllByPage(int begin, int limit) {
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from CategorySecond order by csid desc");
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		List<CategorySecond> list = query.list();
		return list;
	}
}
