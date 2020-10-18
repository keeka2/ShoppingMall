<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cart</title>
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
            <thead>
               <tr>
                   <td colspan="6">:: 판매 물품</td>
               </tr>
               <tr bgcolor="#dedede">
                   <th>제품번호</th>
                   <th>사진</th>
                   <th width="25%">제품명</th>
                   <th>가격</th>
                   <th>삭제</th>
               </tr>
			</thead>
			<tbody>
			
			<c:if test="${cartList ne null }">
				<c:forEach var="vo" items="${requestScope.cartList }">
	            <tr align="center">
	                <td>${vo.p_key}</td>
	                <td><img src=${vo.p_thumbnail } width="100" height="95"></td>
	                <td>${vo.p_name}</td>
	                <td>${vo.p_price}</td>
	                <td>
	                    <input type="button" value="삭제" 
	                    style="border:1 solid black;cursor:pointer" 
						onclick="javascript:parent.location.href='Controller?type=sellDelete&p_key=${vo.p_key}'">
	                </td>
	            </tr>
            </c:forEach>
            </c:if>
            <c:if test="${cartList eq null }">

	            <tr align="center">
	                <td colspan="6">
	                    <b>판매물품이 없습니다.</b>
	                </td>
	            </tr>
            </c:if>

            </tbody>
        </table>
        
    </body>
</html>