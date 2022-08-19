<%--確認フォーム --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href= "./css/Confimation.css">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="./css/Confimation.css">
</head>
<body>
<form>
<h1>確認フォーム</h1>

<p>試験名：<%-- examname --%></p><br>
<p>ジャンル：<%-- genle --%></p><br>
<p>タグ：<%-- tag --%></p><br>
<p>公開範囲：<%-- Open Range --%></p><br>
<ul>
  <li>
    <label for="Setu">説明文:</label>
    <textarea id="Setu" name="e_Setu"></textarea>
  </li>
</ul>
<p>問題一覧：</p>
</form>
</body>
</html>