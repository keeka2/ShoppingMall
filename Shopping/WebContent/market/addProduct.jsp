<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>
<jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
<%
String pnum = request.getParameter("p_num");
cart.addProduct(sb, pnum);
response.sendRedirect("product_content.jsp?prod_num="+pnum);
%>