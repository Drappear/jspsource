<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<h3>Login</h3>

<form action="login_pro.jsp" method="post">
	<div class="row mb-3">
		<label for="userId" class="col-sm-2 col-form-label">ID</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userId" name="userId" >
		</div>
	</div>
	<div class="row mb-3">
		<label for="password" class="col-sm-2 col-form-label">비밀번호</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password" name="password">
		</div>
	</div>
	
 	<button type="submit" class="btn btn-secondary">로그인</button>
	<button type="button" class="btn btn-primary">도서목록</button>
</form>
<%@ include file="../include/footer.jsp" %>