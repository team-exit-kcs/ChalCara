<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/BulletinBoard.css">
<jsp:include page="./title.jsp" />
</head>
<body>
<jsp:include page="./header.jsp" />

<main>

<h2>掲示板</h2>
<%int i;
  
  for(i=0;i<=19;i++){
%>
<p id = "Record"> yyyy/mm/dd　　　UserID　　　　　　　　　<a href = "#" id = "exam">examname</a></p>
<%}%>

<%
  int j = 1;
  if(i <= 19){
	  j = j + 1;
	  i = 0 ;
  } 
%>
<a href = "#"><%=j%></a>
</main>
<jsp:include page="./footer.jsp" />
</body>
</html>