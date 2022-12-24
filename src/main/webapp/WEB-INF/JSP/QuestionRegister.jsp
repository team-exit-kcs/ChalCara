<%--問題登録フォーム --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.BigQuestion" %>
<%@ page import = "model.data.Question" %>
<%@ page import = "model.data.Choices" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
   
<!DOCTYPE html>

<c:set var="questionList" value="${ExamCreatePage.bigQuestionList[0].questionList}" />

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="/ExamPlatform/css/QuestionRegister.css">
</head>
<body>
<form action="/ExamPlatform/ExamCreateServlet/Question" method="post">
<h1>問題登録フォーム</h1>

<div class = "Bigquestion">
 <ul class = "B_question">
  <li><h2>小問</h2></li>
 </ul> 
 
<div>
<c:choose>
    <c:when test="${empty questionList}">
        <jsp:include page="./QuestionForm.jsp">
			<jsp:param name="bigQuestionNum" value = "1" />
			<jsp:param name="questionNum" value = "1" />
		</jsp:include>
    </c:when>
    <c:otherwise>
        <c:forEach var="q" items="${questionList}">
         	<jsp:include page="./BigQuestionForm.jsp">
		        <jsp:param name="bigQuestionNum" value = "1" />
		        <jsp:param name="questionNum" value = "${q.questionID}" />
	        </jsp:include>
	    </c:forEach>
    </c:otherwise>
</c:choose>

<span><br><button type="button" onclick="addQuestionForm(this)">＋小問を追加</button></span>
</div>

<input type="hidden" id="QNum" name="questionNum" value="<c:choose><c:when test="${empty questionList}">1</c:when><c:otherwise><c:out value="${questionList.size()}"/></c:otherwise></c:choose>">

<div class = "footer">
          <div class = "botton_area">
          <button type="button" id = "btn-back" class = "back" onclick="back()">戻る</button>
          <input type="submit" value = "登録確認画面へ" class = "ok"></input>
          </div>          
</div>
</div>
</form>
<script type="text/javascript">
         	function back(){
          		result=window.confirm("保存されていないデータは破棄されます");
          		if(result){
          			location.href='/ExamPlatform/ExamCreateServlet'
                }
            }
</script>
<script src="/ExamPlatform/js/choices.js"></script>
<script src="/ExamPlatform/js/Question.js"></script>
</body>
</html>