<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
</head>
<body>
<h4>エラー</h4>
<c:if test="${not empty msg}"><p class="errorMsg"><c:out value="${msg}"/></p></c:if>
<a href="/ExamPlatform/HomeServlet">ホームへ</a>
</body>
</body>
</html>