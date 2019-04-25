<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<style>
	label { display : block; padding-bottom:20px;}
	span { float:right;  width : 100px; height:20px;}
</style>
</head>
<body>
	<center>
		<h3>Member Login</h3><br>
		<hr>
		<form name="Loginform" action="/jspbook/member/MemberProcServlet?action=login" method=post>
		<table>
			<tr>
				<td>ID : </td><td><input type="text" name="id" size=10></td>
			</tr>
			<tr>
				<td>PASSWORD : </td><td><input type="password" name="password" size=10></td>
			</tr>
		</table><br>
			<input type="submit" value="로그인" name="B1">&nbsp;&nbsp;
			<button type="button" onclick="location.href='register.html'">회원가입</button>
		</form>
	</center>
</body>
</html>