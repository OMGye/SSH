package cn.itcast.shop.dao;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.vo.Category;
/**
 * 一级目录持久层
 * @author OMG丶爱月
 *
 */
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate = hibernateTemplate;
	}

}
