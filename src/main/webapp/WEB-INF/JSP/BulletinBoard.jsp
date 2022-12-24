<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import = "model.data.Mypage" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
    
<!DOCTYPE html>
<!-- 
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/BulletinBoard.css">
<jsp:include page="./title.jsp" />
</head>
<body>
<jsp:include page="./header.jsp" />

<main>


 -->
 <h2 id = "mi"class = "text-center">掲示板</h2>
<div id ="main_box"class = "container">
<div class = "sort d-flex justify-content-around">
<%--
<ul class="nav nav-tabs">
  <li class="nav-item">
  <div><a href="javascript:void(0)" onclick="formSwitch()">新着順</a></div>
  </li>
  <li class="nav-item">
  <div><a href="javascript:void(0)" onclick="formSwitch()">ブクマ順</a></div>
  </li>
  <li class="nav-item">
  <div><a href="javascript:void(0)" onclick="formSwitch()">月間実行回数順</a></div>
  </li>
</ul>
--%>
<div><input type = "radio" name = "root" id = "sin" value = "select_1"  onclick="formSwitch()" checked><label id = "sin">新着順</label></div>
<div><input type = "radio" name = "root" id = "book" value = "select_2" onclick="formSwitch()" ><label id = "book">ブクマ順</label></div>
<div><input type = "radio" name = "root" id = "acs" value = "select_3"  onclick="formSwitch()" ><label id = "acs">月間実行回数順</label></div>
</div>
<br>
<c:set var = "sinList" value ="${HomeData.newExamList}" scope = "request" />
<c:set var = "bookList" value ="${HomeData.monthlytopExamList}" scope = "request" />
<c:set var = "acsList" value ="${HomeData.bookmarkExamList}" scope = "request" />
<c:set var="pattern" value="yyyy/MM/dd" />
<div  id = "root" class = "container-fluid">
<div id = "box1">
<c:forEach var = "v" items = "${sinList}" varStatus = "st" begin = "0" end = "9"  step = "1">
<div class = "d-flex row">
<p class = "Record col-4"><fmt:formatDate value="${v.createDate}" pattern="${pattern}"/></p>
<p class = "Record col-4"><c:out value = "${v.userID}"/></p>
<p class = "Record col-4"><a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value = "${v.examID}"/>" id = "exam"><c:out value = "${v.examName}"/></a></p>
</div>
</c:forEach>
</div>

<div id = "box2">
<c:forEach var = "v" items = "${bookList}" varStatus = "st" begin = "0" end = "9" step = "1">
<div class = "d-flex row">
<p class = "Record col-4"><fmt:formatDate value="${v.createDate}" pattern="${pattern}"/></p>
<p class = "Record col-4"><c:out value = "${v.userID}"/></p>
<p class = "Record col-4"><a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value = "${v.examID}"/>" id = "exam"><c:out value = "${v.examName}"/></a></p>
</div>
</c:forEach>
</div>

<div id = "box3">
<c:forEach var = "v" items = "${acsList}" varStatus = "st" begin = "0" end = "9"  step = "1">
<div class = "d-flex row">
<p class = "Record col-4"><fmt:formatDate value="${v.createDate}" pattern="${pattern}"/></p>
<p class = "Record col-4"><c:out value = "${v.userID}"/></p>
<p class = "Record col-4"><a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value = "${v.examID}"/>" id = "exam"><c:out value = "${v.examName}"/></a></p>
</div>
</c:forEach>
</div>

</div>
</div>
<script src="/ExamPlatform/js/Category.js">formSwitch();</script>

<!-- 
</main>
<jsp:include page="./footer.jsp" />
</body>
</html>
 -->