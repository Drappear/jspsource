<%@page import="dao.BookDAO"%>
<%@page import="dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	BookDTO dto = new BookDTO();
	
	// PK
	dto.setCode(Integer.parseInt(request.getParameter("code")));
	// 수정할 컬럼
	dto.setPrice(Integer.parseInt(request.getParameter("price")));
	dto.setDescription(request.getParameter("description"));
	
	// DB
	BookDAO dao = new BookDAO();
	
	// 결과값
	int updateRow = dao.update(dto);
	
	// 페이지 이동
	if(updateRow == 0) {
		response.sendRedirect("modify_pro.jsp?code="+dto.getCode());
	} else {
		response.sendRedirect("list_pro.jsp");
	}
%>