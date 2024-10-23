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
});

// 검색기능
// criteria or keyword 입력이 안된 경우 form submit 중지
// 메세지
const searchForm = document.querySelector("#searchForm");

searchForm.addEventListener("submit", (e) => {
	e.preventDefault();
	if(document.getElementById("criteria").value === "n") {
		alert("검색 조건을 확인하세요");
		return;
	} else if(document.getElementById("keyword").value === "") {
		alert("검색어를 입력해주세요");
		return;
	} else {
		searchForm.submit();
	}
});


// 페이지 나누기
// 숫자 누를때 actionForm submit
// 
document.querySelector(".pagination").addEventListener("click", (e) => {
	e.preventDefault();
		
	actionForm.querySelector("[name='bno']").remove();
	actionForm.querySelector("[name='page']").value = e.target.getAttribute("href");
	
	actionForm.submit();
});

