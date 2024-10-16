// 추가 클릭(submit) 시
// description 요소를 제외한 모든 요소에 값이 있는지 확인
// code는 4자리 숫자인지
// price는 3~10자리 숫자인지
document.querySelector("body div:nth-child(3) form").addEventListener("submit", (e) => {

	e.preventDefault();
		
	const form = e.target;
	
	const code = form.querySelector("#code");
	const title = form.querySelector("#title");
	const writer = form.querySelector("#writer")
	const price = form.querySelector("#price");
	
	const codeReg = /^[0-9]{4}$/;	
	const priceReg = /^[0-9]{3,10}$/;
	const textReg= /^[A-Za-z가-힣0-9]+$/;
			
	if(!codeReg.test(code.value)){
		alert("코드를 확인하세요");	
		code.select();
		return;
	}else if(!priceReg.test(price.value)){
		alert("가격을 확인하세요");	
		price.select();
		return;
	}else if(!textReg.test(title.value)){
		alert("도서명을 확인하세요");	
		title.select();
		return;
	}else if(!textReg.test(writer.value)){
		alert("저자를 확인하세요");	
		writer.select();
		return;
	}	
	
	form.submit();
	
});

