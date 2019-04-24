<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원정보 수정</title>
</head>
<style>
	table { width:500px; border-collapse:collapse;}
	th { text-align:left;  }
</style>
<body>
<%
	//String error = request.getParameter("error");
	MemberDTO member = (MemberDTO) request.getAttribute("member");
%>
	<div align="center">
	<h3>회원정보 수정</h3>
	<hr>
	<form name="Registerform" action="/jspbook/member/MemberProcServlet?action=execute" method=post>
		<input type="hidden" id="id" name="id" value="<%=member.getId() %>">
		<table>
			<tr>
				<th>아이디</th>
				<td><%=member.getId() %></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="<%=member.getName() %>" size=30></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="birthday" value="<%=member.getBirthday() %>" size=30></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value="<%=member.getAddress() %>" size=30></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
				<input type="submit" value="수정" name="B1">&nbsp;&nbsp;
				<input type="reset" value="재작성" name="B2">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>