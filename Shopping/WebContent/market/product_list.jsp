<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");
%>	
	<jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
	<jsp:setProperty property="*" name="sb"/><%-- 현재 페이지로 넘어올 때 전달되는 파라미터가
				category하나다. 이것이 sb 즉, ShopBean의 category라는 멤버변수에 자동으로 저장된다. --%>
<%
	//MyBatis환경을 이용하여 제품진열대를 채운다.
	sb.searchProduct();

	// 채워진 진열대를 현재 페이지에서 표현하기 위해 가져온다.
	ProductVO[] list = sb.getP_list();
	if(list!=null){
		for(ProductVO vo : list){
			System.out.println(vo.getP_name());
		}
	}
%>
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
	 <%
	 if(list!=null){
		 for(ProductVO vo : list){
 	%>
	<tbody>
	    <tr align="center">
	        <td><%=vo.getNum() %></td>
	        <td><img src="images/<%=vo.getP_image_s() %>" width="100" height="95"></td>
	        <td>
	            <a href="product_content.jsp?prod_num=<%=vo.getP_num() %>">
	            	<%=vo.getP_name() %>    
	            	<%-- db왕래 줄여야 속도 빨라짐 --%>
	            </a>
	        </td>
	        <td>
	            할인가 : <%=vo.getP_saleprice() %>원<br>
	            <font color="red">()</font>
	        </td>
	        <td>
	            시중 가격 : <%=vo.getP_price() %>원
	        </td>
	    </tr>
    </tbody>
    <%
		 }
		 }else{ %>
    <tr>
    	<td colspan="5" height="60" align="center">등록된 제품이 없습니다</td>
    </tr>
    <%} %>
   
</table>
</body>
</html>






