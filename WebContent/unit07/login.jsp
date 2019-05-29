<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
center { margin:10%; } 
table { border-spacing:10px;} /*table { border-collapse:collapse;}*/
th { text-align:left;}
td { 
	padding: 5px 5px 5px 5px; 
	border:1px solid #BDBDBD; 
	background-color:#ffffff; 
	padding-top:10px; 
	padding-bottom:10px;
	}
td:hover { border:1px solid #47C83E; }
input[type=submit]{ 
	background-color:#47C83E; 
	border: 0 solid #47C83E; 
	color:#ffffff; 
	width:400px; 
	padding-top:15px; 
	padding-bottom :15px; 
	font-size:1.5em;
	margin-bottom:20px; 
	font-family:"굴림"; 
	font-size:15pt;
	}
input[type=text],[type=password]{
		 background-color:#ffffff; 
		 border:0 solid black; height:30px;
		 margin-left:5px;
	}
</style>
</head>
<body>
	<center>
		<div id="logo"><b>Member Login</b></div>
		<form method="get" action="login_ok.jsp">
		<table>
			<tr>
				<td><input type="text" name="id" size=50 placeholder="아이디"></td>
			</tr>
			<tr>
				<td><input type="password" name="pass" size=50 placeholder="비밀번호"></td>
			</tr>
			<tr>
      			<td style="border:1px solid #ffffff; text-align:center">
	      			<label><input type="radio" name="user" value="1" >&nbsp;관리자</label>
	      			<label><input type="radio" name="user" value="2" >&nbsp;사용자</label>
      			</td>
      		</tr>
		</table>
		
		<input type="submit" value="로그인" name="B1" >
		</form>
	</center>
</body>
</html>