package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.vo.CategorySecond;

public interface CategorySecondDao extends BaseDao<CategorySecond>{

	int findCount();

	List<CategorySecond> findAllByPage(int begin, int limit);

}
