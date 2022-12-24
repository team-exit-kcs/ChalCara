<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>退会</title>
</head>
<body>
<h1>退会確認</h1>
<p>退会するとユーザデータ及びすべての試験データが削除されます<br/>この操作は取り消せません　本当に退会する場合はユーザIDとパスワードを入力してください</p><br/>
<form action="/ExamPlatform/UpdAccountServlet/Withdraw/confirm" method="post">
	<div>
		<label for="input_id">ユーザID:</label>
		<input type="text" required id="input_id" name="id"><br/>
		
		<label for="input_pw">パスワード:</label>
		<input type="password" required id="input_pw" name="pass">
		<c:if test="${not empty msg}"><p class="errorMsg"><c:out value="${msg}"/></p></c:if>
	</div>
	<button type="button" id = "btn-back" class = "back" onclick="location.href='/ExamPlatform/UpdAccountServlet/Withdraw'">戻る</button>
	<input type="submit" value="退会">
</form>
</body>
</html>