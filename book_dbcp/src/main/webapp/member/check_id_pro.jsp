<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	System.out.println(userId);
	
	MemberDAO dao = new MemberDAO();
	boolean dupId = dao.dupId(userId);
	
	if(dupId) {
		out.print("true");
	}else {
		out.print("false");
	}
%>