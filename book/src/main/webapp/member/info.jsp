<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<h3>Info</h3>
	<div class="row mb-3">
		<label for="userId" class="col-sm-2 col-form-label">ID</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userId" name="userId" >
		</div>
	</div>	
	<div class="row mb-3">
		<label for="name" class="col-sm-2 col-form-label">이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name" name="name" >
		</div>
	</div>
<form action="register_pro.jsp" method="post">
	<div class="row mb-3">
		<label for="password" class="col-sm-2 col-form-label">비밀번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="password" name="password">
		</div>
	</div>
 	<button type="submit" class="btn btn-secondary">회원가입</button>
	<button type="button" class="btn btn-primary">도서목록</button>
</form>
<script src="/js/register.js"></script>
<%@ include file="../include/footer.jsp" %>