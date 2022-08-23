function addChoicesForm(select){
	let inputCNum = select.parentNode.parentNode.parentNode.parentNode.lastElementChild;
	let choicesCnt = (Number(inputCNum.value) + 1);
	let choicesHtml = '<li class = "Select"><label><input type="radio" name="Select_Symbol" value="'+choicesCnt+'"><span>'+choicesCnt+'．</span></label><input type="text" class="Select_text" name="Select_text"/><button type="button" onclick="rmChoicesForm(this)" class = "Delete">−選択肢を削除</button></li>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",choicesHtml);
	inputCNum.setAttribute('value',choicesCnt);
}

function rmChoicesForm(rmChoices){
	let inputCNum = rmChoices.parentNode.parentNode.parentNode.parentNode.lastElementChild;
	let choicesCnt = Number(inputCNum.value);
	let Choices=rmChoices.parentNode;
	for(let i=Number(Choices.firstElementChild.firstElementChild.value);i<choicesCnt;i++){
		Choices=Choices.nextElementSibling;
		Choices.firstElementChild.firstElementChild.setAttribute('value',i);
		Choices.firstElementChild.lastElementChild.textContent = (i)+"．";
	}
	li = rmChoices.parentNode;
	li.remove();
	inputCNum.setAttribute('value',choicesCnt-1);
}