<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#title{
		font-size:30px;
		color: maroon;
	}
	.txt_c{text-align: center}
       a:link{text-decoration:none; color:navy}
       a:visited{text-decoration:none; color:navy}
       a:hover{text-decoration:none; color:red}
	.empty{
		text-align: center;
		height: 50px;
		line-height: 50px;
		font-size: 12px;
	}
</style>
</head>
<body>
<jsp:include page="nav.jsp"/>

<table align="center" width="600" border="1" 
 style="border-collapse:collapse;font-size:8pt" bordercolor="navy"  
 cellpadding="4" cellspacing="0">

 	<thead>
	    <tr bgcolor="#dedede">
	        <th width="10%">제품번호</th>
	        <th width="10%">이미지</th>
	        <th width="35%">제품명</th>
	        <th width="20%">제품가격</th>
	        <th width="25%">비고</th>
	    </tr>
	</thead>
	<c:if test="${arr ne null }">
		<c:forEach var="vo" items="${requestScope.arr }">
			<tbody>
			    <tr align="center">
			        <td></td>
			        <td><img src="images/" width="100" height="95"></td>
			        <td>
			            <a href="product_content.jsp?prod_num=">
			            	    
			            	<%-- db왕래 줄여야 속도 빨라짐 --%>
			            </a>
			        </td>
			        <td>
			            할인가 : 원<br>
			            <font color="red">()</font>
			        </td>
			        <td>
			            시중 가격 : 원
			        </td>
			    </tr>
		    </tbody>
    	</c:forEach>
    </c:if>

   
</table>
</body>
</html>






