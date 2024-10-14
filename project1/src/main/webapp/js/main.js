/**
 * 
 */
// 로그인 되었다면 전체회원조회 메뉴의 클래스명 disabled 제거
if(userId) {
	const menu1 = document.querySelector(".dropdown-menu li a");
	menu1.classList.remove("disabled");
}
