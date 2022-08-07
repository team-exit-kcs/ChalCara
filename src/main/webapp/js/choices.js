function addChoicesForm(select){
	let choicesCnt = select.parentNode.parentNode.childElementCount-1;
	let choicesHtml = '<li class = "Select"><label><input type="radio" name="Select_Symbol" value="'+choicesCnt+'">'+(choicesCnt+1)+'．</label><input type="text" class="Select_text" name="Select_text" /><button type="button" onclick="rmChoicesForm(this)">−選択肢を削除</button></li>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",choicesHtml);
}

function rmChoicesForm(rmChoices){
	let choicesCnt = rmChoices.parentNode.parentNode.childElementCount-1;
	let Choices=rmChoices.parentNode;
	li = rmChoices.parentNode;
	li.remove();
	for(let i=Choices.firstElementChild.firstElementChild.value;i<choicesCnt;i++){
		Choices=Choices.nextElementSibling;
		Choices.firstElementChild.firstElementChild.setAttribute('value',i);;
		Choices.firstElementChild.innerText=(i+1)+"．";
	}
}