<%@page import="dao.BookDAO"%>
<%@page import="dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	BookDTO dto = new BookDTO();
	BookDAO dao = new BookDAO();
		
	dto.setCode(Integer.parseInt(request.getParameter("code")));
	dto.setTitle(request.getParameter("title"));
	dto.setWriter(request.getParameter("writer"));
	dto.setPrice(Integer.parseInt(request.getParameter("price")));
	dto.setDescription(request.getParameter("description"));
	
	int insertRow = dao.insert(dto); 
	if (insertRow == 1) {
		response.sendRedirect("list_pro.jsp");
	} else {
		response.sendRedirect("create.jsp");
	};
	
%>