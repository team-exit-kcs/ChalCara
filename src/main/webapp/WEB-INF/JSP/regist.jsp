<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/regist.css">
	<title>アカウント登録</title>
</head>
<body>
	<div class="main">
		<span class="message">ここから始めましょう!!</span>
		<h1>アカウント登録</h1>
		<form action="/ExamPlatform/AccountEntryServret" method="post">
			<div>
				<label for="input_id">ログインID:</label>
				<input type="text"　required id="input_id" name="id">
				<c:if test="${not empty msg}"><p class="errorMsg"><c:out value="${msg}"/></p></c:if>
			</div>
			<div>
				<label for="input_pw">パスワード:</label>
				<input type="password"　required id="input_pw" name="pass">
			</div>
		
			<input type="submit" value="登録">
		</form>
	
		<a href="">ログインする方はこちら</a>
	</div>
</body>
</html>
