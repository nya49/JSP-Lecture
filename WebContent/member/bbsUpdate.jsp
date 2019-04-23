<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글 수정</title>
	<style>
		label { display : block; padding-bottom:20px;}
		span { float:left;  width : 100px; height:20px;}
	</style>
</head>
<body>
	<%
		BbsDTO bDto = (BbsDTO)request.getAttribute("memberID") ;
	%>
	<h3>게시글 수정</h3>
	<hr>
	<form name="Executeform" action="/jspbook/member/BbsServlet?action=execute" method=post>
		<input type="hidden" id="id" name="id" value="<%=bDto.getId() %>">
		<label><span>아이디 : </span>
				<%=bDto.getId() %></label>
			<%-- <label><span>이름 : </span>
				<%=mem.getName() %></label> --%>
			<label><span>제목 : </span>
				<input type="text" name="title" value="<%=bDto.getTitle() %>" size=20></label>
			<label><span>날짜 : </span>
				<%=bDto.getDate() %></label>
			<label><span>내용 : </span>
				<input type="text" name="content" value="<%=bDto.getContent() %>" size=50></label>	
			<label>
				<input type="submit" value="수정" name="B1">&nbsp;&nbsp;
				<input type="reset" value="재작성" name="B2">
			</label>
	</form>
</body>
</html>