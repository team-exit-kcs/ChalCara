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
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<link rel = "stylesheet" href= "/ExamPlatform/css/Confimation.css">
<jsp:include page="./title.jsp" />
</head>
<body>
<main>
<div id = "main_box" class = "container">
<h1 class = "mi text-center">確認フォーム</h1>
<div class = "d-flex row">
<div class = "col-5">
<p class = "cord">試験名：</p><br>
<p class = "cord">ジャンル：</p><br>
<p class = "cord">タグ：</p><br>
<p class = "cord">公開範囲：</p><br>
<p class = "cord">問題形式：</p><br>
<p class = "cord">試験時間：</p><br>
<p class = "cord">合格点：</p><br>
<p class = "cord">説明文：</p><br>
<p class = "cord">ゲームでの使用：</p><br>
</div>
<div class = "col-5">
<p><c:out value="${ExamCreatePage.entryExam.examName}" /></p><br>
<p><c:out value="${ExamCreatePage.genreList[(ExamCreatePage.entryExam.genreID - 1)].genreName}" /></p><br>
<p><c:forEach var="tag" items="${ExamCreatePage.entryExam.tagList}">
		<span>${tag} </span>
   </c:forEach>
   <c:if test = "${tag == null}">
   <br>
   </c:if>
</p><br>
<p><c:choose>
		<c:when test="${ExamCreatePage.entryExam.disclosureRange == 0}">公開</c:when>
		<c:when test="${ExamCreatePage.entryExam.disclosureRange == 1}">限定公開</c:when>
		<c:otherwise>非公開</c:otherwise>
	</c:choose>
</p><br>
<p><c:choose>
		<c:when test="${ExamCreatePage.entryExam.questionFormat == 0}">大問</c:when>
		<c:when test="${ExamCreatePage.entryExam.questionFormat == 1}">小問</c:when>
	</c:choose>
</p><br>
<p><c:out value="${ExamCreatePage.entryExam.examTime}" /></p><br>
<p><c:out value="${ExamCreatePage.entryExam.passingScore}" /></p><br>
<%-- <textarea id = "area" placeholder = "<c:out value="${ExamCreatePage.entryExam.examExplanation}" />"></textarea><br>--%>
<p><c:out value="${ExamCreatePage.entryExam.examExplanation}" /></p><br>
<c:if test = "${ExamCreatePage.entryExam.examExplanation == null}">
<br>
</c:if>
<p><c:choose>
		<c:when test="${ExamCreatePage.entryExam.useGame}">許可する</c:when>
		<c:otherwise>許可しない</c:otherwise>
	</c:choose>
</p><br>
</div>
</div>
<hr>
<h2 class = "mi1 text-center">問題一覧</h2><br>
<div class = "container">
<c:forEach var="BQ" items="${ExamCreatePage.bigQuestionList}">
	<c:if test="${ExamCreatePage.entryExam.questionFormat == 0}">
		<span id = "b_toi">問${BQ.bigQuestionID}</span><br>
		<span id = "examcord">${BQ.bigQuestionSentence}</span><br>
	</c:if>
	<br>
	<div class = "d-flex col-12">
	<c:forEach var="Q" items="${BQ.questionList}">
	<div class = "col-4">
		<c:choose>
			<c:when test="${ExamCreatePage.entryExam.questionFormat == 0}"><p class = "setu">＜設問${Q.questionID}＞</p><br></c:when>
			<c:otherwise><span>問${Q.questionID}</span><br></c:otherwise>
		</c:choose>
		<span class = "s_toi">${Q.questionSentence}</span><br>
		<div class = "lh-lg">
		<span>解説：${Q.questionExplanation}</span><br>
		<span>配点：${Q.allocationOfPoint}</span><br>
		<c:forEach var="choices" items="${Q.choicesList}">
			<c:if test="${choices.choicesID==Q.answer}">
				<span>答え   </span>
			</c:if>
			<span>${choices.choicesID}：${choices.choices}</span><br>
		</c:forEach>
		<br>
		</div>
	</div>
	</c:forEach>
	</div>
</c:forEach>
</div>
<div class = "botton_area d-flex justify-content-center row">

<form action="/ExamPlatform/ExamCreateServlet/Confirmation" method="post">
<div class = "row justify-content-center">
<div class = "col-auto">
	<button type="button" class = "btn btn-outline-primary btn-block" id = "btn-back" class = "back" onclick="location.href='/ExamPlatform/ExamCreateServlet'">戻る</button>
</div>
<div class = "col-auto">
	<input type="submit" class = "btn btn-outline-primary btn-block" value = "確定" class = "ok"></input>
</div>
</div>
</form>

</div>

</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</main>
</body>
</html>