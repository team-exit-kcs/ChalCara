<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="./title.jsp"/>
<link rel="stylesheet" href="/ExamPlatform/css/Home.css">
<link rel="stylesheet" href="/ExamPlatform/css/BulletinBoard.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<jsp:include page="./header.jsp" />
<main id = "Main_Home">
<jsp:include page="./BulletinBoard.jsp" />
</main>
</body>
</html>