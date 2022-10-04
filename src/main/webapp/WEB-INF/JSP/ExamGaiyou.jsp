<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>試験概要</title>
</head>
<body>
	
	<div style="text-align: center">
		試験作成日：
		<span><c:out value="${pageData.exam.createDate}"/></span>
		
		更新日：
		<span><c:out value="${pageData.exam.updateDate}"/></span>
	</div>
	
	<div>
		実行回数：
		<span><c:out value="${pageData.exam.exeCount}" /></span>
	</div>
	
	<div>
		試験名：
		<span><c:out value="${pageData.exam.examName}"/></span>
	</div>
	
	<div style="text-align: right;">
		試験ID:
		<span><c:out value="${pageData.exam.examID}"/></span>
	</div>

	<div>
		ジャンル名：
		<span><c:out value="${pageData.exam.genreName}"/></span>
	</div>

	<div>
		製作者ユーザID：
		<span><c:out value="${pageData.exam.userID}"/></span>
	</div>
	
	<div>
		タグ：
		<c:forEach var="Tag" items="${pageData.exam.tagList}">
		<span><c:out value="${Tag}"/></span>
		</c:forEach>
	</div>
	<c:if test="${not empty LoginUser}"><button onclick="location.href='/ExamPlatform/BookmarkServlet'"><c:choose><c:when test="${pageData.bookmark}">ブックマークを外す</c:when><c:otherwise>ブックマーク</c:otherwise></c:choose></button></c:if>
	
	<div>
		ブックマーク数：
		<span><c:out value="${pageData.exam.bookmarkCount}"/></span>
	</div>

	
	<div style="text-align: center; border: 1px solid black">
		<h2>試験概要</h2>
		<p><c:out value="${pageData.exam.examExplanation}"/></p>
	</div>
	
	<div>
		合格点：
		<span><c:out value="${pageData.exam.passingScore}"/></span>
	</div>
	
	<div style="text-align: center">
		試験時間：
		<span><c:out value="${pageData.exam.examTime}"/></span>
		
		<div>
			<button onclick="location.href='/ExamPlatform/ConductTheExamServlet'">試験開始</button>
		</div>
	</div>
</body>
</html>