<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
// register.jsp에서 사용자가 입력한 회원정보 가져오기
String userId = request.getParameter("userId");
String name = request.getParameter("name");
String password = request.getParameter("password");
int age = Integer.parseInt(request.getParameter("age"));
String email = request.getParameter("email");

MemberDTO insertDto = new MemberDTO(userId, name, password, age, email);

	// dao create() 호출
	MemberDAO dao = new MemberDAO();
//	int result = dao.create(id, name, password, age, email);
	int result = dao.create(insertDto);	

	// 다른 곳(login)으로 이동
	if(result > 0) {
	response.sendRedirect("login.jsp");
	} else {
		response.sendRedirect("register.jsp");
	}
%>