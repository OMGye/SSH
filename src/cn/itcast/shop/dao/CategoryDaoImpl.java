package cn.itcast.shop.dao;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.vo.Category;
/**
 * һ��Ŀ¼�־ò�
 * @author OMGؼ����
 *
 */
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate = hibernateTemplate;
	}

}
