<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/admin/head.jspf" %>
  </head>
  
  <body>
  	
  	<table>
  		<tr>
  			<td>商品名称</td>
  			<td>商品价格</td>
  			<td>商品数量</td>
  			<td>小计</td>
  			<td>操作</td>
  		</tr>
  	
  	
  	<c:forEach items="${sessionScope.forder.sorderSet}" var="sorder" >
  		<tr>
  			<td>${sorder.name}</td>
  			<td>${sorder.price}</td>
  			<td><input type="text" size="2"  value="${sorder.number}"/></td>
  			
  			<td>${sorder.price*sorder.number}</td>
  			<td>更新 删除</td>
  		</tr>
  	</c:forEach>
  		<tr>
  			<td colspan="6">总价格：${sessionScope.forder.total} </td>
  		</tr>
 </table>
  </body>
</html>
    	
 