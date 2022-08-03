<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/ExamOverview.css">
<script src="./js/tag.js"></script>
<jsp:include page="./title.jsp" />
</head>
<body>
<main>

<div class = "main">

<form>
<h1 class = "mi_1">試験概要入力フォーム</h1>
   <div><label for = "e_Name">試験名：<input type = "text" placeholder = "examName"></label></div>
   <div><label for = "u_Name">制作者ID：<input type = "text" placeholder = "GETuserID"></label></div>

          <div>
               <label for = "genre" >ジャンル：
               <input type = "radio" name = "genre" value = "genre1">ジャンル１<%--getGenre --%>
               <input type = "radio" name = "genre" value = "genre2">ジャンル２<%--getGenre --%>
               <input type = "radio" name = "genre" value = "genre3">ジャンル３<%--getGenre --%>
               </label>
          </div>

          <div class = "tag">
               <label for = "tag">タグ：<input type = "text" name = "text[]" class = "text"></label>
               <button type="button" class="btn-clone">追加</button>
               <button type="button" class="btn-remove">削除</button>
          </div>
          
          <div>
               <label for = "OpenRange" >公開範囲：
               <input type = "radio" name = "genre" value = "genre1">公開
               <input type = "radio" name = "genre" value = "genre2">限定公開<%-- javascript --%>
               <input type = "radio" name = "genre" value = "genre3">非公開
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
          
</form>
</div>
</main>
</body>
</html>