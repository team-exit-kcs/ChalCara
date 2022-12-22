<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レポート一覧</title>
</head>
<body>
<jsp:include page="./header.jsp" />
<h1>レポート一覧</h1>
<p><c:out value="${reportList.reportList.size()}"/>件</p><br>
<c:if test="${not empty msg}"><p><c:out value="${msg}"/></p></c:if>
<c:set var="pattern" value="yyyy/MM/dd" />
<c:forEach var="report" items="${reportList.reportList}" begin="${(reportList.page - 1)*reportList.STEP}" end="${reportList.page * reportList.STEP - 1}">
<p class = "test"> <a href = "/ExamPlatform/Report?reportID=<c:out value="${report.reportID}"/>">《<fmt:formatDate value="${report.examDate}" pattern="${pattern}"/>》 《<c:out value="${report.reportID}"/>》 《<c:out value="${report.examName}"/>》</a></p>
</c:forEach>
<br>
<ul style="display: flex; justify-content: center; list-style: none;">
<c:forEach var="pageNum" begin="1" end="${reportList.maxPage}" varStatus="sts">
<c:if test="${sts.first && reportList.page != 1}"><li><a href="/ExamPlatform/Mypage/ReportListServlet?page=<c:out value="${reportList.page - 1}"/>" > ＜前へ </a></li></c:if>
<c:choose><c:when test="${reportList.page == pageNum}"><li> <c:out value="${pageNum}"/> </li></c:when><c:otherwise><li><a href="/ExamPlatform/Mypage/ReportListServlet?page=<c:out value="${pageNum}"/>"> <c:out value="${pageNum}"/> </a></li></c:otherwise></c:choose>
<c:if test="${sts.last && reportList.page != reportList.maxPage}"><li><a href="/ExamPlatform/Mypage/ReportListServlet?page=<c:out value="${reportList.page + 1}"/>"> 次へ＞ </a></li></c:if>
</c:forEach>
</ul>
</body>
</html>