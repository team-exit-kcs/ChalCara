<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import = "model.data.Exam" %>
<%@ page import = "model.data.Account" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<%
   Account accunt = (Account) application.getAttribute("UserID");
   Exam exam = (Exam) application.getAttribute("Exam");
%>
    
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
<% 
   String str = "exam1,exam2,exam3,exam4";
   request.setAttribute("data",str);
%>
<c:forTokens var="s" items="${data}" delims="," varStatus="st">
<p id = "Record"> yyyy/mm/dd　　　　　UserID　　　　　　　　　　　<a href = "#" id = "exam">examname</a></p>
</c:forTokens>

<a href = "#">1</a>
</main>
<jsp:include page="./footer.jsp" />
</body>
</html>