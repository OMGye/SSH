package cn.itcast.shop.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * һ��Ŀ¼ʵ�������
 * 
 * @author OMGؼ����
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

	// ����Ӧ�Ķ���Ŀ¼����
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
