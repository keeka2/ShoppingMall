<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
<jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>
<%
	String pnum = request.getParameter("p_num");
	int q = Integer.parseInt(request.getParameter("count"));
	cart.changeCount(pnum, q);
	response.sendRedirect("cartList.jsp");
%>