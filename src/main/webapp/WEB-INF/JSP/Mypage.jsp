<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/Mypage.css">
<link rel="stylesheet" href="./css/ress.css">
<jsp:include page="./title.jsp" />
</head>
<body>
<main>
<jsp:include page="./header.jsp" />
<h2 class="mi_1">マイページ</h2>

<div class = "root_1">

<div class="r1_item_1">
  <span>
    <img src="./img/kari.png" height="220" width="220" alt="User Icon">
  </span>
  </div>
<div class="r1_item_2">
    <p>ユーザID(Servlet)</p>
</div>
<div class="r1_item_3">
    <p>自己紹介(Servlet)</p>
</div>

</div>

<h2 class="mi_2">IBT作成一覧</h2>

<div class="root_2">
<div>

</div>
</div>

</main>
</body>
</html>