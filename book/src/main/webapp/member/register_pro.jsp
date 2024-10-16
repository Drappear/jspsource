<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	

	MemberDTO insertDto = new MemberDTO();
	MemberDAO dao = new MemberDAO();
	
	insertDto.setUserId(request.getParameter("userId"));
	insertDto.setName(request.getParameter("name"));
	insertDto.setPassword(request.getParameter("password"));
	
	int insertRow = dao.insert(insertDto);
	
	if(insertRow == 1) {
		response.sendRedirect("login.jsp");
	} else {
		response.sendRedirect("register.jsp");
	}
%>