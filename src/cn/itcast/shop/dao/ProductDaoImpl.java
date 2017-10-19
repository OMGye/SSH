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
 * ��Ʒ�־ò�ʵ�������
 * @author OMGؼ����
 *
 */
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate = hibernateTemplate;
	}

	//��ҳ������Ʒ��ѯ
	@SuppressWarnings("all")
	public List<Product> findHotProduct() {
		// ʹ������������ѯ.
	   DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
	   // ��ѯ���ŵ���Ʒ,��������is_host = 1
	  criteria.add(Restrictions.eq("is_hot", 1));
	   // �����������:
	   criteria.addOrder(Order.desc("pdate"));
		// ִ�в�ѯ:
	   List<Product> list = hibernateTemplate.findByCriteria(
					criteria, 0, 10);
			return list;
		
	}

	//��ҳ������Ʒ��ʾ
	public List<Product> findNewProduct() {
		
		// ʹ������������ѯ.
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// ���ڵ����������:
		criteria.addOrder(Order.desc("pdate"));
		// ִ�в�ѯ:
		List<Product> list = hibernateTemplate.findByCriteria(criteria, 0, 10);
		return list;
		
	}

	//����һ��Ŀ¼��ѯ��Ʒ����
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = hibernateTemplate.find(hql,cid);
		if(list!=null&&list.size()>0){
		return list.get(0).intValue();
		}
		return 0;
	}

	//���ݷ���cid��ѯ��Ʒ����
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

	//���ݶ���Ŀ¼csid��ѯ��Ʒ����
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = hibernateTemplate.find(hql,csid);
		if(list!=null&&list.size()>0){
		return list.get(0).intValue();
		}
		return 0;
		
	}

	//���ݶ���ľĿ¼csid��ѯ��Ʒ����
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
