package cn.itcast.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.vo.User;
/**
 * 用户持久成
 * @author OMG丶爱月
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public User findByUserName(String username) {
		String hql = "from User where username =?";
		List<User> list = hibernateTemplate.find(hql,username);
		if(list!=null&list.size()>0){
			User user = list.get(0);
			return user;
		}
		return null;
	}

	@Override
	public User findByUserCode(String code) {
		String hql = "from User where code =?";
		List<User> list = hibernateTemplate.find(hql,code);
		if(list!=null&list.size()>0){
			User user = list.get(0);
			return user;
		}
		return null;
}

	@Override
	public User login(User user) {
	    String hql = "from User where username = ? and password = ? and state =1";
		List<User> list = hibernateTemplate.find(hql,user.getUsername(),user.getPassword());
		if(list!=null&list.size()>0){
			User userEisxt = list.get(0);
			return userEisxt;
		}
		return null;
	}
	}
