function addBigQuestionForm(select){
	let bigQuestionNum = select.parentNode.parentNode.childElementCount;
	let bigQuestionHtml = '<div class = "Bigquestion"><ul class = "B_question"><li><label for="b_toi">問'+ bigQuestionNum+'.</label><textarea id="B_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea><button type="button" onclick="rmBigQuestionForm(this)">−大問を削除</button></li></ul><div><div><ul class = "B_question"><li><label for="s_toi">＜設問1＞</label><textarea class="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea><button type=\"button\" onclick=\"rmQuestionForm(this)\">−問を削除</button></li></ul><div><ul class = "B_question"><li class = "Select"><label><input type="radio" name="Select_Symbol" value=1><span>1．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li class = "Select"><label><input type="radio" name="Select_Symbol" value=2><span>2．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li></ul></div></div><span><br><button type="button" onclick="addQuestionForm(this)">＋設問を追加</button></span></div></div>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",bigQuestionHtml);
}

function rmBigQuestionForm(rmBigQuestion){
	let bigQuesitonCnt = rmBigQuestion.parentNode.parentNode.parentNode.parentNode.childElementCount-1;
	let bigQuestion=rmBigQuestion.parentNode.parentNode.parentNode.parentNode.firstElementChild;
	
	div = rmBigQuestion.parentNode.parentNode.parentNode;
	div.remove();
	
	bigQuestion.firstElementChild.firstElementChild.firstElementChild.textContent = "問1.";
	for(let i=2;i<bigQuesitonCnt;i++){
		bigQuestion=bigQuestion.nextElementSibling;
		bigQuestion.firstElementChild.firstElementChild.firstElementChild.textContent = "問" + (i) + ".";
	}
}



function addQuestionForm(select){
	let questionNum = select.parentNode.parentNode.childElementCount;
	let questionHtml = '<div><ul class = "B_question"><li><label for="s_toi">＜設問' + questionNum + '＞</label><textarea class="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea><button type=\"button\" onclick=\"rmQuestionForm(this)\">−問を削除</button></li></ul>'+  
					'<div><ul class = "B_question"><li class = "Select"><label><input type="radio" name="Select_Symbol" value=1><span>1．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li class = "Select"><label><input type="radio" name="Select_Symbol" value=2><span>2．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li></ul></div></div>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",questionHtml);
}

function rmQuestionForm(rmQuestion){
	let quesitonCnt = rmQuestion.parentNode.parentNode.parentNode.parentNode.childElementCount-1;
	let question=rmQuestion.parentNode.parentNode.parentNode.parentNode.firstElementChild;
	
	div = rmQuestion.parentNode.parentNode.parentNode;
	div.remove();
	
	question.firstElementChild.firstElementChild.firstElementChild.textContent = "＜設問1＞";
	for(let i=2;i<quesitonCnt;i++){
		question=question.nextElementSibling;
		question.firstElementChild.firstElementChild.firstElementChild.textContent = "＜設問" + (i) + "＞";
	}
}