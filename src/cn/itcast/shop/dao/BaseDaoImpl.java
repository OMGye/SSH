package cn.itcast.shop.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
/**
 * 公共接口实现类
 * @author OMG丶爱月
 *
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	protected HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.itcast.dao.BaseDao#add(java.lang.Object) 写一个构造方法，得到实际类型参数<T>里面的T
	 */
	Class pClass;

	public BaseDaoImpl() {
		// 第一步 得到当前运行类Class
		Class clazz = this.getClass();
		// 第二步 得到运行类父类参数化类型BaseDaoImpl<T>
		Type type = clazz.getGenericSuperclass();
		// 第三步 使用type子接口ParameterizedType
		ParameterizedType ptype = (ParameterizedType) type;
		// 第四步 得到实际类型参数<T>里面的T
		Type[] types = ptype.getActualTypeArguments();
		Class tClass = (Class) types[0];
		pClass = tClass;
	}

	public void add(T t) {
		hibernateTemplate.save(t);

	}

	public void update(T t) {
		hibernateTemplate.update(t);

	}

	public void delete(T t) {
		hibernateTemplate.delete(t);

	}

	@SuppressWarnings("all")
	public List<T> findAll() {
		hibernateTemplate.find("from "+pClass.getSimpleName());
		return (List<T>) hibernateTemplate.find("from "+pClass.getSimpleName());
	}

	@SuppressWarnings("all")
	public T findOne(int id) {
		
		return (T) hibernateTemplate.get(pClass, id);
	}

}
