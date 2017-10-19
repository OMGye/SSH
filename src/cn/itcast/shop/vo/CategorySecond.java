package cn.itcast.shop.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * 二级目录实体类对象
 * 
 * @author OMG丶爱月
 *
 */
public class CategorySecond {
	private Integer csid;
	private String csname;
	// 所对应的一级目录对象
	private Category category;
    private Set<Product> products = new HashSet<Product>();
    
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
