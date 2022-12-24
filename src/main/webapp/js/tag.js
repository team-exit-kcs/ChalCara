function addTagForm(){
	let tagHtml = '<span><br><input type = "text" name = "tag" class = "text form-control" list = "TagList"><button type="button" class="btn-rmTagForm add_drop border-0 btn-outline-primary" onclick="rmTagForm(this)">-削除</button></span>';
	let tagForm = document.getElementById("tagForm");
	
	tagForm.insertAdjacentHTML("beforeend",tagHtml);
}

function rmTagForm(rmTag){
	span = rmTag.parentNode;
	span.remove();
}
