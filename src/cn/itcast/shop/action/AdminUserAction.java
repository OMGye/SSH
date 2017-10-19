package cn.itcast.shop.action;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.AdminUserService;
import cn.itcast.shop.vo.AdminUser;

public class AdminUserAction extends SuperAction implements ModelDriven<AdminUser> {
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}
    //后台登录方法
	public String login() {
	    //调用service完成登录	
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser ==null){
			this.addActionError("您的用户名或者密码错误");
			return "loginFail";
		}else{
			session.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
				
	}
}
