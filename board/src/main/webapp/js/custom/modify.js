const modifyForm = document.querySelector("#modifyForm");

modifyForm.addEventListener("submit", (e) => {
	e.preventDefault();
	
	const title = modifyForm.querySelector("#title");
	const content = modifyForm.querySelector("#content");
	const password = modifyForm.querySelector("#password");
	
	if(title.value === ""){
		alert("제목을 입력하세요");
		title.focus();
		return;
	} else if(content.value === ""){
		alert("내용을 입력하세요");
		content.focus();
		return;
	} else if(password.value === ""){
		alert("비밀번호를 입력하세요");
		password.focus();
		return;
	}
	
	modifyForm.submit();
})

document.querySelector("#modifyForm .btn-success").addEventListener("click", (e) => {
	e.preventDefault();	
	modifyForm.action ="/list.do";
	modifyForm.submit();
})

document.querySelector("#modifyForm .btn-danger").addEventListener("click", (e) => {
	e.preventDefault();
	modifyForm.action ="/delete.do";
	modifyForm.submit();
})


