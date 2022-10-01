<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>試験</title>
</head>
<body style="margin: 50px 0">
	<div style="text-align: center; background-color: aqua; position: fixed; width: 100%; top: 0; left: 0;">
		試験時間：<span></span>
		<button onclick="QuitExecManually()">試験を終了する</button>
	</div>

	<h1><c:out value="${pageData.exam.examName}"/></h1>
	
	<c:forEach var="BQ" items="${pageData.bigQuestionList}">
	<h2>大問<c:out value="${BQ.bigQuestionID}"/></h2><br/>
	
	<p><c:out value="${BQ.bigQuestionSentence}"/></p><br/>
	
	<c:forEach var="Q" items="${BQ.questionList}">
	<div>
		設問<c:out value="${Q.questionID}"/><br/>
		<p><c:out value="${Q.questionSentence}"/></p>
	<c:forEach var="C" items="${Q.choicesList}">
		<input name='<c:out value="${C.bigQuestionID}"/><c:out value="${C.questionID}"/>' value=<c:out value="${C.choicesID}"/> type="radio">
		<label><c:out value="${C.choicesID}"/>.<c:out value="${C.choices}"/></label>
	</c:forEach>
	</div>
	</c:forEach>
	</c:forEach>
	
	
	<!-- #region JS要素 -->
	<script>
	function QuitExecManually() {
		if (confirm("本当に終了しますか?")) {
			//ページのリダイレクト
			//ex) window.location.href = "../"
			alert("ページのリダイレクトする");
		}
	}

	//QuitExamAutomatically
	setTimeout(function () {
		//ページのリダイレクト or ユーザにPOSTさせる
		alert("時間切れ");
	}, 10000/*ここに時間(ミリ秒)*/);
	</script>
	<!-- #endregion -->
</body>
</html>