<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style type="text/css">
	.btn{
		width: 70px;
		height: 20px;
		text-align: center;
		padding:0px;		
	}
	.btn a{
		display: block;
		width: 100%;
		padding: 4px;
		height: 20px;
		line-height: 20px;
		background: #27a;
		color: #fff;
		border-radius: 3px;
		text-decoration: none;
		font-size: 12px;
		font-weight: bold;
	}
	.btn a:hover{
		background: #fff;
		color: #27a;
		border: 1px solid #27a;
	}
	
	#s_id, #s_pw{
		width: 80px;
		border: 1px solid #27a;
		border-radius: 3px;
		padding: 4px;
	}
	div#log_fail, div#log_suc{
		width: 170px;
		border: 1px solid #27a;
		border-radius: 3px;
	}
	.hide{ display: none; }
	.show{ display: block; }
	.txt_r{ padding-left: 10px;}
</style>
</head>
<body>

	<div id="log_suc" class="">
		
		<p>(ㅁㅁㅁ)님 환영</p>
		<p>
			<input type="button" value="로그아웃"
							onclick="javascript:parent.location.href='Controller?type=logout'"/>
		</p>
		<p>
			<input type="button" value="장바구니"
							onclick="javascript:parent.location.href='Controller?type=cart'"/>
		</p>

		<p>
			<input type="button" value="글쓰기"
							onclick="javascript:parent.location.href='Controller?type=sell'"/>
		</p>
	</div>
</body>
</html>