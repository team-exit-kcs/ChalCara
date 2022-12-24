<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%-- headerを動的インクルードさせる --%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel = "stylesheet" href= "/ExamPlatform/css/header.css">
<link rel = "stylesheet" href= "/ExamPlatform/css/nav.css">

 
 <header id = "header_1">
 
 <div class = "header_box w-auto ">
 <span id = "h1" class = "w-auto h-auto ">いぐざむぷらっとふぉーむ</span>
 <c:choose><c:when test="${empty LoginUser}"><button id = "login"onclick = "location.href='/ExamPlatform/LoginServlet'">ログイン</button></c:when><c:otherwise><button id = "login" onclick = "location.href='/ExamPlatform/LogoutServlet'">ログアウト</button></c:otherwise></c:choose>
 </div>
 
 <nav>
   <ul class = "nav_list overflow-wrap w-auto h-auto m-0">
      <li><a href = "/ExamPlatform/HomeServlet">ホーム</a>
      <li><a href = "/ExamPlatform/SearchServlet">試験検索</a>
      <li><a href = "/ExamPlatform/Game/Start">ゲーム</a>
      <li><a href = "/ExamPlatform/MypageServlet">マイページ</a>
   </ul> 
</nav>
 
</header>
 
 
 

