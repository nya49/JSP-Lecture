<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원정보 수정</title>
	<style>
		label { display : block; padding-bottom:20px;}
		span { float:left;  width : 100px; height:20px;}
	</style>
</head>
<body>
<%
	//String error = request.getParameter("error");
	MemberDTO member = (MemberDTO) request.getAttribute("member");
%>
	<h3>회원정보 수정</h3>
	<hr>
	<form name="Registerform" action=/jspbook/member/updatememberProcServlet method=post>
		<input type="hidden" id="id" name="id" value="<%=member.getId() %>">
		<label><span>아이디 : </span>
				<%=member.getId() %></label>
			<label><span>이름 : </span>
				<input type="text" name="name" value="<%=member.getName() %>" size=10></label>
			<label><span>생년월일 : </span>
				<input type="text" name="birthday" value="<%=member.getBirthday() %>" size=10></label>
			<label><span>주소 : </span>
				<input type="text" name="address" value="<%=member.getAddress() %>" size=10></label>
			<label>
				<input type="submit" value="수정" name="B1">&nbsp;&nbsp;
				<input type="reset" value="재작성" name="B2">
			</label>
	</form>
</body>
</html>