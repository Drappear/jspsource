/*
const allA = document.querySelectorAll("#dataTable a");
allA.forEach("a", ()=> {
	a.addEventListener("click", (e) => {
		e.preventDefault();
	})
});
*/

const actionForm = document.querySelector("#actionForm");

document.querySelector("tbody").addEventListener("click", (e) => {
// 제목 클릭 시 a태그 기능 중지
	e.preventDefault();
// 이벤트 대상
/*
	console.log(e.target);
	console.log(e.target.href);
	console.log(e.target.getAttribute("href"));
*/
// href의 번호 가져온 후 actionForm의 bno value에 삽입
	const bno = e.target.getAttribute("href");
	actionForm.querySelector("[name='bno']").value = bno;
	
//	console.log(actionForm.innerHTML);

// actionForm submit
	actionForm.action ="/cntupdate.do";
	actionForm.submit();
})



