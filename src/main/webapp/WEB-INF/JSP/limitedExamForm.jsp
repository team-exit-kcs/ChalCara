<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>限定公開試験</title>
</head>
<body>
<form action="/ExamPlatform/ExaminationServlet/Limited" method="post">
	<div style="text-align: center; font-size: xx-large">
		<span style="font-weight: bold">
			試験名：<c:out value="${pageData.exam.examName}"/><br/>
		</span>
		<span>
				<label for="input_pw">パスワード:</label>
				<input type="password" required id="input_pw" name="pass">
				<c:if test="${not empty msg}"><p class="errorMsg"><c:out value="${msg}"/></p></c:if>
		</span>
		<input type="submit" value= "確定">
	</div>
</form>
</body>
</html>