function addQuestionForm(select){
	let questionCnt = select.parentNode.childElementCount;
	let questionHtml = '<jsp:include page="./QuestionForm.jsp"><jsp:param name="bigQuestionNum" value = "<%= questionFormat==0 ? bigQuestionNum : "" %>" /><jsp:param name="questionNum" value = "' + questionCnt + '" /></jsp:include>';
	
	select.insertAdjacentHTML("beforebegin",questionHtml);
}

function rmQuestionForm(rmQuestion){
	let choicesCnt = rmQuestion.parentNode.parentNode.childElementCount-1;
	let Choices=rmQuestion.parentNode;
	for(let i=Number(Choices.firstElementChild.firstElementChild.value);i<choicesCnt;i++){
		Choices=Choices.nextElementSibling;
		Choices.firstElementChild.firstElementChild.setAttribute('value',i);;
		Choices.firstElementChild.lastElementChild.textContent = (i)+"．";
	}
	div = rmQuestion.parentNode.parentNode.parentNode;
	div.remove();
}