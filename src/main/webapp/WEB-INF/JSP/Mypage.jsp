<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "model.Account" %>
<%@ page import = "model.Bookmark" %>
<%@ page import = "model.Report" %>
<%@ page import = "model.BaseExam" %>

     <%--
     Account model = (Account) session.getUserID("#");
     Account model = (Account) session.getProfile("#");
     Account model = (Account) session.getIcon("#");
     --%>
     
     <%--
     BaseExam be = (BaseExam) request.getExamName("#");
      --%>
      
     <%--
     Bookmark bm = (Bookmark) request.getUserID("#");
     Bookmark bm = (Bookmark) request.getExamIDList("#");
      --%>
      
     <%--
     Report rp = (Report) request.getReportID("#");
     Report rp = (Report) request.getExamDate("#");
      --%>


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
    <img src="./img/kari.png" <%-- =model. getIcon() --%> height="220" width="220" alt="User Icon">
  </span>
</div>
<div class="r1_item_2">
    <p><%-- =model. getUserID() --%>ユーザID</p>
</div>
<div class="r1_item_3">
    <p><%-- =model. getProfile() --%>自己紹介文</p>
</div>

</div>

<h2 class="mi_2">IBT作成一覧</h2>

<div class="box_1">

<% for ( int i = 0 ;i<5; i++) { %>
 <div class = "exam">
  <img src="./img/exam.png" height="70" width="70" alt="Create exam file">
  <p><a href = "#">exam</a></p>
 </div>
<% } %>

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
   <% for( int i=0; i<5 ; i++ ) { %>
   <p class = "b_exam"><a href = "#">・example1<%-- <%= be.getExamName() %> --%></a></p>
   <% } %>
   </div>

   <div class = "r_box">
   <% for( int i=0; i<5 ; i++ ) { %>
   <p>日付・試験名・成績(レポート)<%-- <%= rp.getExamDate() %> <%= be.getExamName() %> <%= rp.getReportID() %> --%></p>
   <% } %>
   </div>
</div>

<div class = "miru_br">

<div class = "miru_b"><p class = "miru"><a href = "#">もっとみる</a></p></div>
<div class = "miru_r"><p class = "miru"><a href = "#">もっとみる</a></p></div>

</div>

</main>
</body>
</html>