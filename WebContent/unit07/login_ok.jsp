<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<c:choose>
			<c:when test="${param.id eq 'root' && param.pass eq '1234' && param.user eq '1'}">
				당신은 관리자입니다.
			</c:when>
			<%-- <c:otherwise>당신은 사용자입니다.</c:otherwise> --%>
			<c:when test="${param.id ne 'root' || param.pass ne '1234' || not param.user ne '1'}">
				당신은 사용자입니다.
			</c:when>
		</c:choose>
	</center>
</body>
</html>