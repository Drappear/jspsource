<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login</h1>
<form action="/login.do" method="post">
	<div>
		<label for="userId">ID</label>
		<input type="text" name="userId" id="userId" />
	</div>
	<div>
		<button>로그인</button>
	</div>
</form>
</body>
</html>