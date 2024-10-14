<%@page import="dao.MemberDAO"%>
<%@page import="dto.ChangeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// password.jsp에서 넘긴 값 ChangeDTO에 담기
	ChangeDTO chgDto = new ChangeDTO();
	chgDto.setUserId(request.getParameter("userId"));
	chgDto.setCurrentPassword(request.getParameter("current_password"));
	chgDto.setChangePassword(request.getParameter("change_password"));
	
	MemberDAO dao = new MemberDAO();
	int updateRow = dao.update(chgDto);
	
	if(updateRow == 1) {
		// updateRow == 1일 때 세션 종료 / login.jsp로 이동
		session.invalidate();
		response.sendRedirect("login.jsp");
	} else {
		// updateRow == 0 일 때 password.jsp로 이동
		response.sendRedirect("password.jsp");
	}
%>