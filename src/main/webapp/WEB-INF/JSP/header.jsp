<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%-- headerを動的インクルードさせる --%>
    
<link rel = "stylesheet" href= "./css/header.css">
<link rel = "stylesheet" href= "./css/nav.css">

 
 <header id = "header_1">
 
 <div class = "header_box">
 <span id = "h1">いぐざむぷらっとふぉーむ</span>
 <c:choose><c:when test="${empty LoginUser}"><button id = "login" onclick = "location.href='/ExamPlatform/LoginServlet'">ログイン</button></c:when><c:otherwise><button id = "login" onclick = "location.href='/ExamPlatform/LogoutServlet'">ログアウト</button></c:otherwise></c:choose>
 </div>
 
 <nav>
   <ul class = "nav_list">
      <li><a href = "#">ホーム</a>
      <li><a href = "#">試験検索</a>
      <li><a href = "#">ゲーム</a>
      <li><a href = "/ExamPlatform/MypageServlet">マイページ</a>
   </ul> 
</nav>
 
</header>
 
 
 

