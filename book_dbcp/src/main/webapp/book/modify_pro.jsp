<%@page import="dto.BookDTO"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 가져올 값(넘어오는 값)이 있는지 확인
	// 시작하는 페이지에서 form 존재
	// a태그 주소값 ? 다음에
			
	int code = Integer.parseInt(request.getParameter("code"));

	// DB 작업
	BookDAO dao = new BookDAO();
	BookDTO dto = dao.getRow(code);
	
	// 결과값 공유
	request.setAttribute("dto", dto);
	
	// 페이지 이동
	pageContext.forward("modify.jsp");
%>