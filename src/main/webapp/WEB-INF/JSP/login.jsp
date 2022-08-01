<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/login.css">
	<title>ログイン</title>
</head>
<body>
	<div class="main">
		<span class="message">Welcome!</span>
		<h1>ログイン</h1>
		<form>
			<div>
				<label for="input_id">ログインID:</label>
				<input type="text" id="input_id" name="login_id">
			</div>
			<div>
				<label for="input_pw">パスワード:</label>
				<input type="password" id="input_pw" name="password">
			</div>
		
			<input type="submit" value="ログイン">
		</form>
	
		<a href="">アカウントをお持ちでない方はこちら</a>
	</div>
</body>
</html>