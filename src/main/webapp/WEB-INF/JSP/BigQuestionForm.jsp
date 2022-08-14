<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.BigQuestion" %>
<%@ page import = "model.data.Question" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
    
     <% 
     	ExamCreatePage pageData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
    	int bigQuestionNum = Integer.parseInt(request.getParameter("bigQuestionNum"));
     	int questionFormat = Integer.parseInt(request.getParameter("questionFormat"));
     	List<BigQuestion> bigQuestionList = pageData.getBigQuestionList();
     	BigQuestion bigQuestion = null;
     	List<Question> questionList = new ArrayList<>();
     	if(bigQuestionList.size() >= (bigQuestionNum-1)){
     		bigQuestion = bigQuestionList.get(bigQuestionNum-1);
        	questionList = bigQuestion.getQuestionList();
     	}
      %>

<!DOCTYPE html>

<%-- 大問 --%>
<div class = "Bigquestion">
 <ul class = "B_question">
 
  <li>
    <label for="b_toi">問<%= bigQuestionNum %>.</label>
    <textarea id="B_ques_area" name="quesution" placeholder = "問題文を入力して下さい"><%= bigQuestion==null ? "" : bigQuestion.getBigQuestionSentence() %></textarea>
  </li>
 </ul> 
<div>
 <%if(questionList.isEmpty()){ %>
	<jsp:include page="./QuestionForm.jsp">
		<jsp:param name="questionNum" value = "<%= bigQuestionNum %>" />
		<jsp:param name="bigQuestionNum" value = "1" />
	</jsp:include>
 <%
 }else{
 	for(Question q : questionList){
 %>
 	<jsp:include page="./QuestionForm.jsp">
 		<jsp:param name="bigQuestionNum" value = "<%= bigQuestionNum %>" />
		<jsp:param name="questionNum" value = "<%= q.getQuestionID() %>" />
	</jsp:include>
 <%}}%>
 
 <br><button type="button" onclick="addQuestionForm(this)">＋設問を追加</button>
</div>
</div>