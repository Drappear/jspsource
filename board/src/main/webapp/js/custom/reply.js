const actionForm = document.querySelector("#actionForm");

// 목록 클릭 시 actionForm action="/list.do" 수정 후 submit
document.querySelector("#replyForm .btn-success").addEventListener("click", () => {
	actionForm.action ="/list.do";
	actionForm.submit();
})