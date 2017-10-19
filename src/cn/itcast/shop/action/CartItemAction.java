package cn.itcast.shop.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.service.CartItemService;
import cn.itcast.shop.service.ProductService;
import cn.itcast.shop.util.PageBean;
import cn.itcast.shop.vo.CartItem;
import cn.itcast.shop.vo.Product;
import cn.itcast.shop.vo.User;

public class CartItemAction extends SuperAction implements ModelDriven<CartItem>{
    private CartItemService cartItemService;
    private ProductService productService;
    
    public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private CartItem cartItem = new CartItem();
   
	public CartItem getModel() {		
		return cartItem;
	}
	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	} 
	//查看购物车
    public String toCartPage() {
      if(page==null) {
    	  page = 1;
      }
      if(session.getAttribute("existUser")==null){
    	  return "userExist";
      }	
      User user = (User) session.getAttribute("existUser");
      PageBean<CartItem> pageBean = cartItemService.findAllByuid(user.getUid(),page);
      List<CartItem> list = pageBean.getList();
      double totalprice = 0;
      for(CartItem cartItem :list) {
    	  totalprice += cartItem.getProduct().getShop_price()*cartItem.getNum();
      }
  	 ActionContext.getContext().getValueStack().set("list", list);
  	 ActionContext.getContext().getValueStack().set("pageBean", pageBean);
  	 ActionContext.getContext().getValueStack().set("totalprice", totalprice);
    	return "toCartPage";
    }
  
	private Integer pid;
    
    public void setPid(Integer pid) {
		this.pid = pid;
	}
    //添加到购物车
	public String addCart() {
	   if(session.getAttribute("existUser")==null){
	   	  return "userExist";
       }
	   Date date = new Date();
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String sdate= format.format(date);
	   //判断购物项是否存在
		User user = (User) session.getAttribute("existUser");
      CartItem selectCartItem = cartItemService.findBypidAnduid(pid,user.getUid());
       if(selectCartItem!=null){
    	  int num1 = cartItem.getNum();
    	  int num2 = selectCartItem.getNum();
    	   selectCartItem.setNum(num1+num2);
    	   selectCartItem.setUpdatedate(sdate);
    	   cartItemService.update(selectCartItem);
       }else{
    	   
    	   Product product = productService.findOne(pid);
    	   cartItem.setUpdatedate(sdate);
    	   cartItem.setUploaddate(sdate);
    	   cartItem.setProduct(product);
    	   cartItem.setUser(user);
    	   cartItemService.add(cartItem);
       }
    	return "addCart";
    }	  
	//根据商品id删除购物项
	public String deleteByid() {
		cartItemService.deleteByid(cartItem);
		return "deleteByid";
	}
	//根据用户id删除购物项
		public String deleteByuid() {
		 User user = (User) session.getAttribute("existUser");
	     cartItemService.deleteByuid(user.getUid());
			return "deleteBypid";
		}
}
