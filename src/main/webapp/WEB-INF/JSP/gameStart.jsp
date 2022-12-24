<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ゲーム</title>
</head>
<body>
<jsp:include page="./header.jsp" />
<div class="container">
<div class="float-right">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#rule">ルール</button>
</div>
<div class = "container d-flex justify-content-center">
<div>
<form action="/ExamPlatform/SearchServlet" method="post">
<h2>問題選択</h2>
<div class="form-group">
<h4>ジャンル</h4>
<input type="checkbox" id="genreAllSelect" checked><label>すべて選択</label><br>
<c:forEach var="genre" items="${searchForm.genreList}">
	<input type="checkbox" name="GenreFilter" class="GenreFilter" value="${genre.genreID}" checked><label><c:out value="${genre.genreName}" /></label>
</c:forEach>
</div>

<div class="form-group">
<h4>タグ</h4>
<span><input type = "search" class="form-control" name = "tagFilter" list = "TagList"></span>

<button type="button" id = "add_drop" class = "border-0 btn-outline-primary" onclick="addForm(this,'tag')">＋追加</button>
</div>
<p>条件と一致する問題の中から20問出題されます。<br>ただし問題数が少ない場合20問よりも少なくなる場合もあります</p>
<hr>
<div class="form-group">
  <h2>難易度選択</h2>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="level" id="level1" value="0" checked required>
    <label class="form-check-label" for="level1">Normal</label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="level" id="level2" value="1">
    <label class="form-check-label" for="level2">Hard</label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="level" id="level3" value="2">
    <label class="form-check-label" for="level3">Expert</label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="level" id="level4" value="3">
    <label class="form-check-label" for="level4">Master</label>
  </div>
</div>
<input type="submit" class = "btn btn-outline-primary btn-block" value = "ゲーム開始" class = "ok" />
<c:if test="${not empty msg}"><p class="errorMsg"><c:out value="${msg}"/></p></c:if>
</form>
</div>
</div>
</div>
<!-- ルール -->
    <div class="modal fade" id="rule" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">ルール</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
          ここでは、問題を冒険しながら解くことができるぞ！<br>
          １．まず試験問題を選択し、その次に難易度を選択できるぞ。難易度に応じてスコアはどんどん加算されるぞ。隠し特典があるかも…<br>
          ２．スタートするといきなり戦闘開始！正解すれば攻撃か回復が選べるぞ。攻撃は相手を攻撃。回復はHPを回復できるぞ。間違えると攻撃を受ける。HPが０になるとゲームオーバー！間違えないように進んでいこう。<br>
          3. 問題が終了すると、リザルト画面に移る。ここでは自分の成績を確認できたり、間違えた問題をもう一度やり直すことも可能だ。何度も挑戦してハイスコアを目指せ！
          </div>
        </div>
      </div>
    </div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">

function addForm(btm,sw){
	let Html = '<span><br><input type = "search" id = "add_drop" class="form-control" name = "tagFilter" list = "TagList"><button type="button" class = "border-0 btn-outline-primary" onclick="rmForm(this)">-削除</button></span>';
	
	btm.insertAdjacentHTML("beforebegin",Html);
}

function rmForm(rm){
	span = rm.parentNode;
	span.remove();
}

let genreAllSelect = document.getElementById("genreAllSelect");
let GenreFilter = document.getElementsByClassName("GenreFilter");
const funcGenreAllSelect = (bool) => {
    for (let i = 0; i < GenreFilter.length; i++) {
    	GenreFilter[i].checked = bool;
    }
}
const funcCheck = () => {
    let count = 0;
    for (let i = 0; i < GenreFilter.length; i++) {
        if (GenreFilter[i].checked) {
            count += 1;
        }
    }
    if (GenreFilter.length === count) {
    	genreAllSelect.checked = true;
    } else {
    	genreAllSelect.checked = false;
    }
};
genreAllSelect.addEventListener("click",() => {
	funcGenreAllSelect(genreAllSelect.checked);
},false);
for (let i = 0; i < GenreFilter.length; i++) {
	GenreFilter[i].addEventListener("click", funcCheck, false);
}
</script>
</body>
</html>