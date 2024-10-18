<%@page import="dao.MemberDAO"%>
<%@page import="dto.ChangeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	
	
	ChangeDTO chgDto = new ChangeDTO();
	chgDto.setUserId(request.getParameter("userId"));
	chgDto.setCurrentPassword(request.getParameter("current_password"));
	chgDto.setChangePassword(request.getParameter("change_password"));
	
	MemberDAO dao = new MemberDAO();
	
	int updateRow = dao.update(chgDto);
	
	if(updateRow == 1) {
		session.invalidate();
		response.sendRedirect("login.jsp");
	} else {
		response.sendRedirect("info.jsp");
	}
%>