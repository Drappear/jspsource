document.querySelector(".btn-success").addEventListener("click", () => {
	
	// 아이디
	const userId = document.querySelector("#userId").value;
	
	const form = new FormData();
	form.append("userId", userId);
	
	fetch(`/member/check_id_pro.jsp?`, {
		method:"post",		
		body:new URLSearchParams(form)
	})
	.then(response => {
		if(!response.ok) throw new Error("주소를 확인해주세요");
		return response.text();
	})
	.then(data => {
		console.log(data);
		if(data.trim() == "true"){
			alert("아이디 사용 가능");
		}else {
			alert("아이디 사용 불가");
		}
	})
	.catch(error => console.log(error));
});