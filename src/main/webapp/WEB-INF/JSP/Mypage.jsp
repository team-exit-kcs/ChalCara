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

<c:set var="maxCnt" value="6" />

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="./css/Mypage.css">
<jsp:include page="./title.jsp" />
</head>
<body>
<main>
<jsp:include page="./header.jsp" />
<div class = "container-fluid">
<h2 id = "mi"class="text-center w-auto h-auto">マイページ</h2>
<div class = "root_1  container d-flex w-auto h-auto">

<div class="r1_item_1 col-4 mt-5">
  <span>
    <img src="img/kari.png"height="220" width="220" alt="User Icon">
  </span>
</div>
<div class="r1_item_2 col-4 mt-5">
    <p>ユーザID : <c:out value="${LoginUser.userID}"/></p>
    <br/><a class = "UpdAccount" href = "/ExamPlatform/UpdAccountServlet" >アカウント設定</a>
</div>
<div class="r1_item_3 col-4 mt-5">
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
  <p><a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value="${exam.examID}"/>"><c:out value="${exam.examName}"/></a></p>
 </div>
</c:forEach>

</div>

<p class = "miru"><a href = "#">もっとみる</a></p>

<div class = "mi_root row">

<div class = "book col-6 mt-5">
<h2 class = "b_mi">ブックマーク一覧</h2>
<div class = "b_box">
   <c:forEach var="bookmark" items="${MypageData.bookmarkList}" end="${maxCnt}">
   <p class = "b_exam"><a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value="${bookmark.examID}"/>"><c:out value="${bookmark.examName}"/></a></p>
   </c:forEach>
   </div>
<p class = "miru_1"><a href = "#">もっとみる</a></p>
</div>

<div class = "repo col-6 mt-5">
<h2 class = "r_mi">レポート一覧</h2>
<div class = "r_box">
   <c:set var="pattern" value="yyyy/MM/dd" />
   <c:forEach var="report" items="${MypageData.reportList}" end="${maxCnt}">
   <p class = "test"> <a href = "/ExamPlatform/Report?reportID=<c:out value="${report.reportID}"/>">《<fmt:formatDate value="${report.examDate}" pattern="${pattern}"/>》 《<c:out value="${report.reportID}"/>》 《<c:out value="${report.examName}"/>》</a></p>
   </c:forEach>
   </div>
<p class = "miru_2"><a href = "#">もっとみる</a></p>
</div>
</div>
</div>
</main>

</body>
</html>