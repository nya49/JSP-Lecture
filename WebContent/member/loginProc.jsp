<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDAO mDao = new MemberDAO();
	int id = Integer.parseInt(request.getParameter("id"));
	String password = request.getParameter("password");
	
	int result = mDao.verifyIdPAssword(id, password);
	String errorMessage = null;
	switch(result){
	case MemberDAO.ID_PASSWORD_MATCH:
		break;
	case MemberDAO.ID_DOES_NOT_EXIST:
		errorMessage = "ID 없음"; break;
	case MemberDAO.PASSWORD_IS_WRONG :
		errorMessage = "패스워드 틀림"; break;
	case MemberDAO.DATABASE_ERROR :
		errorMessage = "DB 오류";
	}
	mDao.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(result == MemberDAO.ID_PASSWORD_MATCH){
		response.sendRedirect("loginmain.jsp");
	} else {
%>
	<jsp:forward page="login.jsp">
		<jsp:param value="<%=errorMessage %>" name="error"/>
	</jsp:forward>
	<%
	}
	%>
</body>
</html>