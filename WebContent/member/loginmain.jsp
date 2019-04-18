<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="member.*" %>
<%
	MemberDAO mDao = new MemberDAO();
	List<MemberDTO> list = mDao.selectCondition();
	mDao.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>메인 페이지</title>
</head>
<style>
	th, td { text-align:center;}
</style>
<body>
	<h3>회원 명단</h3>
	<hr>
	<table border="1" style="border-collapse:collapse;">
		<tr>
			<th>아이디</th><th>이름</th><th>생년월일</th><th>주소</th><th>액션</th>
		</tr>
		<%
			for(MemberDTO member : list){
		%>
		<tr>
			<td><%=member.getId() %></td>
			<td><%=member.getName() %></td>
			<td><%=member.getBirthday() %></td>
			<td><%=member.getAddress() %></td>
			<%
				String uri = "memberProcServlet?action=update&id=" + member.getId();
			%>
			<td>&nbsp;<button onclick="location.href='<%=uri %>'">수정</button>&nbsp;</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>