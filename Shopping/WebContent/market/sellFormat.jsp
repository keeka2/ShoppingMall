<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:580px;
	    margin-left:10px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	
	.odd {background:silver}
	
		
</style>
<script type="text/javascript">
	function sendData(){
		for(var i=0 ; i<document.forms[0].elements.length ; i++){
			if(document.forms[0].elements[i].value == ""){
				alert(document.forms[0].elements[i].name+
						"를 입력하세요");
				document.forms[0].elements[i].focus();
				return;//수행 중단
			}
		}

//		document.forms[0].action = "test.jsp";
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div id="bbs">
	<form action="Controller?type=sell" method="post" 
	encType="multipart/form-data">
		<table summary="게시판 글쓰기">
			<caption>물품 정보</caption>
			<tbody>
				<tr>
					<th>제품 이름:</th>
					<td><input type="text" name="p_name" size="45"/></td>
				</tr>
				<tr>
					<th>상세 정보:</th>
					<td><textarea name="p_content" cols="50" rows="8"></textarea></td>
				</tr>
				<tr>
					<th>가격:</th>
					<td><input type="number" name="p_price" size="45"/></td>
				</tr>
				<tr>
					<th>카테고리:</th>
					<td>
						<select name="p_category">
						    <option value="computer">컴퓨터</option>
						    <option value="electronic">가전 제품</option>
						    <option value="sports">스포츠</option>
						    <option value="cloth">의류</option>
						</select>
					</td>
				</tr>
				<input type="hidden" name="p_quant"  value="0"/>
				<tr>
					<th>썸네일:</th>
					<td><input type="file" name="p_thumbnail"/></td>
				</tr>

				<tr>
					<th>상세 사진:</th>
					<td><input type="file" name="p_image"/></td>
				</tr>

				<tr>
					<td colspan="2">
						<input type="button" value="보내기"
						onclick="sendData()"/>
						<input type="button" value="다시"/>
						<input type="button" value="목록"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>