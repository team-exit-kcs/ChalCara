<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント設定</title>
</head>
<body>
<h1>パスワード更新</h1>
<form action="/ExamPlatform//UpdAccountServlet/UpdPass" method="post">
<span>現在のパスワード<br/></span>
<input type="password" required name="pass"><br/>
<c:if test="${not empty msg}"><p class="msg"><c:out value="${msg}"/></p></c:if>
<span>新しいパスワード<br/></span>
<input type="password" required name="newPass"><br/>
<button type="button" id = "btn-back" class = "back" onclick="location.href='/ExamPlatform/UpdAccountServlet'">戻る</button>
<input type="submit" value="更新">
</form>
</body>
</html>