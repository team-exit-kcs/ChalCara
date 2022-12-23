<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.ExaminationPage" %>
<%@ page import = "model.data.BigQuestion" %>
<%@ page import = "model.data.Question" %>
<%@ page import = "model.data.Choices" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
   
<!DOCTYPE html>

<c:set var="questionList" value="${ExamUpdatePage.bigQuestionList[0].questionList}" />

<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="/ExamPlatform/css/QuestionRegister.css">
</head>
<body>
<form action="/ExamPlatform/UpdExam/Question" method="post">
<input type="hidden" id="examID" name="examID" value=<c:out value="${ExamUpdatePage.exam.examID}" />>
<h1>問題更新フォーム</h1>

<div class = "Bigquestion">
 <ul class = "B_question">
  <li><h2>小問</h2></li>
 </ul> 
 
<div>
<c:choose>
    <c:when test="${empty questionList}">
        <jsp:include page="./QuestionUpdateForm.jsp">
			<jsp:param name="bigQuestionNum" value = "1" />
			<jsp:param name="questionNum" value = "1" />
		</jsp:include>
    </c:when>
    <c:otherwise>
        <c:forEach var="q" items="${questionList}">
         	<jsp:include page="./BigQuestionUpdateForm.jsp">
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
          <input type="submit" value = "更新確認画面へ" class = "ok"></input>
          </div>
<span><a href="/ExamPlatform/UpdExam/Overview?examID=<c:out value="${ExamUpdatePage.exam.examID}"/>">試験更新</a></span><br>  
</div>
</div>
</form>
<script type="text/javascript">
         	function back(){
          		let examID = document.getElementById("examID").value;
          		location.href='/ExamPlatform/ExaminationServlet?examID=' + examID;
            }
</script>
<script src="/ExamPlatform/js/choices.js"></script>
<script src="/ExamPlatform/js/Question.js"></script>
</body>
</html>