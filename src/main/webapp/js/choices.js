function addChoicesForm(select){
	let bigQ = select.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
	console.log(bigQ)
	let thisbigQ = select.parentNode.parentNode.parentNode.parentNode.parentNode;
	let bigQNum = bigQ.indexOf(thisbigQ);
	let q = select.parentNode.parentNode.parentNode.parentNode.parentNode;
	let thisQ = select.parentNode.parentNode.parentNode.parentNode;
	let QNum = q.indexOf(thisQ);
	
	let inputCNum = select.parentNode.parentNode.parentNode.parentNode.lastElementChild;
	let choicesCnt = (Number(inputCNum.value) + 1);
	let choicesHtml = '<li class = "Select"><label><input type="radio" required name="Select_ans['+bigQNum+']['+QNum+']" value="'+choicesCnt+'"><span>'+choicesCnt+'．</span></label><input type="text" required class="Select_text" name="Select_text"/><button type="button" onclick="rmChoicesForm(this)" class = "Delete">−選択肢を削除</button></li>';
	
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