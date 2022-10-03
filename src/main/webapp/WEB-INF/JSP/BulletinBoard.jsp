<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import = "model.data.Mypage" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
    
<!DOCTYPE html>
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

<div class = "sort">
<a href = "#" id = "sin">新着順</a>
<a href = "#" id = "book">ブクマ順</a>
<a href = "#" id = "acs">月間実行回数順</a>
</div>

<c:set var = "examList" value ="${Mypage.ExamList}" scope = {request} />
<c:set var = "bmList" value ="${Mypage.bmList}" scope = {request} />

<%-- 新着順(デフォ) --%>

<c:forEach var = "v" items = "%{examList}" varStatus = "st" end = "10">
<p id = "Record"><c:out value = "${v.createDate()}" />　　　　　<c:out value = "${v.userID()}"/>　　　　　　　　　　　<a href = "#" id = "exam"><c:out value = "${v.examName()}"/></a></p>
</c:forEach>

<%-- ブクマ順 

<c:if  >
<c:forEach var = "v" items = "%{bmList}" varStatus = "st" end = "10">
<p id = "Record"><c:out value = "${v.createDate()}" />　　　　　<c:out value = "${v.userID()}"/>　　　　　　　　　　　<a href = "#" id = "exam"><c:out value = "${v.examName()}"/></a></p>
</c:forEach>
</c:if>

--%>

<a href = "#">1</a>
</main>
<jsp:include page="./footer.jsp" />
</body>
</html>