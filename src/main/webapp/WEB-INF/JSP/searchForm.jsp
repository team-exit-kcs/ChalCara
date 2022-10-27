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

<span id="search1"><input type = "text" name = "searchWord" placeholder = "検索" <c:if test="${searchResult.searchFormat <= 3 && not empty searchResult.searchWord}">value="<c:out value="${searchResult.searchWord}"/>"</c:if> /></span>


<datalist id="TagList">
      <c:forEach var="tag" items="${searchForm.tagList}">
            <option><c:out value="${tag}" /></option>
      </c:forEach>
</datalist>
<span id="search2"><input type = "text" name = "searchTag" placeholder = "検索" list = "TagList" <c:if test="${searchResult.searchFormat == 4 && not empty searchResult.searchWord}">value="<c:out value="${searchResult.searchWord}"/>"</c:if> /></span>


<span id="search3">
<select name="searchGenre">
<c:forEach var="genre" items="${searchForm.genreList}">
	<option value="${genre.genreID}" <c:if test="${searchResult.searchFormat == 5 && searchResult.searchWord == genre.genreID}">selected</c:if>><c:out value="${genre.genreName}" /></option>
</c:forEach>
</select>
</span>

<input type="submit" value = "検索" class = "ok" />
<script type="text/javascript">
formChange()

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
</script>
</form>