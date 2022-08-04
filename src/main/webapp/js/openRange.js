function LimitedPassForm(){
	let limited = document.getElementById("radio-limited");
	if(limited.checked && document.getElementById("limitedPassForm") == null){
		let limitedPassHtml = '<span><br>限定公開パスワード： <input type = "password" name = "limitedPASS" class = "text" id = "limitedPassForm"><span>';
		limited.parentNode.insertAdjacentHTML("beforeend",limitedPassHtml);
		
	}else if(!limited.checked && document.getElementById("limitedPassForm") != null){
		span = document.getElementById("limitedPassForm").parentNode;
		span.remove();
	}
}

