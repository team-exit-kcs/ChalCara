<%--確認フォーム --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.EntryExam" %>
<%@ page import = "java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href= "./css/Confimation.css">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="./css/Confimation.css">
</head>
<body>
<main>
<h1>確認フォーム</h1>
<p>試験名：<c:out value="${ExamCreatePage.entryExam.examName}" /></p><br>
<p>ジャンル：<c:out value="${ExamCreatePage.genreList[(ExamCreatePage.entryExam.genreID - 1)].genreName}" /></p><br>
<p>タグ：
	<c:forEach var="tag" items="${ExamCreatePage.entryExam.tagList}">
		<span>${tag} </span>
	</c:forEach>
</p><br>
<p>公開範囲：
	<c:choose>
		<c:when test="${ExamCreatePage.entryExam.disclosureRange == 0}">公開</c:when>
		<c:when test="${ExamCreatePage.entryExam.disclosureRange == 1}">限定公開</c:when>
		<c:otherwise>非公開</c:otherwise>
	</c:choose>
</p><br>
<p>試験時間：<c:out value="${ExamCreatePage.entryExam.examTime}" /></p><br>
<p>合格点：<c:out value="${ExamCreatePage.entryExam.passingScore}" /></p><br>
<p>説明文:<c:out value="${ExamCreatePage.entryExam.examExplanation}" /></p><br>
<p>問題一覧<br>
<c:forEach var="BQ" items="${ExamCreatePage.bigQuestionList}">
	<c:if test="ExamCreatePage.questionFormat == 0">
		<span>問${BQ.bigQuestionID}</span><br>
		<span>${BQ.bigQuestionSentence}</span><br>
	</c:if>
	<c:forEach var="Q" items="${BQ.questionList}">
		<c:choose>
			<c:when test="ExamCreatePage.questionFormat == 0">＜設問${Q.questionID}＞<br></c:when>
			<c:otherwise><span>問${Q.questionID}</span><br></c:otherwise>
		</c:choose>
		<span>${Q.questionSentence}</span><br>
		<span>解説：${Q.questionExplanation}</span><br>
		<span>配点：${Q.allocationOfPoint}</span><br>
		<c:forEach var="choices" items="${Q.choicesList}">
			<c:if test="choices.choicesID==Q.answer">
				<span>答え   </span>
			</c:if>
			<span>${choices.choicesID}：${choices.choices}</span><br>
		</c:forEach>
	</c:forEach>
</c:forEach>
</p>

<div class = "botton_area">
<form action="/ExamPlatform/ExamCreateServlet/Confirmation" method="post">
	<button type="button" id = "btn-back" class = "back" onclick="location.href='/ExamPlatform/ExamCreateServlet'">戻る</button>
	<input type="submit" value = "確定" class = "ok"></input>
</form>
</div>
</main>
</body>
</html>