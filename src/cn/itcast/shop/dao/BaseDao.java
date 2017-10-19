package cn.itcast.shop.dao;

import java.util.List;

/**
 *建立公共接口
 *完成crud 
 * @author OMG丶爱月
 *
 * @param <T>
 */

public interface BaseDao<T> {

	// 增加数据
	void add(T t);

	// 修改数据
	void update(T t);

	// 删除数据
	void delete(T t);

	// 查询所有数据
	List<T> findAll();

	// 根据id查询数据
	T findOne(int id);
}
