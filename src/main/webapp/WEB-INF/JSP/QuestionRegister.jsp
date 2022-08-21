<%--問題登録フォーム --%>

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
     	List<Question> questionList = new ArrayList<>();
     	if(!bigQuestionList.isEmpty()){
        	questionList = bigQuestionList.get(0).getQuestionList();
     	}
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

 <%if(questionList.isEmpty()){ %>
	<jsp:include page="./QuestionForm.jsp">
		<jsp:param name="bigQuestionNum" value = "1" />
		<jsp:param name="questionNum" value = "1" />
	</jsp:include>
 <%
 }else{
 	for(Question q : questionList){
 %>
 	<jsp:include page="./QuestionForm.jsp">
 		<jsp:param name="bigQuestionNum" value = "1" />
		<jsp:param name="questionNum" value = "<%= q.getQuestionID() %>" />
	</jsp:include>
 <%}}%>

<span><br><button type="button" onclick="addQuestionForm(this)">＋小問を追加</button></span>
</div>

<div class = "footer">
          <div class = "botton_area">
          <button type="button" id = "btn-back" class = "back" onclick="back()">戻る</button>
          <input type="submit" value = "登録確認画面へ" class = "ok"></input>
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
<script src="./js/choices.js"></script>
<script src="./js/Question.js"></script>
</body>
</html>