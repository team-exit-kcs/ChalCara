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
<form name="examform" action="/ExamPlatform/CheckAnsServlet" method="post">
	<div style="text-align: center; background-color: aqua; position: fixed; width: 100%; top: 0; left: 0;">
		<input type="hidden" name="time" id="time" value="0">
		試験時間(残り)：
		<span id="remainingTime"></span>
		
		<button onclick="QuitExecManually()">試験を終了する</button>
	</div>

	<h1 style="text-align: center;">
		<c:out value="${pageData.exam.examName}"/>
	</h1>
	
	<c:forEach var="BQ" items="${pageData.bigQuestionList}">
	<h2>
		大問
		<c:out value="${BQ.bigQuestionID}"/>
	</h2>
	
	<p>
		<c:out value="${BQ.bigQuestionSentence}"/>
	</p>
	
	<c:forEach var="Q" items="${BQ.questionList}">
		<div>
			設問
			<c:out value="${Q.questionID}"/><br/>
		
			<p>
				<c:out value="${Q.questionSentence}"/>
			</p>
		
			<c:forEach var="C" items="${Q.choicesList}">
				<input name='<c:out value="${C.bigQuestionID}"/>-<c:out value="${C.questionID}"/>' value=<c:out value="${C.choicesID}"/> type="radio">
				<label>
					<c:out value="${C.choicesID}"/>.<c:out value="${C.choices}"/>
				</label>
			</c:forEach>
		</div>
		</c:forEach>
	</c:forEach>
</form>

	<!-- #region JS要素 -->
	<script>
	const examtime = <c:out value="${pageData.exam.examTime}"/> * 60 * 1000;
	//const examtime = 0.25 * 60 * 1000;
	let time = Math.floor(examtime / 1000);
	let useTime = time;
	
	function QuitExecManually() {
		if (confirm("本当に終了しますか?")) {
			//ページのリダイレクト
			document.examform.submit();
			//window.location.href = "/ExamPlatform/CheckAnsServlet"
			//alert("ページのリダイレクトする");
		}
	}

	//QuitExamAutomatically
	setTimeout(function () {
		//ページのリダイレクト or ユーザにPOSTさせる
		alert("時間切れ");
		document.examform.submit();
	}, examtime/*ここに時間(ミリ秒)*/);

	setInterval(function () {
		if (time > 0) {
			--time;
			document.getElementById("remainingTime").textContent = "" + zeroPad(Math.floor(time / 60)) + ":" + zeroPad(time % 60);
			document.getElementById("time").value = Math.floor((useTime - time) / 60);
		}
	}, 1000);

	function zeroPad(n) {
		let s = n.toString();
		if (s.length == 1) {
			return "0" + s;
		}
		return s;
	}
	</script>
	<!-- #endregion -->
</body>
</html>