package cn.itcast.shop.dao;

import cn.itcast.shop.vo.AdminUser;

public interface AdminUserDao extends BaseDao<AdminUser>{

	AdminUser login(AdminUser adminUser);

}
