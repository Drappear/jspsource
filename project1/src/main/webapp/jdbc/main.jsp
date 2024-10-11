<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<% MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto"); %>
<h3 class="mt-3">Main</h3>
<% if(loginDto != null) { %>
<div>
<%-- 로그인 한 경우 --%>
<%=loginDto.getName() %> 님 반갑습니다.
<a href="session_remove.jsp" class="btn btn-primary">로그아웃</a>
<a href="" class="btn btn-success">비밀번호 수정</a>
<a href="" class="btn btn-danger">탈퇴</a>
</div>
<%} %>
<table class="table mt-4">
  <thead>
    <tr>
      <th scope="col">userid</th>
      <th scope="col">name</th>
      <th scope="col">age</th>
      <th scope="col">email</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
<%@ include file="footer.jsp" %>