<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/update.css" rel="stylesheet">
	<title>회원정보 수정</title>
</head>
<body>
	<div align="center">
	<h3>회원정보 수정</h3>
	${memberName} 회원님 반갑습니다. <br>
	<a href="BbsServlet?action=list&page=1">게시판</a>&nbsp;&nbsp;
	<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
	<a href="/jspbook/member/MemberProcServlet?action=logout">로그아웃</a>
	<hr>
	<c:set var="bm" value="${requestScope.member }" />
	<form name="Registerform" action="/jspbook/member/MemberProcServlet?action=execute&id=${bm.id}" method=post>
		<table>
			<tr>
				<th>아이디</th>
				<td>${bm.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${bm.name }" size=50></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="birthday" value="${bm.birthday}" size=50></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value="${bm.address }" size=50></td>
			</tr>
		</table>
		<input type="submit" value="수정" name="B1">
	</form>
	</div>
</body>
</html>