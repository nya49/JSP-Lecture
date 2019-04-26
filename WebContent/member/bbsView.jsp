<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/update.css" rel="stylesheet">
	<title>게시글</title>
</head>
<body>
	<center>
	<h3>게시글</h3>
	${memberName} 회원님 반갑습니다.<br>
		<a href="BbsServlet?action=list&page=1">게시글 목록</a>&nbsp;&nbsp;
		<a href="bbsWrite.jsp">글쓰기</a>&nbsp;&nbsp;
		<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
		<a href="/jspbook/member/MemberProcServlet?action=logout">로그아웃</a>
	<hr>
	<br>
		<c:set var="bm" value="${requestScope.bbsMember }" />
		<table>
			<tr>
				<th>글번호</th>
				<td width=500>${bm.id }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${bm.title }</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>${bm.name }</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${bm.date }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bm.content }</td>
			</tr>
		</table>
		<button onclick="location.href='BbsServlet?action=update&id=${bm.id}'">수정</button>&nbsp;
		<button onclick="location.href='BbsServlet?action=delete&id=${bm.id}'">삭제</button>
	</center>
</body>
</html>