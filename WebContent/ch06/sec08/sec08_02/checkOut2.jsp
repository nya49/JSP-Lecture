<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, jspbook.ch06.CartDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>checkOut.jsp</title>
</head>
<body>
	<center>
		<h2>계산</h2>
		선택한 상품 목록
		<hr>
		<%
			ArrayList<CartDTO> list = (ArrayList<CartDTO>)session.getAttribute("productList");
			if(list == null) {
				out.println("선택한 상품이 없습니다.!!!");
			}
			else {
				for(CartDTO cart: list) {
					//out.println(cart.toString()+"<BR>");
					out.println(cart.getProductName() + " " + cart.getQuantity() + "개<br>");
				}
			}
		%>
	</center>
</body>
</html>