<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/Mypage.css">
<link rel="stylesheet" href="./css/ress.css">
<jsp:include page="./title.jsp" />
</head>
<body>
<main>
<jsp:include page="./header.jsp" />
<h2 class="mi_1">マイページ</h2>

<div class = "root_1">

<div class="r1_item_1">
  <span>
    <img src="./img/kari.png" height="220" width="220" alt="User Icon">
  </span>
  </div>
<div class="r1_item_2">
    <p>ユーザID(Servlet)</p>
</div>
<div class="r1_item_3">
    <p>自己紹介(Servlet)</p>
</div>

</div>

<h2 class="mi_2">IBT作成一覧</h2>

<div class="box_1">
 <div class = "exam">
  <img src="./img/exam.png" height="70" width="70" alt="Create exam file">
  <p><a href = "#">example</a></p>
 </div>
</div>

<p class = "miru"><a href = "#">もっとみる</a></p>

<div class = "mi_root">

<div class = "book">
<h2>ブックマーク一覧</h2>
</div>
<div class = "repo">
<h2>レポート一覧</h2>
</div>

</div>

<div class = "box_root">
   <div class = "b_box">
   <p class = "b_exam"><a href = "#">・example1</a></p>
   <p class = "b_exam"><a href = "#">・example2</a></p>
   <p class = "b_exam"><a href = "#">・example3</a></p>
   <p class = "b_exam"><a href = "#">・example4</a></p>
   <p class = "b_exam"><a href = "#">・example5</a></p>
   </div>

   <div class = "r_box">
   <p>日付・試験名・成績(レポート)</p>
   </div>
</div>

<div class = "miru_br">

<div class = "miru_b"><p class = "miru"><a href = "#">もっとみる</a></p></div>
<div class = "miru_r"><p class = "miru"><a href = "#">もっとみる</a></p></div>

</div>

</main>
</body>
</html>