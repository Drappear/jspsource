<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<h3>로그인</h3>
<form action="login_pro.jsp" method="post">
	<div class="mb-3">
		<label for="userId" class="form-label">ID</label> <input type="text"
			class="form-control" id="userId" aria-describedby="userId"
			name="userId" autofocus="autofocus">
	</div>
	
	<div class="mb-3">
		<label for="password" class="form-label">비밀번호</label> <input
			type="password" class="form-control" id="password" name="password">
	</div>
	
	<button type="submit" class="btn btn-primary">로그인</button>
</form>
<%@ include file="footer.jsp"%>