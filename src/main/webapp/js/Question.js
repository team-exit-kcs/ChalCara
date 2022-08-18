function addQuestionForm(select){
	let questionNum = select.parentNode.parentNode.childElementCount;
	let questionHtml = '<div><ul class = "B_question"><li><label for="s_toi">問' + questionNum + '.</label><textarea class="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea><button type=\"button\" onclick=\"rmQuestionForm(this)\">−問を削除</button></li></ul>'+  
					'<div><ul class = "B_question"><li class = "Select"><label><input type="radio" name="Select_Symbol" value=1><span>1．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li class = "Select"><label><input type="radio" name="Select_Symbol" value=2><span>2．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li></ul></div></div>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",questionHtml);
}

function rmQuestionForm(rmQuestion){
	let quesitonCnt = rmQuestion.parentNode.parentNode.parentNode.parentNode.childElementCount-1;
	let question=rmQuestion.parentNode.parentNode.parentNode.parentNode.firstElementChild;
	
	div = rmQuestion.parentNode.parentNode.parentNode;
	div.remove();
	
	question.firstElementChild.firstElementChild.firstElementChild.textContent = "問1.";
	for(let i=2;i<quesitonCnt;i++){
		question=question.nextElementSibling;
		question.firstElementChild.firstElementChild.firstElementChild.textContent = "問" + (i) + ".";
	}
}