package cn.itcast.shop.vo;

public class OrderItem {
	private Integer Itemid;
	private Integer count;
	private Double subtotal;
	private Product product;
	private Order order;

	public Integer getItemid() {
		return Itemid;
	}

	public void setItemid(Integer itemid) {
		Itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
