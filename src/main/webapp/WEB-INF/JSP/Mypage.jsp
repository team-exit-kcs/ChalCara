<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import = "model.data.Account" %>
<%@ page import = "model.data.Report" %>
<%@ page import = "model.data.Mypage" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>


<!DOCTYPE html>

<c:set var="maxCnt" value="4" />

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
    <img src="<c:out value="${LoginUser.icon}"/> "height="220" width="220" alt="User Icon">
  </span>
</div>
<div class="r1_item_2">
    <p>ユーザID : <c:out value="${LoginUser.userID}"/></p>
    <br/><a class = "UpdAccount" href = "/ExamPlatform/UpdAccountServlet" >アカウント設定</a>
</div>
<div class="r1_item_3">
    <p><c:out value="${LoginUser.profile}"/></p>
</div>

</div>

<div class = "Create_box">
<h2 class="mi_2">試験一覧</h2>
<a class = "Create_exam" href = "/ExamPlatform/ExamCreateServlet" >試験問題を作成</a>
<a href = "/ExamCreateServlet"></a>

</div>
<div class="box_1">

<c:forEach var="exam" items="${MypageData.examList}" end="${maxCnt}">
 <div class = "exam">
  <img src="./img/exam.png" height="70" width="70" alt="Create exam file">
  <p><a href = "#"><c:out value="${exam}"/></a></p>
 </div>
</c:forEach>

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
   <c:forEach var="bookmark" items="${MypageData.bookmarkList}" end="${maxCnt}">
   <p class = "b_exam"><a href = "#"><c:out value="${bookmark}"/></a></p>
   </c:forEach>
   </div>

   <div class = "r_box">
   <c:set var="pattern" value="yyyy/MM/dd" />
   <c:forEach var="report" items="${MypageData.reportList}" end="${maxCnt}">
   <p class = "test"> 《<fmt:formatDate value="${report.examDate}" pattern="${pattern}"/>》 《<c:out value="${report.reportID}"/>》 《<c:out value="${report.examName}"/>》</p>
   </c:forEach>
   </div>
   
</div>

<div class = "miru_br">

<div class = "miru_b"><p class = "miru"><a href = "#">もっとみる</a></p></div>
<div class = "miru_r"><p class = "miru"><a href = "#">もっとみる</a></p></div>

</div>

</main>
</body>
</html>