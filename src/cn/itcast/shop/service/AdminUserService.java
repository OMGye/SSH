package cn.itcast.shop.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.AdminUserDao;
import cn.itcast.shop.vo.AdminUser;
@Transactional
public class AdminUserService {
   private AdminUserDao adminUserDao;

public void setAdminUserDao(AdminUserDao adminUserDao) {
	this.adminUserDao = adminUserDao;
}

public AdminUser login(AdminUser adminUser) {
	
	return adminUserDao.login(adminUser);
}
   
}
