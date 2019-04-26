<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/update.css" rel="stylesheet">
	<title>게시글 수정</title>
</head>
<body>
	<center>
	<h3>게시글 수정</h3>
	${memberName} 회원님 반갑습니다.<br>
		<a href="BbsServlet?action=list&page=1">게시글 목록</a>&nbsp;&nbsp;
		<a href="bbsWrite.jsp">글쓰기</a>&nbsp;&nbsp;
		<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
		<a href="/jspbook/member/MemberProcServlet?action=logout">로그아웃</a>
	<hr>
	<c:set var="bm" value="${requestScope.memberID }" />
	<form name="Executeform" action="/jspbook/member/BbsServlet?action=execute&id=${bm.id}" method=post>
		<table>
			<tr>
				<th>글번호</th>
				<td>${bm.id }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${bm.title }" size=60></td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${bm.date }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="60" name="content">${bm.content}</textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="수정" name="B1">&nbsp;&nbsp;
		<input type="reset" value="재작성" name="B2">
	</form>
	</center>
</body>
</html>