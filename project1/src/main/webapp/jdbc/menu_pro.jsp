<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<% 
	MemberDAO dao = new MemberDAO();
	List<MemberDTO> list = dao.read();
%>
<table class="table mt-4">
  <thead>
    <tr>
      <th scope="col">userId</th>
      <th scope="col">name</th>
      <th scope="col">age</th>
      <th scope="col">email</th>
    </tr>
  </thead>
  <tbody>
  <% for(MemberDTO dto:list) { %>
    <tr>
      <td><%=dto.getUserId() %></td>
      <td><%=dto.getName() %></td>
      <td><%=dto.getAge() %></td>
      <td><%=dto.getEmail() %></td>
    </tr> 
    <%} %>   
  </tbody>
</table>
<script>
	const userId = <%=loginDto.getUserId() %>
</script>
<%@ include file="footer.jsp" %>