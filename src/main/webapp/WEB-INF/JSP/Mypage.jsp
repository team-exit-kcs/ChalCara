<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<%@ page import = "model.data.Account" %>
<%@ page import = "model.data.Report" %>
<%@ page import = "model.data.Mypage" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>


     <% 
        Account account = (Account) session.getAttribute("LoginAccount");
        Mypage mypage = (Mypage) request.getAttribute("MypageData");
        List<String> examList = mypage.getExamList();
        List<String> bmList = mypage.getBookmarkList();
        List<Report> rpList = mypage.getReportList();
      %>


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
    <img src="<%= account.getIcon()%> "height="220" width="220" alt="User Icon">
  </span>
</div>
<div class="r1_item_2">
    <p><%=account.getUserID()%></p>
</div>
<div class="r1_item_3">
    <p><%=account.getProfile()%></p>
</div>

</div>

<h2 class="mi_2">IBT作成一覧</h2>

<div class="box_1">

<% int examListsize = examList.size();

for (int i=0 ;i<5 && i < examListsize ;i++) { %>
 <div class = "exam">
  <img src="./img/exam.png" height="70" width="70" alt="Create exam file">
  <p><a href = "#"><%= examList.get(i)%></a></p>
 </div>
<% }%>

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
   <% int bmListsize = bmList.size();
   for( int i=0; i<5 && i < bmListsize ; i++ ) { %>
   <p class = "b_exam"><a href = "#"><%= bmList.get(i)%></a></p>
   <% } %>
   </div>

   <div class = "r_box">
   <% int rpListsize = rpList.size();
       SimpleDateFormat si = new SimpleDateFormat("yyyy/MM/dd");%>
   <% for(int i=0; i<5 && i < rpListsize ; i++ ) { 
	   Report rp = rpList.get(i);
	   Date ReportDate = rp.getExamDate();%>
   <p class = "test"> 《<%= si.format(ReportDate)%>》 《<%= rp.getReportID()%>》 《<%= rp.getExamName()%>》</p>
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