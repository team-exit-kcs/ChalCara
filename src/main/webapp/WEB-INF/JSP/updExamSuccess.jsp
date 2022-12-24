<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新完了</title>
</head>
<body>
<h1>更新が完了しました</h1>
<a href="/ExamPlatform/ExaminationServlet?examID=<c:out value="${updExamID}"/>">試験ページへ</a><br>
<a href="/ExamPlatform/UpdExam/Overview?examID=<c:out value="${updExamID}"/>">試験更新ページへ</a><br>
<a href="/ExamPlatform/UpdExam/Question?examID=<c:out value="${updExamID}"/>">試験問題更新ページへ</a><br>
<a href="/ExamPlatform/HomeServlet">ホームに戻る</a><br>
<a href="/ExamPlatform/MypageServlet">マイページに戻る</a>
</body>
</html>