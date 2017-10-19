package cn.itcast.shop.action;

import java.io.IOException;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.shop.service.UserService;
import cn.itcast.shop.vo.User;

/**
 * �û�ģ��action
 * @author OMGؼ����
 *
 */
public class UserAction extends SuperAction implements ModelDriven<User>{
     
   /**
    * ģ��������װuser
    */
	private User user = new User();
	public User getModel() {
		
		return user;
	}
	/**
	 * ע��userService
	 */
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * ��ת��ע��ҳ��
	 * @return
	 */
	public String registerPage() {
		return "registerPage";
	}
    /**
     * У���û����Ƿ����
     * @throws IOException 
     */
	public String findByUserName() throws IOException {		
		String username = user.getUsername();
		System.out.println(username);
		//����service���в�ѯ
		User existUser = userService.findByUserName(username);
		System.out.println(existUser);
		response.setContentType("text/html;charset=UTF-8");
		if(existUser!=null){
			//�鵽���û�:�û����Ѿ�����
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		}else{
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		 return NONE;
	}
	/**
	 * �ύע��
	 */
	  private String checkcode;
	  public void setCheckcode(String checkcode) {
			this.checkcode = checkcode;
		}
	  
	   public String register() {
		  //��֤�����
		   String checkcode1 = (String) session.getAttribute("checkcode");
		   if(!checkcode.equalsIgnoreCase(checkcode1)){
			   this.addActionError("��֤���������");
			   return "registerPage";
		   }
		   String username = user.getUsername();
		  System.out.println(username);
			//����service���в�ѯ
			User existUser = userService.findByUserName(username); 
			if(existUser!=null){
				//�鵽���û�:�û����Ѿ�����
             return "registerPage";
			}
			user.setState(0);
		   userService.add(user);
		   this.addActionMessage("ע��ɹ�����ȥ���伤��");
		   return "msg";
	   }
	   /**
	    * �û�����
	    */
	public String active() {		
		//����code��ѯ�û�
	   User existUser = userService.findByUserCode(user.getCode());
	   if(existUser==null){
		   //����������
		   this.addActionMessage("����ʧ�ܣ����������");
	   }else{
		   //���ü���״̬
		   existUser.setState(1);
		   existUser.setCode(null);//ֻ��һ�μ���
		   userService.update(existUser);
		   this.addActionMessage("����ɹ�����ȥ��¼");
	   }
		return "msg";
	}
	/**
	 * ��ת����¼ҳ��
	 */
	public String loginPage() {
		return "loginPage";
	}
	/**
	 * �����û�
	 */
	public String login() {
		User existUser = userService.login(user);
		if(existUser==null){
			//��¼ʧ��
		this.addActionError("��¼ʧ�ܣ��û��������������û�δ����");
		return "loginPage";
		}else{
			session.setAttribute("existUser", existUser);
		}
		return "loginSuccess";
	}
	/**
	 * �����û�
	 * @return
	 */
	public String quit() {
		session.invalidate();
		return "quit";
	}
	
	
}
