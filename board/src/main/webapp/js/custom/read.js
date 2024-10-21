const actionForm = document.querySelector("#actionForm");

document.querySelector("#readForm .btn-success").addEventListener("click", (e) => {
	e.preventDefault();
// actionFrom bno 요소 제거
	actionForm.querySelector("[name='bno']").remove();
// 목록 클릭 시 actionForm action="/list.do" 수정 후 submit
	actionForm.action ="/list.do";
	actionForm.submit();
})

document.querySelector("#readForm .btn-primary").addEventListener("click", (e) => {
	e.preventDefault();
// 수정 클릭시 actionForm action="/modify.do" 수정 후 submit
	actionForm.action ="/modify.do";
	actionForm.submit();
})

