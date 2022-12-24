<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>試験削除</title>
</head>
<body>
<h1><c:out value="${ExamDelete.examName}"/>を削除する</h1>
<p><c:out value="${ExamDelete.examName}"/>を削除します<br/>この操作は取り消せません　本当に削除する場合は <b><c:out value="${ExamDelete.examName}"/></b> と入力してください</p><br/>
<form action="/ExamPlatform/UpdExam/Delete" method="post">
<input type="hidden" id="examID" name="examID" value=<c:out value="${ExamDelete.examID}" />>
	<div>
		<input type="text" required id="examName" name="examName"><br/>
		<c:if test="${not empty msg}"><p class="errorMsg"><c:out value="${msg}"/></p></c:if>
	</div>
	<button type="button" id = "btn-back" class = "back" onclick="/ExamPlatform/UpdExam/Overview?examID=<c:out value="${ExamDelete.examID}"/>">戻る</button>
	<input type="submit" value="試験を削除">
</form>
</body>
</html>