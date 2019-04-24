<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글 수정</title>
	<style>
		table { border-collapse:collapse; width:550px;}
		th { width : 90px; text-align:center;  padding : 5px 5px 5px 5px; background-color:#FAED7D; }
		td { padding: 5px 5px 5px 5px;  width:500px;}
		.textbox {position: relative; width: 200px; margin: 15px}
	</style>
</head>
<body>
	<%
		BbsDTO bDto = (BbsDTO)request.getAttribute("memberID") ;
	%>
	<center>
	<h3>게시글 수정</h3>
	<%=(String)session.getAttribute("memberName") %> 회원님 반갑습니다.<br>
		<a href="bbs_list.jsp">게시글 목록</a>&nbsp;&nbsp;
		<a href="bbsWrite.jsp">글쓰기</a>&nbsp;&nbsp;
		<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
		<a href="/jspbook/member/MemberProcServlet?action=logout">로그아웃</a>
	<hr>
	<form name="Executeform" action="/jspbook/member/BbsServlet?action=execute" method=post>
		<input type="hidden" id="id" name="id" value="<%=bDto.getId() %>">
		<table border=1>
			<tr>
				<th>글번호</th>
				<td><%=bDto.getId() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=bDto.getTitle() %>" size=60></td>
			</tr>
			<tr>
				<th>날짜</th>
				<td><%=bDto.getDate().substring(0,16) %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="60" name="content"><%=bDto.getContent().replaceAll("<br>","\r\n") %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan=2 align=center>
					<input type="submit" value="수정" name="B1">&nbsp;&nbsp;
					<input type="reset" value="재작성" name="B2">
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>