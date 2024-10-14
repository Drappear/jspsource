/**
 * 
 */
// 회원 탈퇴 버튼 클릭시 form submit 중지
document.querySelector("form").addEventListener("submit", (e)=> {
	
	e.preventDefault();
	
// confirm 확인창(정말로 탈퇴하시겠습니까?)			
	if(confirm("정말로 탈퇴하시겠습니까?")) {
		e.target.submit();
	} else {
		
	}
});

