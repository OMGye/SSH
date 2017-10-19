package cn.itcast.shop.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * 一级目录实体类对象
 * 
 * @author OMG丶爱月
 *
 */
public class Category {
	private Integer cid;
	private String cname;

	public Set<CategorySecond> getCategorySecond() {
		return CategorySecond;
	}

	public void setCategorySecond(Set<CategorySecond> categorySecond) {
		CategorySecond = categorySecond;
	}

	// 所对应的二级目录集合
	private Set<CategorySecond> CategorySecond = new HashSet<CategorySecond>();

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
