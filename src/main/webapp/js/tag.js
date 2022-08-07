function addTagForm(){
	let tagHtml = '<span><br><input type = "text" name = "text" class = "text" list = "TagList"><button type="button" class="btn-rmTagForm" onclick="rmTagForm(this)">-削除</button></span>';
	let tagForm = document.getElementById("tagForm");
	
	tagForm.insertAdjacentHTML("beforeend",tagHtml);
}

function rmTagForm(rmTag){
	span = rmTag.parentNode;
	span.remove();
}
