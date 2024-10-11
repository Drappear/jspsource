<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	%>
	<ul>		
		<li>id : <%=id %></li>
		<li>password : <%=password%></li>
		<li>name : <%=name%></li>
		<li>phone : <%=phone %></li>
	</ul>
</body>
</html>