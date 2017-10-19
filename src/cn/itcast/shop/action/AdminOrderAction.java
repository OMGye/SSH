package cn.itcast.shop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.OrderService;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.Order;
import cn.itcast.shop.vo.OrderItem;


public class AdminOrderAction extends SuperAction implements ModelDriven<Order>{

	private Order order = new Order();
	public Order getModel() {		
		return order;
	}
   private OrderService orderService;
   public void setOrderService(OrderService orderService) {
	this.orderService = orderService;
    }
    private Integer page;
   public void setPage(Integer page) {
	this.page = page;
    }
   public String findAllByPage() {
	   PageBean<Order> pageBean = orderService.findAllByPage(page);
	   ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	   return "findAllByPage";
   }
   public String findOrderItem() {
	   List<OrderItem> list = orderService.findOrderItem(order.getOid());
	   ActionContext.getContext().getValueStack().set("list", list);
	   return "findOrderItem";
   }
   public String updateState(){
	   order = orderService.findByid(order.getOid());
	   order.setState(3);
	   orderService.update(order);
	   return "updateState";
   }
   
}
