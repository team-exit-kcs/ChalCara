<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>正誤判定</title>
<style>
td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>試験名：<span><c:out value="${report.examName}"/></span></h1>
	
	<div style="text-align: center">
	<c:forEach var="BQ" items="${checkAnsPage.BQCheckAnsList}">
		<h3>問<c:out value="${BQ.bigQuestionID}"/></h3><br>
		<p><c:out value="${BQ.bigQuestionSentence}"/></p><br>
		
		<table style="display: inline-block; ">
			<tr>
				<th>設問番号</th>
				<th>問題文</th>
				<th>選択肢</th>
				<th>正誤判定</th>
				<th>答え</th>
				<th>あなたの回答</th>
				<th>解説</th>
				<th>配点</th>
			</tr>

			<c:forEach var="Q" items="${BQ.checkAnsList}">
				<tr>
					<td><c:out value="${Q.questionID}"/></td>
					<td><c:out value="${Q.questionSentence}"/></td>
					<td>
					<c:forEach var="C" items="${Q.choicesList}">
						<c:out value="${C.choicesID}"/>. <c:out value="${C.choices}"/><br>
					</c:forEach>
					</td>
					<td><c:choose><c:when test="${Q.tf}">○</c:when><c:otherwise>×</c:otherwise></c:choose></td>
					<td><c:out value="${Q.answer}"/></td>
					<td><c:choose><c:when test="${Q.userAnswer == 0}">-</c:when><c:otherwise><c:out value="${Q.userAnswer}"/></c:otherwise></c:choose></td>
					<td><c:out value="${Q.questionExplanation}"/></td>
					<td><c:out value="${Q.allocationOfPoint}"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:forEach>
	
		<div style="margin-top: 20px">
			<a href="/ExamPlatform/Report">レポートに戻る</a>
		</div>
	</div>
</body>
</html>