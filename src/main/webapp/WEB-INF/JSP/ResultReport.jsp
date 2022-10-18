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
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="./css/ResultReport.css">
</head>
<body>
<main>
<div id = header>
<h1>成績結果</h1>
<input type="button" id = insatu value = "印刷" onclick = "window.print();" />
<%-- <button class = "insatu">
<span>印刷</span>
</button>--%>
</div>
<p id = Examname><c:out value="${report.examName}"/></p>
<div  class = gouhi_ten>
<%-- int ten = report.getScore();
   int g_ten = report.getPassingScore();
   String gouhi;
   
   if(ten>g_ten){
   gouhi = "合格";
   } else {
   gouhi = "不合格";
   }--%>
   
<c:choose>
 <c:when test="${report.score >= report.passingScore }">
 <h2 id = gouhi>合格</h2>
 </c:when>
 <c:otherwise>
 <h2 id = gouhi>不合格</h2>
 </c:otherwise>
</c:choose>

<p id = ten><c:out value="${report.score}"/></p>
</div>

<div class = name_date>
<p id = name><c:out value="${report.userID}"/></p>
<c:set var="pattern" value="yyyy/MM/dd" />

<p id="date"><fmt:formatDate value="${report.examDate}" pattern="${pattern}"/></p>
<%--<script>
date = new Date();
year = date.getFullYear();
month = date.getMonth() + 1;
day = date.getDate();
document.getElementById("date").innerHTML = year + "/" + month + "/" + day;
</script> --%>
</div>

<c:if test="${not empty checkAnsPage}"><a href = "/ExamPlatform/Report/CheckAns" id = "syousai">詳細</a><br></c:if>

<div class = "replay_back">
<a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value="${report.examID}"/>" id = "replay">もう一度やる</a>
<a href = "/ExamPlatform/HomeServlet" id = "back">ホームに戻る</a>
</div>

<%--<script src="./js/print.js"></script>--%>
</main>
</body>
</html>