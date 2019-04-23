<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	
	if(username != null){
		session.setAttribute("user", username);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Twitter</title>
</head>
<body>
	<div align="center">
		<h3>My Simple Twitter!!</h3>
		<a href="loginmain.jsp">회원목록</a>
		<hr>
		<form action="/jspbook/member/TweetServlet" method="post">
			@<%=session.getAttribute("memberName") %>&nbsp;
			<input type="text" name="msg">&nbsp;&nbsp;
			<input type="submit" value="트윗">
		</form>
	
		<hr>
		<div align=left>
			<ul>
				<%
					ArrayList<String> msgs = (ArrayList<String>)application.getAttribute("msgs");
					if(msgs != null){
						for(String msg : msgs){
							out.println("<li>"+msg+"</li>");
						}
					}
				%>
			</ul>
		</div>
	</div>
</body>
</html>