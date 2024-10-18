<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int code = Integer.parseInt(request.getParameter("code"));
	
	BookDAO dao = new BookDAO();
		
	int deleteRow = dao.delete(code);
	
	if(deleteRow == 0) {
		response.sendRedirect("modify_pro.jsp?code="+code);
	} else {
		response.sendRedirect("list_pro.jsp");
	}
%>