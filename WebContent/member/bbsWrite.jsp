<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글 작성</title>
</head>
<body>
	<h3>게시글 작성</h3>
	<hr>
	<form name="Registerform" action="/jspbook/member/BbsServlet?action=write" method=post>
			<label><span>제목 : </span>
				<input type="text" name="title" size=20></label>
			<label><span>내용 : </span>
				<input type="text" name="content"  size=50></label>	
			<label>
				<input type="submit" value="작성" name="B1">&nbsp;&nbsp;
				<input type="reset" value="재작성" name="B2">
			</label>
	</form>
</body>
</html>