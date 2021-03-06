<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<table align="center" width="600" border="0" 
 style="border-collapse:collapse;font-size:8pt" bordercolor="navy"  
 cellpadding="4" cellspacing="0">
 	<thead>
 		<tr>
 		<th>
		<form action="Controller?type=list" method="post">
			<select name="category">
				<option value="all">전체</option>
				<option value="computer">컴퓨터</option>
				<option value="electronic">가전 제품</option>
				<option value="sports">스포츠</option>
				<option value="cloth">의류</option>
			</select>
			<label for="p_search"></label><input type="text" id="p_search" name="search"/>
			<input type="button" value="검색" onclick="sendData()"/>
		</form>
		</th>
		</tr>
	</thead>
</table>


<table align="center" width="600" border="1" 
 style="border-collapse:collapse;font-size:8pt" bordercolor="navy"  
 cellpadding="4" cellspacing="0">

 	<thead>
	    <tr bgcolor="#dedede">
	        <th width="10%">제품번호</th>
	        <th width="10%">이미지</th>
	        <th width="35%">제품명</th>
	        <th width="20%">제품가격</th>
	        <th width="25%">조회수</th>
	    </tr>
	</thead>
	<tfoot align="center" style="border-collapse:collapse;font-size:15pt">
		<tr>
			<td colspan="5">
				${page_html }
			</td>
		</tr>
	</tfoot>
	<tbody>
	<c:if test="${p_list ne null }">
		<c:forEach var="vo" items="${requestScope.p_list }">
			
			    <tr align="center">
			        <td>${vo.p_key }</td>
			        <td><img src=${vo.p_thumbnail } width="100" height="95"></td>
			        <td>
			            <a href="Controller?type=view&p_key=${vo.p_key }">
			            	${vo.p_name }
			            </a>
			        </td>
			        <td>
			            ${vo.p_price }<br>
			        </td>
			        <td>
			            ${vo.p_quant }
			        </td>
			    </tr>
		    
    	</c:forEach>
    </c:if>
    </tbody>
	<c:if test="${p_list eq null }">
	    <tr>
	    	<td colspan="5" height="60" align="center">등록된 제품이 없습니다</td>
	    </tr>
    </c:if>

   
</table>
	<script type="text/javascript">
		function sendData(){
			for(var i=0 ; i<document.forms[0].elements.length ; i++){
				//입력 검사
				if(document.forms[0].elements[i].value == ""){
					alert(document.forms[0].elements[i].name+"를 입력하세요");
					document.forms[0].elements[i].focus();
					return;//수행 중단
				}
			}
			document.forms[0].submit();
		}
	</script>
</body>
</html>






