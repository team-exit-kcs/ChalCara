<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.BigQuestion" %>
<%@ page import = "model.data.Question" %>
<%@ page import = "model.data.Choices" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>

     <% 
     	ExamCreatePage pageData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
     	List<BigQuestion> bigQuestionList = pageData.getBigQuestionList();
      %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="./css/QuestionRegister.css">
</head>
<body>
<form action="/ExamPlatform/ExamCreateServlet/Question" method="post">
<h1>問題登録フォーム</h1>
<div>

 <%if(bigQuestionList.isEmpty()){ %>
	<jsp:include page="./BigQuestionForm.jsp">
		<jsp:param name="bigQuestionNum" value = "1" />
		<jsp:param name="questionFormat" value = "0" />
	</jsp:include>
 <%
 }else{
	 for(BigQuestion bq : bigQuestionList){
 %>
 	<jsp:include page="./BigQuestionForm.jsp">
		<jsp:param name="bigQuestionNum" value = "<%= bq.getBigQuestionID() %>" />
		<jsp:param name="questionFormat" value = "0" />
	</jsp:include>
 <%}}%>

<span><br><button type="button" onclick="addBigQuestionForm(this)">＋大問を追加</button></span>
</div>
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
<script src="./js/choices.js"></script>
<script src="./js/BigQuestion.js"></script>
</body>
</html>