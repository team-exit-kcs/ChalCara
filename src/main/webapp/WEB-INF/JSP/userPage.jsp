<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<c:set var="maxCnt" value="6" />

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="./css/Mypage.css">
<title><c:out value="${userPage.user.userID}"/></title>
</head>
<body>
<main>
<jsp:include page="./header.jsp" />
<div class = "container-fluid">
<div class = "root_1 container d-flex w-auto h-auto">

<div class="r1_item_1 col-4 mt-5">
  <span>
    <img src="<c:out value="${userPage.user.icon}"/> "height="220" width="220" alt="User Icon">
  </span>
</div>
<div class="r1_item_2 col-4 mt-5">
    <p><c:out value="${userPage.user.userID}"/></p>
</div>
<div class="r1_item_3 col-4 mt-5">
    <p><c:out value="${userPage.user.profile}"/></p>
</div>

</div>

<div class = "Create_box">
<h2 class="mi_2">試験一覧</h2>

</div>
<div class="box_1">

<c:forEach var="exam" items="${userPage.examList}" end="${maxCnt}">
 <div class = "exam">
  <img src="./img/exam.png" height="70" width="70" alt="Create exam file">
  <p><a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value="${exam.examID}"/>"><c:out value="${exam.examName}"/></a></p>
 </div>
</c:forEach>

</div>
<p class = "miru"><a href = "/ExamPlatform/ExamListServlet?userID=<c:out value="${LoginUser.userID}"/>">もっとみる</a></p>

</div>
</main>
</body>
</html>