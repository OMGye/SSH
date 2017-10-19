package cn.itcast.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.CartItemService;
import cn.itcast.shop.service.OrderService;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.CartItem;
import cn.itcast.shop.vo.Order;
import cn.itcast.shop.vo.OrderItem;
import cn.itcast.shop.vo.User;
public class OrderAction extends SuperAction implements ModelDriven<Order>{
	private OrderService orderService;
    private CartItemService cartItemService;
	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	private Order order = new Order();
	public Order getModel() {		
		return order;
	}
	private Integer page;
	
    public void setPage(Integer page) {
		this.page = page;
	}
	public String save() {
    	User existUser = (User) session.getAttribute("existUser");
    	order.setUser(existUser);
    	Date sdate = new Date();
   	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	    String date= format.format(sdate);
   	    order.setDate(date);
   	    order.setState(1);//1:未付款,  2:已经付款没发货      3:已经发货但没有确认收货      4:交易完成
   	    PageBean<CartItem> pageBean = cartItemService.findAllByuid(existUser.getUid(),page);
   	    for(int i=0;i<pageBean.getList().size();i++){
   	    	OrderItem orderItem = new OrderItem();
   	    	orderItem.setOrder(order);
   	    	orderItem.setProduct(pageBean.getList().get(i).getProduct());
   	    	orderItem.setCount(pageBean.getList().get(i).getNum());
   	    	orderItem.setSubtotal(pageBean.getList().get(i).getProduct().getShop_price()*pageBean.getList().get(i).getNum());
   	    	order.getOrderItems().add(orderItem);
   	    	cartItemService.deleteByid(pageBean.getList().get(i));
   	    } 
   	    orderService.save(order);
   	    
    	return "save";
    }
	//查询所有订单
	public String select() {
		User existUser = (User) session.getAttribute("existUser");
		PageBean<Order> pageBean = orderService.findAllByuid(existUser.getUid(),page);
		 ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "select";
	}
	//根据订单号查询订单
	public String findByid() {
	    order = orderService.findByid(order.getOid());
		return "findByid";
	}
	public String updateState() {
		order = orderService.findByid(order.getOid());
		order.setState(4);
		orderService.update(order);
		return "updateState";
	}
}
