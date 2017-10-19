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
    //��̨��¼����
	public String login() {
	    //����service��ɵ�¼	
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser ==null){
			this.addActionError("�����û��������������");
			return "loginFail";
		}else{
			session.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
				
	}
}
