package cn.itcast.shop.dao;

import cn.itcast.shop.vo.User;
 /**
  * �û��־ò�ӿ�
  * @author OMGؼ����
  *
  */
public interface UserDao extends BaseDao<User>{
   //�����û���ѯuser
	User findByUserName(String username);

	User findByUserCode(String code);

	User login(User user);
  
	
}
