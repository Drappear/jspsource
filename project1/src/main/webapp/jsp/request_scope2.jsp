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
	/* request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");	 */
	
	// session에 저장한 값 불러오기
	String name = (String)session.getAttribute("name");
%>
<h3><%= name %></h3>
<h4><a href="">이동하기</a></h4>
</body>
</html>