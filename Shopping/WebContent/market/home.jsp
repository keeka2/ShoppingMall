<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="log_fail" class="">
		<form action="Controller?type=home" method="post">
			<table>
				<colgroup>
					<col width="50px"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<td><label for="s_id">ID:</label></td>
						<td>
							<input type="text" id="s_id" name="id"/>
						</td>
					</tr>
					<tr>
						<td><label for="s_pw">PW:</label></td>
						<td>
							<input type="password" id="s_pw" name="pw"/>
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="로그인"
							onclick="sendData()"/>								
						</td>
						<td>
							<input type="button" value="회원가입"
							onclick="javascript:location.href='Controller?type=register'"/>							
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
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