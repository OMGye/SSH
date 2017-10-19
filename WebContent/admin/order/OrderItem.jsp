<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table border="0" width="100%">
   <s:iterator value="list" var="OrderItem">
   <tr>
     <td><img width="60" height="65" src="${pageContext.request.contextPath}/<s:property value="#OrderItem.product.image"/>"></td>
     <td><s:property value="#OrderItem.count"/></td>
     <td><s:property value="#OrderItem.subtotal"/></td>
   </tr>
   </s:iterator>
</table>
