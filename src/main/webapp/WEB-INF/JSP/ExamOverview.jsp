<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.Genre" %>
<%@ page import = "java.util.List" %>
    
     <% 
     	ExamCreatePage pageData = (ExamCreatePage) request.getAttribute("ExamCreatePage");
        List<Genre> genreList = pageData.getGenreList();
        List<String> tagList = pageData.getTagList();
      %>
    
    
    
    
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/ExamOverview.css">
<jsp:include page="./title.jsp" />
</head>
<body>
<main>

<div class = "main">

<form>
<h1 class = "mi_1">試験概要入力フォーム</h1>
   <div><label for = "e_Name">試験名：<input type = "text" placeholder = "examName"></label></div>

          <div>
               <label for = "genre" >ジャンル：
               <% for(Genre genre : genreList){ %>
               		<input type = "radio" name = "genre" value = <%= genre.getGenreID() %>><%= genre.getGenreName() %> <%--getGenre --%>
               <% } %>
               </label>
          </div>
          
          <datalist id="TagList">
			<% for(String tag : tagList){ %>
               		<option value=<%= tag %> ></option>
          <% } %>
          </datalist>
          <div class = "tag">
               <label for = "tag" id = "tagForm">タグ：
               		<span><input type = "text" name = "text[]" class = "text" list = "TagList"></span>
               </label>
               <br><button type="button" id="btn-addTagForm">＋追加</button>
          </div>
          
          <div>
               <label for = "OpenRange" >公開範囲：
               <input type = "radio" name = "OpenRange" value = "0">公開
               <input type = "radio" name = "OpenRange" value = "1">限定公開<%-- javascript --%>
               <input type = "radio" name = "OpenRange" value = "2">非公開
               </label>
          </div>
          
          <div>
               <label for = "Explanation">説明文：</label>
               <textarea name = "text_1" placeholder = "試験概要を説明して下さい"></textarea>
          </div>
          
          <div class = "footer">
          
          <div class = "botton_area">
          <input type="submit" value = "戻る" class = "back"></input>
          <input type="submit" value = "ＯＫ" class = "ok"></input>
          </div>
          
          </div>
          <script src="./js/tag.js"></script>
</form>
</div>
</main>
</body>
</html>