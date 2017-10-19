package cn.itcast.shop.action;

import java.io.IOException;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.shop.service.UserService;
import cn.itcast.shop.vo.User;

/**
 * 用户模块action
 * @author OMG丶爱月
 *
 */
public class UserAction extends SuperAction implements ModelDriven<User>{
     
   /**
    * 模型驱动封装user
    */
	private User user = new User();
	public User getModel() {
		
		return user;
	}
	/**
	 * 注入userService
	 */
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * 跳转到注册页面
	 * @return
	 */
	public String registerPage() {
		return "registerPage";
	}
    /**
     * 校验用户名是否存在
     * @throws IOException 
     */
	public String findByUserName() throws IOException {		
		String username = user.getUsername();
		System.out.println(username);
		//调用service进行查询
		User existUser = userService.findByUserName(username);
		System.out.println(existUser);
		response.setContentType("text/html;charset=UTF-8");
		if(existUser!=null){
			//查到该用户:用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else{
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		 return NONE;
	}
	/**
	 * 提交注册
	 */
	  private String checkcode;
	  public void setCheckcode(String checkcode) {
			this.checkcode = checkcode;
		}
	  
	   public String register() {
		  //验证码检验
		   String checkcode1 = (String) session.getAttribute("checkcode");
		   if(!checkcode.equalsIgnoreCase(checkcode1)){
			   this.addActionError("验证码输入错误");
			   return "registerPage";
		   }
		   String username = user.getUsername();
		  System.out.println(username);
			//调用service进行查询
			User existUser = userService.findByUserName(username); 
			if(existUser!=null){
				//查到该用户:用户名已经存在
             return "registerPage";
			}
			user.setState(0);
		   userService.add(user);
		   this.addActionMessage("注册成功，请去邮箱激活");
		   return "msg";
	   }
	   /**
	    * 用户激活
	    */
	public String active() {		
		//根据code查询用户
	   User existUser = userService.findByUserCode(user.getCode());
	   if(existUser==null){
		   //激活码错误的
		   this.addActionMessage("激活失败，激活码错误");
	   }else{
		   //设置激活状态
		   existUser.setState(1);
		   existUser.setCode(null);//只能一次激活
		   userService.update(existUser);
		   this.addActionMessage("激活成功，请去登录");
	   }
		return "msg";
	}
	/**
	 * 跳转到登录页面
	 */
	public String loginPage() {
		return "loginPage";
	}
	/**
	 * 登入用户
	 */
	public String login() {
		User existUser = userService.login(user);
		if(existUser==null){
			//登录失败
		this.addActionError("登录失败，用户名或密码错误或用户未激活");
		return "loginPage";
		}else{
			session.setAttribute("existUser", existUser);
		}
		return "loginSuccess";
	}
	/**
	 * 销毁用户
	 * @return
	 */
	public String quit() {
		session.invalidate();
		return "quit";
	}
	
	
}
