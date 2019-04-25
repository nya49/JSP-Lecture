<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원정보 수정</title>
</head>
<style>
	table { border-collapse:collapse;}
	th { text-align:center; background-color:#FAED7D; width:100px;}
	td { padding: 5px 5px 5px 5px;}
</style>
<body>
	<div align="center">
	<h3>회원정보 수정</h3>
	<hr>
	<c:set var="bm" value="${requestScope.member }" />
	<form name="Registerform" action="/jspbook/member/MemberProcServlet?action=execute&id=${bm.id}" method=post>
		<table border=1>
			<tr>
				<th>아이디</th>
				<td>${bm.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${bm.name }" size=30></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="birthday" value="${bm.birthday}" size=30></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value="${bm.address }" size=30></td>
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