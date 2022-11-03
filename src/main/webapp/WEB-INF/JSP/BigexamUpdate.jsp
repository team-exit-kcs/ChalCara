<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.ExaminationPage" %>
<%@ page import = "model.data.Question" %>
<%@ page import = "model.data.Choices" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="/ExamPlatform/css/QuestionRegister.css">
</head>
<body>
<form action="/ExamPlatform/ExamCreateServlet/BigQuestion" method="post">
<h1>問題更新フォーム</h1>
<div>

<c:forEach var="bq" items="${ExaminationPage.bigQuestionList}">
     <jsp:include page="./BigQuestionUpdateForm.jsp">
          <jsp:param name="bigQuestionNum" value = "${bq.bigQuestionID}" />
          <jsp:param name="questionFormat" value = "0" />
     </jsp:include>
</c:forEach>

<span><br><button type="button" onclick="addBigQuestionForm(this)">＋大問を追加</button></span>
</div>

<input type="hidden" id="BQNum" name="bigQuestionNum" value="<c:choose><c:when test="${empty ExaminationPage.exam}">1</c:when><c:otherwise><c:out value="${Examination.bigQuestionList.size()}"/></c:otherwise></c:choose>">
<div class = "footer">
          <div class = "botton_area">
          <input type="submit" value = "更新" class = "ok"></input>
          </div>          
</div>
</form>

<script type="text/javascript">
			function getSelectBigQ(){
				return document.getElementById('select-bq').value;
			}

         	function back(){
          		location.href='/ExamPlatform//ExamCreateServlet'<%--passを後々変更する --%>
            }
</script>
<script src="/ExamPlatform/js/choices.js"></script>
<script src="/ExamPlatform/js/BigQuestion.js"></script>
</body>
</html>