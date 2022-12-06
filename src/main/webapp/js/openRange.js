function LimitedPassForm(){
	let limited = document.getElementById("radio-limited");
	if(limited.checked && document.getElementById("limitedPassForm") == null){
		let limitedPassHtml = '<span><br>限定公開パスワード： <input type = "password" name = "limitedPASS" class = "text" id = "limitedPassForm"><span>';
		limited.parentNode.insertAdjacentHTML("beforeend",limitedPassHtml);
		let limitedUpdatePass = '<p id = pass_reset"><a href ="#">PASS設定</a></p>';
        limited.parentNode.insertAdjacentHTML("beforeend",limitedUpdatePass);
        			
	}else if(!limited.checked && document.getElementById("limitedPassForm") != null){
		span = document.getElementById("limitedPassForm").parentNode;
		span.remove();
		p = document.getElementById("limitedPassForm").parentNode;
        p.remove("pass_reset");
	}
}