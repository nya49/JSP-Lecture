<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scriptlet1.jsp</title>
</head>
<body>
	<div align="center">
		<h2>스크립트릿 테스트3</h2>
		<hr>
		<table border="1">
			<tr>
				<th bgcolor="green" width="30">X</th><th bgcolor="green">Y(=X*Y)</th>
			</tr>
			<%
			for(int i=1; i<10; i++){
			%>
			<tr>
				<td align="center"><%=i %></td><td align="center"><%=i*i %></td>
				<%
				}
				%>
			</tr>
		</table>
		
	</div>
</body>
</html>