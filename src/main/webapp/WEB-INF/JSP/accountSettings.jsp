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
<h1>アカウント管理</h1>
<div>
<span>ユーザID: <c:out value="${LoginUser.userID}"/><br/></span>
<span>パスワード: 非表示<br/><button type="button" onclick="location.href='/ExamPlatform/UpdAccountServlet/UpdPass'">パスワードを変更する</button><br/></span>
<div>
<br/>
<form action="/ExamPlatform/UpdAccountServlet" method="post">
<span>プロフィール<br/></span>
<textarea name = "profile"><c:out value="${LoginUser.profile}"/></textarea><br>
<label>
    <input type="checkbox" id="useInfo" name="useInfo" value="true" <c:if test="${LoginUser.useInfoDefault}">checked="checked"</c:if>>
   	受験情報を試験作成者に送信する(デフォルト)
</label>
<br><input type="submit" value="更新">
</form>
</div>
</div>
<div>
<button type="button" id = "btn-back" class = "back" onclick="location.href='/ExamPlatform/MypageServlet'">戻る</button>
<button type="button" class = "Withdraw" onclick="location.href='/ExamPlatform/UpdAccountServlet/Withdraw'">退会</button>
</div>
</body>
</html>