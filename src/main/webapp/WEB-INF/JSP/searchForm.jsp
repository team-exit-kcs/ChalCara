<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<div  class = "container">
<div  id = "main_box" class = "d-flex justify-content-center row">
<form action="/ExamPlatform/SearchServlet" method="post">
<br>
<div class= "row">
<div class=" col-auto">
<select required id="searchFormat" class="form-control" name="searchFormat" onchange="formChange()">
<option value="1" <c:if test="${searchResult.searchFormat == 1}">selected</c:if>>試験検索</option>
<option value="2" <c:if test="${searchResult.searchFormat == 2}">selected</c:if>>試験ID検索</option>
<option value="3" <c:if test="${searchResult.searchFormat == 3}">selected</c:if>>ユーザID検索</option>
<option value="4" <c:if test="${searchResult.searchFormat == 4}">selected</c:if>>タグ検索</option>
<option value="5" <c:if test="${searchResult.searchFormat == 5}">selected</c:if>>ジャンル検索</option>
</select>
</div>
<div class="col-auto">
<span id="search1"><input type = "search" class="form-control" name = "searchWord" placeholder = "検索" <c:if test="${searchResult.searchFormat <= 3 && not empty searchResult.searchWord}">value="<c:out value="${searchResult.searchWord}"/>"</c:if> /></span>
</div>

<datalist id="TagList">
      <c:forEach var="tag" items="${searchForm.tagList}">
            <option><c:out value="${tag}" /></option>
      </c:forEach>
</datalist>
<span id="search2"><input type = "search" class="form-control" name = "searchTag" placeholder = "検索" list = "TagList" <c:if test="${searchResult.searchFormat == 4 && not empty searchResult.searchWord}">value="<c:out value="${searchResult.searchWord}"/>"</c:if> /></span>


<span id="search3">
<select name="searchGenre" class="form-control">
<c:forEach var="genre" items="${searchForm.genreList}">
	<option value="${genre.genreID}" <c:if test="${searchResult.searchFormat == 5 && searchResult.searchWord == genre.genreID}">selected</c:if>><c:out value="${genre.genreName}" /></option>
</c:forEach>
</select>
</span>
<div class = "col-auto">
<input type="submit" class="btn btn-outline-primary btn-block col-auto" value = "検索" class = "ok" />
</div>
</div>
<hr>
<details>
<summary id = "open">その他条件を指定する</summary>
<br>
<div class="details-content">
<div class="form-group">
<label>ジャンル</label>
<input type="checkbox" id="genreAllSelect" <c:if test="${empty searchFilter.genreIDFilterList}">checked</c:if>><label>すべて選択</label><br>
<c:forEach var="genre" items="${searchForm.genreList}">
	<input type="checkbox" name="GenreFilter" class="GenreFilter" value="${genre.genreID}" <c:if test="${empty searchFilter.genreIDFilterList || searchFilter.genreIDFilterList.contains(genre.genreID)}">checked</c:if>><label><c:out value="${genre.genreName}" /></label>
</c:forEach>
</div>

<div class="form-group">
<label>タグ　</label>
<c:choose>
<c:when test="${empty searchFilter.tagFilterList}"><span><input type = "search" class="form-control" name = "tagFilter" list = "TagList"></span></c:when>
<c:otherwise>
<c:forEach var="eTag" items="${searchFilter.tagFilterList}" varStatus="sts">
<c:choose>
<c:when test="${sts.first}"><span><input type = "search" class="form-control" name = "tagFilter" list = "TagList" value = <c:out value="${eTag}" />></span></c:when>
<c:otherwise><span><br><input type = "search" id = "add_drop" class="form-control" name = "tagFilter" list = "TagList" value = <c:out value="${eTag}" />><button type="button" onclick="rmForm(this)">-削除</button></span></c:otherwise>
</c:choose>
</c:forEach>
</c:otherwise>
</c:choose>

<button type="button" id = "add_drop" class = "border-0 btn-outline-primary" onclick="addForm(this,'tag')">＋追加</button>
</div>

<div class="form-group">
<label>ユーザ</label>
<c:choose>
<c:when test="${empty searchFilter.userIDFilterList}"><span><input type = "search" class="form-control" name = "userIDFilter"></span></c:when>
<c:otherwise>
<c:forEach var="userID" items="${searchFilter.userIDFilterList}" varStatus="sts">
<c:choose>
<c:when test="${sts.first}"><span><input type = "search" class="form-control" name = "userIDFilter" value = <c:out value="${userID}" />></span></c:when>
<c:otherwise><span><br><input type = "search" class="" name = "userIDFilter" value = <c:out value="${userID}" />><button type="button" onclick="rmForm(this)">-削除</button></span></c:otherwise>
</c:choose>
</c:forEach>
</c:otherwise>
</c:choose>
<button type="button" id = "add_drop" class = "border-0 btn-outline-primary" onclick="addForm(this,'userID')">＋追加</button>
</div>

<div class="form-group">
<label>問題形式</label>
<input type="radio" name="examFormatFilter" value="-1" <c:if test="${empty searchFilter.examFormatFilter || searchFilter.examFormatFilter == -1}">checked</c:if>>指定なし
<input type="radio" name="examFormatFilter" value="0" <c:if test="${searchFilter.examFormatFilter == 0}">checked</c:if>>大問形式
<input type="radio" name="examFormatFilter" value="1" <c:if test="${searchFilter.examFormatFilter == 1}">checked</c:if>>小問形式
</div>

<input type="submit" class = "btn btn-outline-primary btn-block" value = "絞り込む" class = "ok" />
<br>
</div>
</details>


<script type="text/javascript">
formChange();

function formChange(){
    if(document.getElementById('searchFormat')){
        id = document.getElementById('searchFormat').value;
        if(id <= 3){
            document.getElementById('search1').style.display = "";
            document.getElementById('search2').style.display = "none";
            document.getElementById('search3').style.display = "none";
        }else if(id == 4){
            document.getElementById('search1').style.display = "none";
            document.getElementById('search2').style.display = "";
            document.getElementById('search3').style.display = "none";
        }
        else if(id == 5){
            document.getElementById('search1').style.display = "none";
            document.getElementById('search2').style.display = "none";
            document.getElementById('search3').style.display = "";
        }
    }
window.onload = formChange;
}


function addForm(btm,sw){
	let Html;
	if(sw == "tag"){
		Html = '<span><br><input type = "search" id = "add_drop" class="form-control" name = "tagFilter" list = "TagList"><button type="button" class = "border-0 btn-outline-primary" onclick="rmForm(this)">-削除</button></span>';
	}else{
		Html = '<span><br><input type = "search" id = "add_drop" class="form-control" name = "userIDFilter"><button type="button" class = "border-0 btn-outline-primary" onclick="rmForm(this)">-削除</button></span>';
	}
	let tagForm = document.getElementById("tagForm");
	
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
<%-- 
<table>

<tr>
<th>ジャンル</th>
<td>
<input type="checkbox" id="genreAllSelect" <c:if test="${empty searchFilter.genreIDFilterList}">checked</c:if>><label>すべて選択</label><br>
<c:forEach var="genre" items="${searchForm.genreList}">
	<input type="checkbox" name="GenreFilter" class="GenreFilter" value="${genre.genreID}" <c:if test="${empty searchFilter.genreIDFilterList || searchFilter.genreIDFilterList.contains(genre.genreID)}">checked</c:if>><label><c:out value="${genre.genreName}" /></label>
</c:forEach>
</td>
</tr>

<tr>
<th>タグ</th>
<td>
<c:choose>
<c:when test="${empty searchFilter.tagFilterList}"><span><input type = "search" name = "tagFilter" list = "TagList"></span></c:when>
<c:otherwise>
<c:forEach var="eTag" items="${searchFilter.tagFilterList}" varStatus="sts">
<c:choose>
<c:when test="${sts.first}"><span><input type = "search" name = "tagFilter" list = "TagList" value = <c:out value="${eTag}" />></span></c:when>
<c:otherwise><span><br><input type = "search" name = "tagFilter" list = "TagList" value = <c:out value="${eTag}" />><button type="button" onclick="rmForm(this)">-削除</button></span></c:otherwise>
</c:choose>
</c:forEach>
</c:otherwise>
</c:choose>

<button type="button" onclick="addForm(this,'tag')">＋追加</button>
</td>
</tr>

<tr>
<th>ユーザ</th>
<td>
<c:choose>
<c:when test="${empty searchFilter.userIDFilterList}"><span><input type = "search" name = "userIDFilter"></span></c:when>
<c:otherwise>
<c:forEach var="userID" items="${searchFilter.userIDFilterList}" varStatus="sts">
<c:choose>
<c:when test="${sts.first}"><span><input type = "search" name = "userIDFilter" value = <c:out value="${userID}" />></span></c:when>
<c:otherwise><span><br><input type = "search" name = "userIDFilter" value = <c:out value="${userID}" />><button type="button" onclick="rmForm(this)">-削除</button></span></c:otherwise>
</c:choose>
</c:forEach>
</c:otherwise>
</c:choose>

<button type="button" onclick="addForm(this,'userID')">＋追加</button>
</td>
</tr>

<tr>
<th>問題形式</th>
<td>
<input type="radio" name="examFormatFilter" value="-1" <c:if test="${empty searchFilter.examFormatFilter || searchFilter.examFormatFilter == -1}">checked</c:if>>指定なし
<input type="radio" name="examFormatFilter" value="0" <c:if test="${searchFilter.examFormatFilter == 0}">checked</c:if>>大問形式
<input type="radio" name="examFormatFilter" value="1" <c:if test="${searchFilter.examFormatFilter == 1}">checked</c:if>>小問形式
</td>
</tr>

</table>
<input type="submit" value = "絞り込む" class = "ok" />

</details>


<script type="text/javascript">
formChange();

function formChange(){
    if(document.getElementById('searchFormat')){
        id = document.getElementById('searchFormat').value;
        if(id <= 3){
            document.getElementById('search1').style.display = "";
            document.getElementById('search2').style.display = "none";
            document.getElementById('search3').style.display = "none";
        }else if(id == 4){
            document.getElementById('search1').style.display = "none";
            document.getElementById('search2').style.display = "";
            document.getElementById('search3').style.display = "none";
        }
        else if(id == 5){
            document.getElementById('search1').style.display = "none";
            document.getElementById('search2').style.display = "none";
            document.getElementById('search3').style.display = "";
        }
    }
window.onload = formChange;
}


function addForm(btm,sw){
	let Html;
	if(sw == "tag"){
		Html = '<span><br><input type = "search" name = "tagFilter" list = "TagList"><button type="button" onclick="rmForm(this)">-削除</button></span>';
	}else{
		Html = '<span><br><input type = "search" name = "userIDFilter"><button type="button" onclick="rmForm(this)">-削除</button></span>';
	}
	let tagForm = document.getElementById("tagForm");
	
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
--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</form>
</div>
</div>