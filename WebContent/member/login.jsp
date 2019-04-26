<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/login.css" rel="stylesheet">
<title>login</title>

</head>
<body>
	<center>
		<div id="logo"><b>Member Login</b></div>
		<form name="Loginform" action="/jspbook/member/MemberProcServlet?action=login" method=post>
		<table>
			<tr>
				<td><input type="text" name="id" size=50 placeholder="아이디"></td>
			</tr>
			<tr>
				<td><input type="password" name="password" size=50 placeholder="비밀번호"></td>
			</tr>
		</table>
		<input type="submit" value="로그인" name="B1" >
		<div style="border-top:1px solid #BDBDBD; width:400px;" >
			<br>
			<a href="register.html">회원가입</a>
		</div>
		</form>
	</center>
</body>
</html>