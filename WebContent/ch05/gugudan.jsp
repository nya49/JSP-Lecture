<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gugudan.jsp</title>
</head>
<body>
	<div align="center">
		<h2>구구단(홀수)</h2>
		<hr>
		<table border="1">
			<tr>
				<th bgcolor="green" width="30"></th>
				<%
				for(int i=2; i<10; i++){
					++i;
				%>
				<th bgcolor="green" width="30"><%=i %>단</th>
				<%
				}
				%>
			</tr>
			
			<%
			for(int i=2; i<10; i++){
				++i;
			%>
			<tr>
				<td align="center" ><%=i %></td>
				<td align="center"><%=i*3 %></td>
				<td align="center"><%=i*5 %></td>
				<td align="center"><%=i*7 %></td>
				<td align="center"><%=i*9 %></td>
				
			</tr>
			<%
				}
				%>
		</table>
		
	</div>
</body>
</html>