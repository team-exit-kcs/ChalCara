document.getElementById("btn-addTagForm").addEventListener("click", addTagForm, false);

function addTagForm(){
	let tagHtml = '<span><br><input type = "text" name = "text" class = "text" list = "TagList"><button type="button" class="btn-rmTagForm" onclick="rmTagForm(this)">-削除</button><span>';
	let tagForm = document.getElementById("tagForm");
	
	tagForm.insertAdjacentHTML("beforeend",tagHtml);
}

function rmTagForm(rmTag){
	span = rmTag.parentNode;
	span.remove();
}

/*
$(function() {

    // button
    var btn_clone = $('.btn-clone');  // 追加ボタン
    var btn_remove = $('.btn-remove');  // 削除ボタン

    // clone
    btn_clone.click(function() {

        var text = $('.text').last();  // 最後尾にあるinput

        text
          .clone()  // クローン
          .val('')  // valueもクローンされるので削除する
          .insertAfter(text);  // inputを最後尾に追加

        if ($('.text').length >= 2) {
            $(btn_remove).show();  // inputが2つ以上あるときに削除ボタンを表示
        }

    });

    // remove
    btn_remove.click(function() {

        $('.text').last().remove();

        if ($('.text').length < 2) {
            btn_remove.hide();  // inputが2つ未満のときに削除ボタンを非表示
        }

    });
});
*/