package cn.itcast.shop.vo;

import java.util.Date;
/**
 * 购物车实体类
 * @author OMG丶爱月
 *
 */
public class CartItem {
  private Integer caid;
  private Integer num;//商品数量
  private String updatedate;//更新时间
  private String uploaddate;//上传时间
  private Product product;//商品
  private User user;//所属用户
public Integer getCaid() {
	return caid;
}
public void setCaid(Integer caid) {
	this.caid = caid;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}

public String getUpdatedate() {
	return updatedate;
}
public void setUpdatedate(String updatedate) {
	this.updatedate = updatedate;
}
public String getUploaddate() {
	return uploaddate;
}
public void setUploaddate(String uploaddate) {
	this.uploaddate = uploaddate;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
   
}
