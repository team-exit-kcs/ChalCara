<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<form action="/ExamPlatform/SearchServlet" method="post">
<select required id="searchFormat" name="searchFormat" onchange="formChange()">
<option value="1" <c:if test="${searchResult.searchFormat == 1}">selected</c:if>>試験検索</option>
<option value="2" <c:if test="${searchResult.searchFormat == 2}">selected</c:if>>試験ID検索</option>
<option value="3" <c:if test="${searchResult.searchFormat == 3}">selected</c:if>>ユーザID検索</option>
<option value="4" <c:if test="${searchResult.searchFormat == 4}">selected</c:if>>タグ検索</option>
<option value="5" <c:if test="${searchResult.searchFormat == 5}">selected</c:if>>ジャンル検索</option>
</select>

<span id="search1"><input type = "search" name = "searchWord" placeholder = "検索" <c:if test="${searchResult.searchFormat <= 3 && not empty searchResult.searchWord}">value="<c:out value="${searchResult.searchWord}"/>"</c:if> /></span>


<datalist id="TagList">
      <c:forEach var="tag" items="${searchForm.tagList}">
            <option><c:out value="${tag}" /></option>
      </c:forEach>
</datalist>
<span id="search2"><input type = "search" name = "searchTag" placeholder = "検索" list = "TagList" <c:if test="${searchResult.searchFormat == 4 && not empty searchResult.searchWord}">value="<c:out value="${searchResult.searchWord}"/>"</c:if> /></span>


<span id="search3">
<select name="searchGenre">
<c:forEach var="genre" items="${searchForm.genreList}">
	<option value="${genre.genreID}" <c:if test="${searchResult.searchFormat == 5 && searchResult.searchWord == genre.genreID}">selected</c:if>><c:out value="${genre.genreName}" /></option>
</c:forEach>
</select>
</span>

<input type="submit" value = "検索" class = "ok" />
<hr>
<details>
<summary>その他条件を指定する</summary>
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
</form>