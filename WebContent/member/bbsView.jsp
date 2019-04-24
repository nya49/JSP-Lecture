<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, member.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글</title>
	<style>
		table { border-collapse:collapse; width:550px;}
		th { width : 90px; text-align:center;  padding : 5px 5px 5px 5px; background-color:#FAED7D; }
		td { padding: 5px 5px 5px 5px;  width:500px;}
	</style>
</head>
<body>
	<%
		BbsDTO bDto = (BbsDTO)request.getAttribute("memberID");
		String updateUri = "BbsServlet?action=update&id=" + bDto.getId();
		String deleteUri = "BbsServlet?action=delete&id=" + bDto.getId();
	%>
	<center>
	<h3>게시글</h3>
	<%=(String)session.getAttribute("memberName") %> 회원님 반갑습니다.<br>
		<a href="bbs_list.jsp">게시글 목록</a>&nbsp;&nbsp;
		<a href="bbsWrite.jsp">글쓰기</a>&nbsp;&nbsp;
		<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
		<a href="/jspbook/member/MemberProcServlet?action=logout">로그아웃</a>
	<hr>
		<input type="hidden" id="id" name="id" value="<%=bDto.getId() %>">
		<table border=1>
			<tr>
				<th>글번호</th>
				<td><%=bDto.getId() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=bDto.getTitle() %></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td></td>
			</tr>
			<tr>
				<th>날짜</th>
				<td><%=bDto.getDate().substring(0,16) %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<%=bDto.getContent() %>
				</td>
			</tr>
			<tr>
				<td align=center colspan=2>
					<button onclick="location.href='<%=updateUri %>'">수정</button>&nbsp;
					<button onclick="location.href='<%=deleteUri %>'">삭제</button>&nbsp;
				</td>
			</tr>
		</table>
	</center>
</body>
</html>