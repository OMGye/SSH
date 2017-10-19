package cn.itcast.shop.dao;

import cn.itcast.shop.vo.User;
 /**
  * 用户持久层接口
  * @author OMG丶爱月
  *
  */
public interface UserDao extends BaseDao<User>{
   //根据用户查询user
	User findByUserName(String username);

	User findByUserCode(String code);

	User login(User user);
  
	
}
