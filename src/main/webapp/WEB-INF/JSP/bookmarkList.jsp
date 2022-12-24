<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブックマーク一覧</title>
</head>
<body>
<jsp:include page="./header.jsp" />
<h1>ブックマーク一覧</h1>
<p><c:out value="${bookmarkList.bookmarkList.size()}"/>件</p><br>
<c:if test="${not empty msg}"><p><c:out value="${msg}"/></p></c:if>
<c:forEach var="exam" items="${bookmarkList.bookmarkList}" begin="${(bookmarkList.page - 1)*bookmarkList.STEP}" end="${bookmarkList.page * bookmarkList.STEP - 1}">
 <div class = "exam">
  	<p>
 	<a href = "/ExamPlatform/ExaminationServlet?examID=<c:out value="${exam.examID}"/>"><c:out value="${exam.examName}"/></a>
 	</p>
 </div><br/>
</c:forEach>
<br>
<ul style="display: flex; justify-content: center; list-style: none;">
<c:forEach var="pageNum" begin="1" end="${bookmarkList.maxPage}" varStatus="sts">
<c:if test="${sts.first && bookmarkList.page != 1}"><li><a href="/ExamPlatform/Mypage/BookmarkListServlet?page=<c:out value="${bookmarkList.page - 1}"/>" > ＜前へ </a></li></c:if>
<c:choose><c:when test="${bookmarkList.page == pageNum}"><li> <c:out value="${pageNum}"/> </li></c:when><c:otherwise><li><a href="/ExamPlatform/Mypage/BookmarkListServlet?page=<c:out value="${pageNum}"/>"> <c:out value="${pageNum}"/> </a></li></c:otherwise></c:choose>
<c:if test="${sts.last && bookmarkList.page != bookmarkList.maxPage}"><li><a href="/ExamPlatform/Mypage/BookmarkListServlet?page=<c:out value="${bookmarkList.page + 1}"/>"> 次へ＞ </a></li></c:if>
</c:forEach>
</ul>
</body>
</html>