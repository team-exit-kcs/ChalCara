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
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="/ExamPlatform/css/QuestionRegister.css">
</head>
<body>
<form action="/ExamPlatform/ExamCreateServlet/BigQuestion" method="post">
<h1>問題登録フォーム</h1>
<div>

<c:choose>
    <c:when test="${empty ExamCreatePage.bigQuestionList}">
        <jsp:include page="./BigQuestionForm.jsp">
		    <jsp:param name="bigQuestionNum" value = "1" />
		    <jsp:param name="questionFormat" value = "0" />
	    </jsp:include>
    </c:when>
    <c:otherwise>
        <c:forEach var="bq" items="${ExamCreatePage.bigQuestionList}">
         	<jsp:include page="./BigQuestionForm.jsp">
		        <jsp:param name="bigQuestionNum" value = "${bq.bigQuestionID}" />
		        <jsp:param name="questionFormat" value = "0" />
	        </jsp:include>
	    </c:forEach>
    </c:otherwise>
</c:choose>

<span><br><button type="button" onclick="addBigQuestionForm(this)">＋大問を追加</button></span>
</div>

<input type="hidden" id="BQNum" name="bigQuestionNum" value="<c:choose><c:when test="${empty ExamCreatePage.bigQuestionList}">1</c:when><c:otherwise><c:out value="${ExamCreatePage.bigQuestionList.size()}"/></c:otherwise></c:choose>">
<div class = "footer">
          <div class = "botton_area">
          <button type="button" id = "btn-back" class = "back" onclick="back()">戻る</button>
          <input type="submit" value = "登録確認画面へ" class = "ok"></input>
          </div>          
</div>
</form>

<script type="text/javascript">
			function getSelectBigQ(){
				return document.getElementById('select-bq').value;
			}

         	function back(){
          		result=window.confirm("保存されていないデータは破棄されます");
          		if(result){
          			location.href='/ExamPlatform//ExamCreateServlet'
                }
            }
</script>
<script src="/ExamPlatform/js/choices.js"></script>
<script src="/ExamPlatform/js/BigQuestion.js"></script>
</body>
</html>