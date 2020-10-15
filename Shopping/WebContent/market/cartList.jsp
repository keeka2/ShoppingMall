<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                   <td colspan="6">:: 장바구니 내용</td>
               </tr>
               <tr bgcolor="#dedede">
                   <th>제품번호</th>
                   <th width="25%">제품명</th>
                   <th>단가</th>
                   <th>수량</th>
                   <th>금액</th>
                   <th>삭제</th>
               </tr>
			</thead>
			<tbody>
			
			<jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>
			<%
				int total = 0;//총 결제액
				
				ProductVO[] ar = cart.getList();
				if(ar!=null){
					for(ProductVO vo : ar){
			%>
            <tr align="center">
                <td><%=vo.getP_num() %></td>
                <td><%=vo.getP_name() %></td>
                <td>
                    정가:<%=vo.getP_price() %><br>
                    <font color="red">
                        세일가격:<%=vo.getP_saleprice() %>
                    </font>
                </td>
                <td>
                    <!-- 수량 조정 폼 -->
                    <form action="changeCount.jsp" method="post">
                    	<input type="hidden" name="p_num" value="<%=vo.getP_num()%>"/>
                    	<input type="text" name="count" value="<%=vo.getQuant()%>" size="2"/>
                    	<input type="submit" value="변경"/>
                    </form>
                    
                    <!------------------>
                </td>
                <td><%=vo.getTotalPrice() %></td>
                <td>
                    <input type="button" value="삭제" 
                    style="border:1 solid black;cursor:pointer" 
onclick="javascript:location.href='delProduct.jsp?p_num=<%=vo.getP_num()%>'">
                </td>
            </tr>
            <%
            total+=vo.getTotalPrice();
			}
				}else{
            %>

            <tr align="center">
                <td colspan="6">
                    <b>장바구니가 비었습니다.</b>
                </td>
            </tr>
            <%
            	}
			%>
            <tr>
                <td colspan="5" align="right">총 결재액 :<%=total %> </td>
                <td></td>
            </tr>

            </tbody>
        </table>
        
    </body>
</html>