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
        
	table{
		width: 600px;
		font-size: 12px;
		border-collapse: collapse;
		border: 1px solid black;
		padding: 4px;
		margin: 0 auto;
	}
	table tbody tr{
		border: 1px solid black;
	}
	table td{
		padding: 4px;
	}
</style>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<table>
		   	<colgroup>
		   		<col width="40%">
		   		<col width="60%">
		   	</colgroup>
			<tbody>
			    <tr>
			        <td>제품Category</td>
			        <td>${pvo.p_category }</td>
			    </tr>
			    <tr>
			        <td>제품번호</td>
			        <td>${pvo.p_key }</td>
			    </tr>
			    <tr>
			        <td>제품이름</td>
			        <td>${pvo.p_name }</td>
			    </tr>

			    <tr>
			        <td>제품가격</td>
			        <td>${pvo.p_price }</td>
			    </tr>
			    <tr>
			        <td>제품설명</td>
			        <td>${pvo.p_content }</td>
			    </tr>

			    <tr>
			        <td colspan="2" align="center"><img src ="${pvo.p_image }"></td>
			    </tr>
			    <tr>
			        <td colspan="2"></td>
			    </tr>

			    <tr>
			        <td colspan="2" align="center">
			            <input type="button" value="장바구니에 담기" 
			            onclick="javascript:location.href='addProduct.jsp?p_num='"/>
			            <input type="button" value="장바구니 보기" 
			            onclick="javascript:location.href='cartList.jsp'"/>
			        </td>
			    </tr> 
		    </tbody>   
		</table>
</body>
</html>