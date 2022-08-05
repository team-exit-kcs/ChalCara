function addChoicesForm(){
	let choicesHtml = '<span><br><input type = "text" name = "text" class = "text" list = "TagList"><button type="button" class="btn-rmTagForm" onclick="rmTagForm(this)">-削除</button><span>';
	let choicesForm = document.getElementById("choicesForm");
	
	choicesForm.insertAdjacentHTML("beforeend",choicesHtml);
}

function rmChoicesForm(rmChoices){
	span = rmChoices.parentNode;
	span.remove();
}