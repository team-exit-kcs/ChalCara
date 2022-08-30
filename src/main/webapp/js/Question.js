function addQuestionForm(select){
	
	let questionNum = (Number(document.getElementById("QNum").value) + 1);
	let questionHtml = '<div><ul class = "B_question"><li><label for="s_toi">問' + questionNum + '.</label></li><li><textarea class="S_ques_area" required name="question" placeholder = "問題文を入力して下さい"></textarea><button type=\"button\" onclick=\"rmQuestionForm(this)\">−問を削除</button></li><li><textarea class="S_ques_area" name="questionExplanation" placeholder = "解説を入力して下さい(任意)"></textarea></li><li>配点：<input type = "number" required name = "Score" step="0.5" value = "2">点</li></ul>'+
					'<div><ul class = "B_question"><li class = "Select"><label><input type="radio" required name="Select_ans[小問][問' + questionNum + '.]" value=1><span>1．</span></label><input type="text" required class="Select_text" name="Select_text" /></li><li class = "Select"><label><input type="radio" required name="Select_ans[小問][問' + questionNum + '.]" value=2><span>2．</span></label><input type="text" required class="Select_text" name="Select_text" /></li><li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li></ul></div><input type="hidden" name="choicesNum" value="2"></div>';
	
	select.parentNode.insertAdjacentHTML("beforebegin",questionHtml);
	document.getElementById("QNum").setAttribute('value',questionNum);
}

function rmQuestionForm(rmQuestion){
	let questionCnt = Number(document.getElementById("QNum").value);
	let question=rmQuestion.parentNode.parentNode.parentNode.parentNode.firstElementChild;
	
	div = rmQuestion.parentNode.parentNode.parentNode;
	div.remove();
	
	question.firstElementChild.firstElementChild.textContent = "問1.";
	for(let i=2;i<questionCnt;i++){
		question=question.nextElementSibling;
		question.firstElementChild.firstElementChild.textContent = "問" + (i) + ".";
	}
	document.getElementById("QNum").setAttribute('value',questionCnt-1);
}