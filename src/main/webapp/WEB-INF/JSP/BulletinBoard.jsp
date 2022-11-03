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

<h2>掲示板</h2>
 -->
 
<div class = "sort">
<input type = "radio" name = "root" id = "sin" value = "select_1"  onclick="formSwitch()" checked><label id = "sin">新着順</label>
<input type = "radio" name = "root" id = "book" value = "select_2" onclick="formSwitch()" ><label id = "book">ブクマ順</label>
<input type = "radio" name = "root" id = "acs" value = "select_3"  onclick="formSwitch()" ><label id = "acs">月間実行回数順</label>
</div>

<c:set var = "sinList" value ="${HomeData.newExamList}" scope = "request" />
<c:set var = "bookList" value ="${HomeData.monthlytopExamList}" scope = "request" />
<c:set var = "acsList" value ="${HomeData.bookmarkExamList}" scope = "request" />
<c:set var="pattern" value="yyyy/MM/dd" />

<div id = "box1">
<c:forEach var = "v" items = "${sinList}" varStatus = "st" begin = "0" end = "9"  step = "1">
<p id = "Record"><fmt:formatDate value="${v.createDate}" pattern="${pattern}"/>　　　　　<c:out value = "${v.userID}"/>　　　　　　　　　　　<a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value = "${v.examID}"/>" id = "exam"><c:out value = "${v.examName}"/></a></p>
</c:forEach>
</div>

<div id = "box2">
<c:forEach var = "v" items = "${bookList}" varStatus = "st" begin = "0" end = "9" step = "1">
<p id = "Record"><fmt:formatDate value="${v.createDate}" pattern="${pattern}"/>　　　　　<c:out value = "${v.userID}"/>　　　　　　　　　　　<a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value = "${v.examID}"/>" id = "exam"><c:out value = "${v.examName}"/></a></p>
</c:forEach>
</div>

<div id = "box3">
<c:forEach var = "v" items = "${acsList}" varStatus = "st" begin = "0" end = "9"  step = "1">
<p id = "Record"><fmt:formatDate value="${v.createDate}" pattern="${pattern}"/>　　　　　<c:out value = "${v.userID}"/>　　　　　　　　　　　<a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value = "${v.examID}"/>" id = "exam"><c:out value = "${v.examName}"/></a></p>
</c:forEach>

</div>
<script src="/ExamPlatform/js/Category.js">formSwitch();</script>

<!-- 
</main>
<jsp:include page="./footer.jsp" />
</body>
</html>
 -->