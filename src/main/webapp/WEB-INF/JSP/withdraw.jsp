<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>退会</title>
</head>
<body>
<h1>退会</h1>
<p>退会するとユーザデータ及びすべての試験データが削除されます</p><br/>
<button type="button" id = "btn-back" class = "back" onclick="location.href='/ExamPlatform/UpdAccountServlet'">戻る</button>
<button type="button" class = "Withdraw" onclick="location.href='/ExamPlatform/UpdAccountServlet/Withdraw/confirm'">退会</button>
</body>
</html>