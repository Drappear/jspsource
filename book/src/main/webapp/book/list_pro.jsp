<%@page import="java.util.List"%>
<%@page import="dto.BookDTO"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BookDAO dao = new BookDAO();
	List<BookDTO> list = dao.getList();

	// 페이지 이동 방식
	// sendRedirect, forward
	
	// 어떤 특정 값(객체)을 다른 페이지(jsp, servlet)들과 공유
	// 1. session : 페이지 이동 방식에 제한 조건 없음(대부분 sendRedirect)
	// session.setAttribute("list", list);
	
	// 2. request : 페이지 이동 방식 제한됨(forward)
	//				사용할 수 있는 페이지도 제한됨
	request.setAttribute("list", list);
	
	pageContext.forward("list.jsp");
%>