<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/list.css" rel="stylesheet">
	<title>bbs_list.jsp</title>
</head>
<body>
	<center>
		<h3>게시판 목록</h3>
		${memberName} 회원님 반갑습니다.<br>
		<a href="MemberProcServlet?action=list&page=1">회원목록</a>&nbsp;&nbsp;
		<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
		<a href="/jspbook/member/MemberProcServlet?action=logout">로그아웃</a>
		<hr>
		<div style="text-align:right; width:660px;"><a href="fileServlet?action=bbs">게시글 목록 다운로드</a></div>
		<table>
			<tr>
				<th width=50>글번호</th><th width=300>제목</th><th width=70>글쓴이</th><th width=100>날짜</th><th width=150>액션</th>
			</tr>
			<c:set var="bmList" value="${requestScope.bbsMemberList}"/>
				<c:forEach var="bm" items="${bmList}">
					<tr>
						<td align=center>${bm.id}</td>
						<td><a href="BbsServlet?action=view&id=${bm.id}">${bm.title}</a></td>
						<td align=center>${bm.name}</td>
						<td align=center>${bm.date}</td>
						<td align=center>
							<button onclick="location.href='BbsServlet?action=update&id=${bm.id}'">수정</button>&nbsp;
							<button onclick="location.href='BbsServlet?action=delete&id=${bm.id}'">삭제</button>
						</td>
					</tr>
				</c:forEach>
		</table>
		
		<c:set var="pageList" value="${requestScope.pageList}"/>
		<c:forEach var="pageNo" items="${pageList}">
			${pageNo}
		</c:forEach>
		<div align=right style="width:650px; "><input type="button" onclick="href='bbsWrite.jsp'" value="글쓰기"></div>
	</center>
</body>
</html>