<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<style>
		table { border-collapse:collapse;}
		th { text-align:left;  padding : 5px 5px 5px 5px;}
		td { padding: 5px 5px 5px 5px; border:1px solid #BDBDBD; background-color:#ffffff; 
			padding-top:10px; padding-bottom:10px;
		}
		input[type=submit]{ background-color:#47C83E; border: 0 solid #47C83E; 
			color:#ffffff; width:400px; padding-top:10px; padding-bottom :10px; font-size:1.5em;
			margin-bottom:20px;
		 }
		 input[type=text],[type=password]{
		 	background-color:transparent;border:0 solid black; height:20px;
		 }
	</style>
</head>
<body  bgcolor=#F6F6F6>
	<center>
		<h3>Member Login</h3><br>
		
		<form name="Loginform" action="/jspbook/member/MemberProcServlet?action=login" method=post>
		<table>
			<tr>
				<td><input type="text" name="id" size=50 placeholder="아이디"></td>
			</tr>
			<tr>
				<td><input type="password" name="password" size=50 placeholder="비밀번호"></td>
			</tr>
		</table>
		<br>
			<input type="submit" value="로그인" name="B1">
		<hr>
			<button type="button" onclick="location.href='register.html'">회원가입</button>
		</form>
	</center>
</body>
</html>