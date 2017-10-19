<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>

<link href="./css/common.css" rel="stylesheet" type="text/css">
<link href="./css/cart.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/image/r___________renleipic_01/2.jpg" media="screen" />

</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/index.action">
				<img src="./image/r___________renleipic_01/1.jpg" alt="传智播客">
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="./image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
	<%@ include file="menu.jsp" %>
	
</div>	<div class="container cart">
		<div class="span24">
			<div class="step step1">
				
			</div>
				<table>
					<tbody><tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					  <s:iterator var="list" value="list">
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22">
								<img src="${pageContext.request.contextPath}/<s:property value="#list.product.image"/>">
							</td>
							<td>
								<a target="_blank" href="${pageContext.request.contextPath}/product_findOne.action?pid=<s:property value="#list.product.pid"/>"> <s:property value="#list.product.pname"/></a>
							</td>
							<td>
								￥<s:property value="#list.product.shop_price"/>
							</td>
							<td class="quantity" width="60">
								<s:property value="#list.num"/>
							</td>
							<td width="140">
								<span class="subtotal">￥<s:property value="#list.product.shop_price*#list.num"/></span>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/cart_deleteByid.action?caid=<s:property value="#list.caid"/>" class="delete">删除</a>
							</td>
						</tr>
						</s:iterator>
				</tbody></table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="pagination">
          <span>  第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页</span>
           <s:if test="pageBean.page!=1">
			<a class="firstPage" href="${pageContext.request.contextPath}/cart_toCartPage.action?page=1">&nbsp;</a>			
			<a class="previousPage" href="${pageContext.request.contextPath}/cart_toCartPage.action?page=<s:property value='pageBean.page-1'/>">&nbsp;</a>
			</s:if>	
			  <s:iterator var="i" begin="1" end="pageBean.totalPage">
			    <s:if test="pageBean.page != #i">
				<a href="${pageContext.request.contextPath}/cart_toCartPage.action?page=<s:property value='#i'/>"><s:property value='#i'/></a>
				</s:if>
				<s:else>
				 <span class="currentPage"><s:property value="#i"/></span>
				</s:else>
				</s:iterator>
				 <s:if test="pageBean.page!=pageBean.totalPage">
			<a class="nextPage" href="${pageContext.request.contextPath}/cart_toCartPage.action?page=<s:property value='pageBean.page+1'/>">&nbsp;</a>			
			<a class="lastPage" href="${pageContext.request.contextPath}/cart_toCartPage.action?page=<s:property value='pageBean.totalPage'/>">&nbsp;</a>
	      </s:if>
	     </div>
				<div class="total">
					<em id="promotion"></em>
							<em>
								登录后确认是否享有优惠
							</em>
					赠送积分: <em id="effectivePoint"><s:property value="totalprice"/></em>
					商品金额: <strong id="effectivePrice">￥<s:property value="totalprice"/></strong>
				</div>
				<div class="bottom">
					<a href="${pageContext.request.contextPath}/cart_deleteByuid.action" id="clear" class="clear">清空购物车</a>
					<a href="${pageContext.request.contextPath}/order_save.action?total=<s:property value="totalprice"/>&page=<s:property value="pageBean.page"/>" id="submit" class="submit">提交订单</a>
				</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="./image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 20016-2017 网上商城 版权所有   </div>
		<div class="copyright"><a href='http://www.miibeian.gov.cn' target='_blank'>鄂ICP备17019305号</a></div>
	</div>
</div>
</body></html>
