<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/ExamPlatform/css/searchForm.css">
<link rel="stylesheet" href="/ExamPlatform/css/searchResult.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>いぐざむぷらっとふぉーむ - 検索</title>
</head>
<body>
<jsp:include page="./header.jsp" />
<jsp:include page="./searchForm.jsp" /><br>
<div id = "main_box2" class = "container">
<p id = "cord">検索結果 <c:out value="${searchResult.resultList.size()}"/>件</p><br>
<hr>
<c:if test="${not empty msg}"><p><c:out value="${msg}"/></p></c:if>
<c:forEach var="result" items="${searchResult.resultList}" begin="${(searchResult.page - 1)*searchResult.STEP}" end="${searchResult.page * searchResult.STEP - 1}">
<span><img src="<c:out value="${result.icon}"/>" style="width: 25px;"><a href="<c:out value="${result.URL}"/>" ><c:out value="${result.name}"/></a></span><br/>
</c:forEach>
<br>
<ul id = "pagenation" style="display: flex; justify-content: center; list-style: none;">
<c:forEach var="pageNum" begin="1" end="${searchResult.maxPage}" varStatus="sts">
<c:if test="${sts.first && searchResult.page != 1}"><li><a href="/ExamPlatform/SearchServlet/result?page=<c:out value="${searchResult.page - 1}"/>" > ＜前へ </a></li></c:if>
<c:choose><c:when test="${searchResult.page == pageNum}"><li> <c:out value="${pageNum}"/> </li></c:when><c:otherwise><li><a href="/ExamPlatform/SearchServlet/result?page=<c:out value="${pageNum}"/>"> <c:out value="${pageNum}"/> </a></li></c:otherwise></c:choose>
<c:if test="${sts.last && searchResult.page != searchResult.maxPage}"><li><a href="/ExamPlatform/SearchServlet/result?page=<c:out value="${searchResult.page + 1}"/>"> 次へ＞ </a></li></c:if>
</c:forEach>
</ul>
</div>
</body>
</html>