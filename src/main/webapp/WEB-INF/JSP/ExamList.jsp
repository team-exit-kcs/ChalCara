<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>試験一覧</title>
</head>
<body>
<jsp:include page="./header.jsp" />
<h1>試験一覧</h1>
<p><c:out value="${examList.examList.size()}"/>件</p><br>
<c:if test="${not empty msg}"><p><c:out value="${msg}"/></p></c:if>
<c:forEach var="exam" items="${examList.examList}" begin="${(examList.page - 1)*examList.STEP}" end="${examList.page * examList.STEP - 1}">
 <div class = "exam">
  	<p>
  	<img src="./img/exam.png" style="width: 25px;">
 	<a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value="${exam.examID}"/>"><c:out value="${exam.examName}"/></a>
 	</p>
 </div><br/>
</c:forEach>
<br>
<ul style="display: flex; justify-content: center; list-style: none;">
<c:forEach var="pageNum" begin="1" end="${examList.maxPage}" varStatus="sts">
<c:if test="${sts.first && examList.page != 1}"><li><a href="/ExamPlatform/ExamListServlet?userID=<c:out value="${examList.userID}"/>&page=<c:out value="${examList.page - 1}"/>" > ＜前へ </a></li></c:if>
<c:choose><c:when test="${examList.page == pageNum}"><li> <c:out value="${pageNum}"/> </li></c:when><c:otherwise><li><a href="/ExamPlatform/ExamListServlet?userID=<c:out value="${examList.userID}"/>&page=<c:out value="${pageNum}"/>"> <c:out value="${pageNum}"/> </a></li></c:otherwise></c:choose>
<c:if test="${sts.last && examList.page != examList.maxPage}"><li><a href="/ExamPlatform/ExamListServlet?userID=<c:out value="${examList.userID}"/>&page=<c:out value="${examList.page + 1}"/>"> 次へ＞ </a></li></c:if>
</c:forEach>
</ul>
</body>
</html>