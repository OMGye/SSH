package cn.itcast.shop.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.UserDao;
import cn.itcast.shop.util.MailUtil;
import cn.itcast.shop.util.UUIDUtils;
import cn.itcast.shop.vo.User;
/**
 * 用户业务层
 * @author OMG丶爱月
 *
 */
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 按照用户名调查用户的方法
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}

	public void add(User user) {
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		user.setCode(code);
		userDao.add(user);
		try {
			MailUtil.sendMail(user.getEmail(), user.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public User findByUserCode(String code) {
		// TODO Auto-generated method stub
		return userDao.findByUserCode(code);
	}

	public void update(User existuser) {
		userDao.update(existuser);

	}

	public User login(User user) {
		
		return userDao.login(user);
	}

}
