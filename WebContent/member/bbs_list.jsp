<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, member.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	
	if(username != null){
		session.setAttribute("user", username);
	}
%>
<%
	BbsDAO bDao = new BbsDAO();
	List<BbsMember> list = bDao.selectAll();
	bDao.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>bbs_list.jsp</title>
</head>
<body>
	<div align="center">
		<h3>게시판 목록</h3>
		<a href="loginmain.jsp">회원목록</a>&nbsp;
		<a href="bbsWrite.jsp">글쓰기</a>
		<hr>
		<table border="1" style="border-collapse:collapse;">
			<tr>
				<th>번호</th><th>이름</th><th>제목</th><th>날짜</th><th>내용</th><th>액션</th>
			</tr>
			<%
				for (BbsMember bmDto: list){
			%>
			<tr>
				<td><%=bmDto.getId() %></td>
				<td><%=bmDto.getName() %></td>
				<td><%=bmDto.getTitle() %></td>
				<td><%=bmDto.getDate() %></td>
				<td><%=bmDto.getContent() %></td>
				<%
					String updateUri = "BbsServlet?action=update&id=" + bmDto.getId();
					String deleteUri = "BbsServlet?action=delete&id=" + bmDto.getId();
					
				%>
				<td>&nbsp;
				<button onclick="location.href='<%=updateUri %>'">수정</button>&nbsp;
				<button onclick="location.href='<%=deleteUri %>'">삭제</button>&nbsp;</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>