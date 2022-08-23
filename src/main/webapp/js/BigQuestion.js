function addBigQuestionForm(select){
	let bigQuestionNum = (Number(document.getElementById("BQNum").value) + 1);
	let bigQuestionHtml = '<div class = "Bigquestion"><ul class = "B_question"><li><label for="b_toi">問'+ bigQuestionNum+'.</label></li><li><textarea id="B_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea><button type="button" onclick="rmBigQuestionForm(this)">−大問を削除</button></li></ul><div><div><ul class = "B_question"><li><label for="s_toi">＜設問1＞</label></li><li><textarea class="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea><button type=\"button\" onclick=\"rmQuestionForm(this)\">−問を削除</button></li><li><textarea class="S_ques_area" name="questionExplanation" placeholder = "解説を入力して下さい(任意)"></textarea></li><li>配点：<input type = "number" name = "Score"  value = "2">点</li></ul><div><ul class = "B_question"><li class = "Select"><label><input type="radio" name="Select_Symbol" value=1><span>1．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li class = "Select"><label><input type="radio" name="Select_Symbol" value=2><span>2．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li></ul></div><input type="hidden" name="choicesNum" value="2"></div><span><br><button type="button" onclick="addQuestionForm(this)">＋設問を追加</button></span></div><input type="hidden" name="questionNum" value="1"></div>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",bigQuestionHtml);
	document.getElementById("BQNum").setAttribute('value',bigQuestionNum);
}

function rmBigQuestionForm(rmBigQuestion){
	let bigQuesitonCnt = Number(document.getElementById("BQNum").value);
	let bigQuestion=rmBigQuestion.parentNode.parentNode.parentNode.parentNode.firstElementChild;
	
	div = rmBigQuestion.parentNode.parentNode.parentNode;
	div.remove();
	
	bigQuestion.firstElementChild.firstElementChild.textContent = "問1.";
	for(let i=2;i<bigQuesitonCnt;i++){
		bigQuestion=bigQuestion.nextElementSibling;
		bigQuestion.firstElementChild.firstElementChild.textContent = "問" + (i) + ".";
	}
	document.getElementById("BQNum").setAttribute('value',(bigQuesitonCnt-1));
}



function addQuestionForm(select){
	let inputQNum = select.parentNode.parentNode.parentNode.lastElementChild;
	let questionNum = (Number(inputQNum.value)+1);
	let questionHtml = '<div><ul class = "B_question"><li><label for="s_toi">＜設問' + questionNum + '＞</label></li><li><textarea class="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea><button type=\"button\" onclick=\"rmQuestionForm(this)\">−問を削除</button></li><li><textarea class="S_ques_area" name="questionExplanation" placeholder = "解説を入力して下さい(任意)"></textarea></li><li>配点：<input type = "number" name = "Score"  value = "2">点</li></ul>'+  
					'<div><ul class = "B_question"><li class = "Select"><label><input type="radio" name="Select_Symbol" value=1><span>1．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li class = "Select"><label><input type="radio" name="Select_Symbol" value=2><span>2．</span></label><input type="text" class="Select_text" name="Select_text" /></li><li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li></ul></div><input type="hidden" name="choicesNum" value="2"></div>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",questionHtml);
	inputQNum.setAttribute('value',questionNum);
}

function rmQuestionForm(rmQuestion){
	let inputQNum = rmQuestion.parentNode.parentNode.parentNode.parentNode.parentNode.lastElementChild;
	let questionNum = Number(inputQNum.value);
	let question=rmQuestion.parentNode.parentNode.parentNode.parentNode.firstElementChild;
	
	div = rmQuestion.parentNode.parentNode.parentNode;
	div.remove();
	
	question.firstElementChild.firstElementChild.textContent = "＜設問1＞";
	for(let i=2;i<questionNum;i++){
		question=question.nextElementSibling;
		question.firstElementChild.firstElementChild.textContent = "＜設問" + (i) + "＞";
	}
	inputQNum.setAttribute('value',questionNum-1);
}