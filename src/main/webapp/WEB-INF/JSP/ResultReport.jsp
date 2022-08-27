<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="./css/ResultReport.css">
</head>
<body>
<main>
<div id = header>
<h1>成績結果</h1>
<a href="#" id = insatu>印刷</a>
</div>
<p id = Examname>ExamName</p>

<div  class = gouhi_ten>
<h2 id = gouhi>合格</h2>
<p id = ten>100点</p>
</div>

<div class = name_date>
<p id = name>ユーザ名</p>
<p id = date>yyyy/mm/dd</p>
</div>

<a href = "#" id = "syousai">詳細</a><br>

<div class = "replay_back">
<a href = "#" id = "replay">もう一度やる</a>
<a href = "#" id = "back">ホームに戻る</a>
</div>

</main>
</body>
</html>