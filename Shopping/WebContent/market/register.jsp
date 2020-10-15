<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
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
	
	div#wrap{
		width: 400px;
		margin: 30px auto;
	}
	
	table th, table td{
		padding: 3px;
	}
	table tbody td>input{
		width: 120px;
		border: 1px solid #27a;
		border-radius: 3px;
		padding: 4px;
	}
	.txt_r{ text-align: right; }
	.phone{ width: 50px; }
	
	.success{ color: #00f; font-weight: bold; font-size: 11px;}
	.fail{ color: #f00; font-weight: bold; font-size: 11px; }
	
	div#box{
		display: inline-block;
		width: 65px;
		height: 20px;
		padding: 0;
		margin: 0;
		margin-left: 3px;
	}
</style>
</head>
<body>
	<div id="wrap">
		<form action="Controller?type=register" method="post">
			<table>
				<colgroup>
					<col width="100px"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th><label for="reg_id">ID:</label></th>
						<td>
							<input type="text" id="reg_id" name="id"/>
							<div id="box"></div>
						</td>
					</tr>
					<tr>
						<th><label for="reg_pw">PW:</label></th>
						<td>
							<input type="text" id="reg_pw" name="pw"/>
						</td>
					</tr>
					<tr>
						<th><label for="reg_name">NAME:</label></th>
						<td>
							<input type="text" id="reg_name" name="name"/>
						</td>
					</tr>
					<tr>
						<th><label for="reg_addr">ADDR:</label></th>
						<td>
							<input type="text" id="reg_addr" name="addr"/>
						</td>
					</tr>
					<tr>
						<th><label for="reg_phone">PHONE:</label></th>
						<td>
							<input type="text" id="reg_phone" name="phone"/>
						</td>
					</tr>
					<tr>
						<th>
							<label for="reg_email">EMAIL:</label>
						</th>
						<td>
							<input type="text" id="reg_email" name="email"/>
						</td>
					</tr>					
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" >
							<p class="btn">
								<input type="button" value="보내기"
								onclick="sendData()"/>
							</p>
						</td>
					</tr>
				</tfoot>
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




