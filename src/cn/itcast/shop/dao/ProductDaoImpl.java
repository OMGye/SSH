package cn.itcast.shop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.vo.Product;
/**
 * 商品持久层实现类对象
 * @author OMG丶爱月
 *
 */
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate = hibernateTemplate;
	}

	//首页热门商品查询
	@SuppressWarnings("all")
	public List<Product> findHotProduct() {
		// 使用离线条件查询.
	   DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
	   // 查询热门的商品,条件就是is_host = 1
	  criteria.add(Restrictions.eq("is_hot", 1));
	   // 倒序排序输出:
	   criteria.addOrder(Order.desc("pdate"));
		// 执行查询:
	   List<Product> list = hibernateTemplate.findByCriteria(
					criteria, 0, 10);
			return list;
		
	}

	//首页最新商品显示
	public List<Product> findNewProduct() {
		
		// 使用离线条件查询.
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 日期倒序排序输出:
		criteria.addOrder(Order.desc("pdate"));
		// 执行查询:
		List<Product> list = hibernateTemplate.findByCriteria(criteria, 0, 10);
		return list;
		
	}

	//根据一级目录查询商品数量
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = hibernateTemplate.find(hql,cid);
		if(list!=null&&list.size()>0){
		return list.get(0).intValue();
		}
		return 0;
	}

	//根据分类cid查询商品集合
	public List<Product> findByPageCid(Integer cid,int begin,int limit) {
		//select p from product p ,category c,categorysecond cs where c.cid = cs.cid and cs.cid = p.csid and c.cid=1;
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select p from Product p where p.categorySecond.category.cid = ? ");
		query.setParameter(0, cid);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		List<Product> list = query.list();
		return list;
	}

	//根据二级目录csid查询商品数量
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = hibernateTemplate.find(hql,csid);
		if(list!=null&&list.size()>0){
		return list.get(0).intValue();
		}
		return 0;
		
	}

	//根据二级木目录csid查询商品集合
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		// select p from product p ,category c,categorysecond cs where c.cid =
		// cs.cid and cs.cid = p.csid and c.cid=1;
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("select p from Product p where p.categorySecond.csid= ? ");
		query.setParameter(0, csid);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		List<Product> list = query.list();
		return list;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = hibernateTemplate.find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		List<Product> list = query.list();
		return list;
	}
}
