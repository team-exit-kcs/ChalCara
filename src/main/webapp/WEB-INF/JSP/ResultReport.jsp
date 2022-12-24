<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import = "model.data.Report" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="./css/ResultReport.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<main>
<div id = "main_box" class = "container">
<div class = "flex row col-12">
<div class = "col-4"></div>
<div class = "col-4"><h1 id = "mi" class = "text-center">成績結果</h1></div>
<div class = "col-4"><input  class = "btn btn-outline-primary btn-block" type="button" id = insatu value = "印刷" onclick = "window.print();" /></div>
</div>
<div class ="flex row col-12">
<div class = "col-3"></div>
<div class = "col-6">
<p class = "cord">試験名：<c:out value="${report.examName}"/></p><br>
<p class = "cord">経過時間：<c:out value="${report.useTime}"/>分</p>
<div  class = gouhi_ten>
<c:choose>
 <c:when test="${report.notRedoExam}">
 	<c:choose>
 	<c:when test="${report.score >= report.passingScore }">
 	<h2 id = gouhi>合格</h2>
 	</c:when>
	 <c:otherwise>
 	<h2 id = gouhi>不合格</h2>
 	</c:otherwise>
	</c:choose>
 </c:when>
 <c:otherwise>
 <h2 id = gouhi>合否なし</h2>
 </c:otherwise>
</c:choose>

<p id = ten><c:out value="${report.score}"/></p>
</div>

<div class = name_date>
<c:if test ="${not empty LoginUser}"><p id = name class = "cord">ユーザ名：<c:out value="${report.userID}"/></p></c:if>
<c:set var="pattern" value="yyyy/MM/dd" />

<p id="date" class = "cord">試験日：<fmt:formatDate value="${report.examDate}" pattern="${pattern}"/></p>
<%--<script>
date = new Date();
year = date.getFullYear();
month = date.getMonth() + 1;
day = date.getDate();
document.getElementById("date").innerHTML = year + "/" + month + "/" + day;
</script> --%>
</div>
<div id = "syousai" class = "text-end">
<%-- <c:if test="${not empty checkAnsPage}"></c:if>--%><a href = "/ExamPlatform/Report/CheckAns" class = "cord btn btn-outline-primary btn-block">詳細</a><br>
</div>
</div>
<div class = "col-3"></div>
</div>

<div class = "button_area d-flex justify-content-center col-12">
<div class = "row">
<div class = "col-auto">
<a class = "btn btn-outline-primary btn-block" href = "/ExamPlatform/ExaminationServlet?examID=<c:out value="${report.examID}"/>" id = "replay">もう一度やる</a>
</div>
<div class = "col-auto">
<a class = "btn btn-outline-primary btn-block" href = "/ExamPlatform/HomeServlet" id = "back">ホームに戻る</a>
</div>
</div>
</div>

</div>
<%--<script src="./js/print.js"></script>--%>
</main>
</body>
</html>