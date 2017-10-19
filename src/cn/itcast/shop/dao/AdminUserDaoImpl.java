package cn.itcast.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.vo.AdminUser;
import cn.itcast.shop.vo.User;

public class AdminUserDaoImpl extends BaseDaoImpl<AdminUser> implements AdminUserDao{
   private HibernateTemplate hibernateTemplate;

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

@Override
public AdminUser login(AdminUser adminUser) {
	 String hql = "from AdminUser where username = ? and password = ? ";
		List<AdminUser> list = hibernateTemplate.find(hql,adminUser.getUsername(),adminUser.getPassword());
		if(list!=null&list.size()>0){
			AdminUser userEisxt = list.get(0);
			return userEisxt;
		}
		return null;
}
   
}
