<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/login.css">
	<title>ログイン</title>
</head>
<body>
	<div class="main">
		<span class="message">Welcome!</span>
		<h1>ログイン</h1>
		<form action="/ExamPlatform/LoginServlet" method="post">
			<div>
				<label for="input_id">ログインID:</label>
				<input type="text" required id="input_id" name="id">
			</div>
			<div>
				<label for="input_pw">パスワード:</label>
				<input type="password" required id="input_pw" name="pass">
				<c:if test="${not empty msg}"><p class="errorMsg"><c:out value="${msg}"/></p></c:if>
			</div>
		
			<input type="submit" value="ログイン">
		</form>
	
		<a href="/ExamPlatform/AccountEntryServlet">アカウントをお持ちでない方はこちら</a>
	</div>
</body>
</html>