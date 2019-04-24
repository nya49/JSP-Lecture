<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, member.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	List<BbsMember> bmList = (List<BbsMember>) request.getAttribute("bbsMemberList");
	List<String> pageList = (List<String>) request.getAttribute("pageList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>bbs_list.jsp</title>
</head>
<style>
	table { width:500px; border-collapse:collapse;}
	th { text-align:center; background-color:#FAED7D; }
	td { padding: 5px 5px 5px 5px;}
</style>
<body>
	<div align="center">
		<h3>게시판 목록</h3>
		<%=(String)session.getAttribute("memberName") %> 회원님 반갑습니다.<br>
		<a href="loginmain.jsp">회원목록</a>&nbsp;&nbsp;
		<a href="bbsWrite.jsp">글쓰기</a>&nbsp;&nbsp;
		<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
		<a href="/jspbook/member/MemberProcServlet?action=logout">로그아웃</a>
		<hr>
		<table border="1" style="border-collapse:collapse;">
			<tr>
				<th>글번호</th><th>제목</th><th>이름</th><th>날짜</th><th>액션</th>
			</tr>
			<%
				for (BbsMember bmDto: bmList){
			%>
			<%
				String viewUri = "BbsServlet?action=view&id=" + bmDto.getId();
				String updateUri = "BbsServlet?action=update&id=" + bmDto.getId();
				String deleteUri = "BbsServlet?action=delete&id=" + bmDto.getId();
			%>
			<tr>
				<td align=center><%=bmDto.getId() %></td>
				<td><a href="<%=viewUri %>"><%=bmDto.getTitle() %></a></td>
				<td align=center><%=bmDto.getName() %></td>
				<td align=center><%=bmDto.getDate().substring(0,16) %></td>
				<td>&nbsp;
				<button onclick="location.href='<%=updateUri %>'">수정</button>&nbsp;
				<button onclick="location.href='<%=deleteUri %>'">삭제</button>&nbsp;</td>
			</tr>
			<%
				}
			%>
		</table>
		<%
		for (String bmPage: pageList)
			out.print(bmPage);
		%>
	</div>
	
</body>
</html>