<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会</title>
</head>
<body>
<h1>退会</h1>
<p>退会するとユーザデータ及びすべての試験データが削除されます</p><br/>
<button type="button" id = "btn-back" class = "back" onclick="location.href='/ExamPlatform/UpdAccountServlet'">戻る</button>
<button type="button" class = "Withdraw" onclick="location.href='/ExamPlatform/UpdAccountServlet/Withdraw/confirm'">退会</button>
</body>
</html>