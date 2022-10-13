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
		<h3>大問1</h3>
		
		<table style="display: inline-block; ">
			<tr>
				<th>問1</th>
				<th>問題文</th>
				<th>正誤判定&答え</th>
				<th>あなたの回答</th>
				<th>説明</th>
			</tr>
			<tr>
				<td>問2</td>
				<td>問題文</td>
				<td>正誤判定&答え</td>
				<td>あなたの回答</td>
				<td>説明</td>
			</tr>
		</table>
	
		<div style="margin-top: 20px">
			<a href="/ExamPlatform/ReportServlet">レポートに戻る</a>
		</div>
	</div>
	
	
</body>
</html>