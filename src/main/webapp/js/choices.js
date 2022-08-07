function addChoicesForm(select){
	var i = 100;
	let choicesHtml = '<li class = "Select"><label><input type="radio" name="Select_Symbol" value="'+i+'">'+i+'．</label><input type="text" class="Select_text" name="Select_text" /><button type="button" onclick="rmChoicesForm(this)">−選択肢を削除</button></li>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",choicesHtml);
}

function rmChoicesForm(rmChoices){
	li = rmChoices.parentNode;
	li.remove();
}