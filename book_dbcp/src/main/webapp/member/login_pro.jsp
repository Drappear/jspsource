<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	MemberDAO dao = new MemberDAO();
	MemberDTO loginDto = new MemberDTO();
	loginDto.setUserId(request.getParameter("userId"));
	loginDto.setPassword(request.getParameter("password"));
	
	MemberDTO dto = dao.isLogin(loginDto);	
	
	if(dto != null) {
		session.setAttribute("loginDto", dto);
		response.sendRedirect("/book/list_pro.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>