package cn.itcast.shop.vo;

import java.util.Date;
/**
 * ���ﳵʵ����
 * @author OMGؼ����
 *
 */
public class CartItem {
  private Integer caid;
  private Integer num;//��Ʒ����
  private String updatedate;//����ʱ��
  private String uploaddate;//�ϴ�ʱ��
  private Product product;//��Ʒ
  private User user;//�����û�
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
