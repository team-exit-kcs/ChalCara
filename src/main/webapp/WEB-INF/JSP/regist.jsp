<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/regist.css">
	<title>アカウント登録</title>
</head>
<body>
	<div class="main">
		<span class="message">ここから始めましょう!!</span>
		<h1>アカウント登録</h1>
		<form action="/ExamPlatform/AccountEntryServlet" method="post">
			<div>
				<label for="input_id">ログインID:</label>
				<input type="text" required id="input_id" name="id">
				<c:if test="${not empty msg}"><p class="errorMsg"><c:out value="${msg}"/></p></c:if>
			</div>
			<div>
				<label for="input_pw">パスワード:</label>
				<input type="password" required id="input_pw" name="pass">
			</div>
		
			<input type="submit" value="登録">
		</form>
	
		<a href="/ExamPlatform/LoginServlet">ログインする方はこちら</a>
	</div>
</body>
</html>
