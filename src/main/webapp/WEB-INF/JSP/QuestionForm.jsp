<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.BigQuestion" %>
<%@ page import = "model.data.Question" %>
<%@ page import = "model.data.Choices" %>
<%@ page import = "java.util.List" %>
    
     <% 
     	ExamCreatePage pageData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
    	int bigQuestionNum = Integer.parseInt(request.getParameter("bigQuestionNum"));
     	int questionNum = Integer.parseInt(request.getParameter("questionNum"));
     	int questionFormat = pageData.getQuestionFormat();
     	Question question = null;
     	if(!pageData.getBigQuestionList().isEmpty()){
     		BigQuestion bq = pageData.getBigQuestionList().get(bigQuestionNum-1);
     		question = bq.getQuestionList().get(questionNum-1);
     	}
      %>

<%-- 小問 --%>  

<div>
 <ul class = "B_question">
  <li><label for="s_toi"><%= questionFormat==0 ? "＜設問" + questionNum + "＞" : "問" + questionNum + "."%></label></li>
  <li>
    <textarea class="S_ques_area" required name="question" placeholder = "問題文を入力して下さい"><%= question == null ? "" : question.getQuestionSentence() %></textarea>
    <%= questionNum == 1 ? "" : "<button type=\"button\" onclick=\"rmQuestionForm(this)\">−" + (questionFormat==0 ? "設問" : "問") + "を削除</button>" %>
  </li>
  <li><textarea class="S_ques_area" name="questionExplanation" placeholder = "解説を入力して下さい(任意)"><%= question == null ? "" : question.getQuestionExplanation() %></textarea></li>
  <li>配点：<input type = "number" required name = "Score" step="0.5" <%= question == null ? "value = 2" : "value = \""+question.getAllocationOfPoint()+"\""%>>点</li>
</ul>  
<%-- 選択 --%>
<div>
 <ul class = "B_question">
 
 <%if(question == null){ %>
 
  <li class = "Select">
    <label><input type="radio" required name="Select_ans[<%= questionFormat==0 ? "問" + bigQuestionNum + "." : "小問"%>][<%= questionFormat==0 ? "＜設問" + questionNum + "＞" : "問" + questionNum + "."%>]" value=1><span>1．</span></label>
    <input type="text" required class="Select_text" name="Select_text" />
  </li>
  
  <li class = "Select">
    <label><input type="radio" required name="Select_ans[<%= questionFormat==0 ? "問" + bigQuestionNum + "." : "小問"%>][<%= questionFormat==0 ? "＜設問" + questionNum + "＞" : "問" + questionNum + "."%>]" value=2><span>2．</span></label>
    <input type="text" required class="Select_text" name="Select_text" />
  </li>
 <%
 }else{
 	for(Choices choices : question.getChoicesList()){
 %>
 
  <li class = "Select">
    <label><input type="radio" required name="Select_ans[<%= questionFormat==0 ? "問" + bigQuestionNum + "." : "小問"%>][<%= questionFormat==0 ? "＜設問" + questionNum + "＞" : "問" + questionNum + "."%>]" value=<%= choices.getChoicesID() %> <%= choices.getChoicesID()==question.getAnswer() ? "checked=\"checked\"" : ""%>><span><%= choices.getChoicesID() %>．</span></label>
    <input type="text" required class="Select_text" name="Select_text" value=<%= choices.getChoices() %> /><%= choices.getChoicesID() <= 2 ? "" : "<button type=\"button\" onclick=\"rmChoicesForm(this)\">−選択肢を削除</button>" %>
  </li>

 <%}}%>
 
  <li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li>
 </ul>
</div>

<input type="hidden" name="choicesNum" value="<%= question == null ? "2" : question.getChoicesList().size() %>">

</div>
