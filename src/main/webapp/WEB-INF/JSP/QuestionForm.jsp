<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.BigQuestion" %>
<%@ page import = "model.data.Question" %>
<%@ page import = "model.data.Choices" %>
<%@ page import = "java.util.List" %>

<%-- 小問 --%>  
<c:set var="bigQuestionNum" value="${param.bigQuestionNum}" />
<c:set var="questionNum" value="${param.questionNum}" />
<c:set var="bigQuestion" value="${ExamCreatePage.bigQuestionList[bigQuestionNum-1]}" />
<c:set var="question" value="${bigQuestion.questionList[questionNum-1]}" />

<div>
 <ul class = "B_question">
  <li><label for="s_toi"><c:choose><c:when test="${ExamCreatePage.entryExam.questionFormat==0}">＜設問<c:out value="${questionNum}"/>＞</c:when><c:otherwise>問<c:out value="${questionNum}"/>.</c:otherwise></c:choose></label></li><li>
    <textarea class="S_ques_area" required name="question" placeholder = "問題文を入力して下さい"><c:out value="${question.questionSentence}" /></textarea>
    <c:if test="questionNum != 1"><button type="button" onclick="rmQuestionForm(this)">−<c:choose><c:when test="${ExamCreatePage.entryExam.questionFormat==0}">設問</c:when><c:otherwise>問</c:otherwise></c:choose>を削除</button></c:if>
  </li>
  <li><textarea class="S_ques_area" name="questionExplanation" placeholder = "解説を入力して下さい(任意)"><c:out value="${question.questionExplanation}"/></textarea></li>
  <li>配点：<input type = "number" required name = "Score" step="any" value = <c:out value="${question.allocationOfPoint}">2</c:out>>点</li>
</ul>  
<%-- 選択 --%>
<div>
 <ul class = "B_question">
 
 <c:choose>
     <c:when test="${empty question}">
     	<li class = "Select">
    		<label><input type="radio" required name="Select_ans[<c:choose><c:when test="${ExamCreatePage.entryExam.questionFormat==0}">問<c:out value="${bigQuestionNum}"/>.</c:when><c:otherwise>小問</c:otherwise></c:choose>][<c:choose><c:when test="${ExamCreatePage.entryExam.questionFormat==0}">＜設問<c:out value="${questionNum}"/>＞</c:when><c:otherwise>問<c:out value="${questionNum}"/>.</c:otherwise></c:choose>]" value=1><span>1．</span></label>
  		    <input type="text" required class="Select_text" name="Select_text" />
  		</li>
  
 		 <li class = "Select">
    		<label><input type="radio" required name="Select_ans[<c:choose><c:when test="${ExamCreatePage.entryExam.questionFormat==0}">問<c:out value="${bigQuestionNum}"/>.</c:when><c:otherwise>小問</c:otherwise></c:choose>][<c:choose><c:when test="${ExamCreatePage.entryExam.questionFormat==0}">＜設問<c:out value="${questionNum}"/>＞</c:when><c:otherwise>問<c:out value="${questionNum}"/>.</c:otherwise></c:choose>]" value=2><span>2．</span></label>
  		    <input type="text" required class="Select_text" name="Select_text" />
  		</li>
     </c:when>
     <c:otherwise>
     	<c:forEach var="choices" items="${question.choicesList}">
     		<li class = "Select">
    		<label><input type="radio" required name="Select_ans[<c:choose><c:when test="${ExamCreatePage.entryExam.questionFormat==0}">問<c:out value="${bigQuestionNum}"/>.</c:when><c:otherwise>小問</c:otherwise></c:choose>][<c:choose><c:when test="${ExamCreatePage.entryExam.questionFormat==0}">＜設問<c:out value="${questionNum}"/>＞</c:when><c:otherwise>問<c:out value="${questionNum}"/>.</c:otherwise></c:choose>]" value=<c:out value="${choices.choicesID}"/> <c:if test="${choices.choicesID == question.answer}">checked="checked"</c:if>><span><c:out value="${choices.choicesID}"/>．</span></label>
    		<input type="text" required class="Select_text" name="Select_text" value=<c:out value="${choices.choices}"/> /> <c:if test="${choices.choicesID >= 2}"><button type="button" onclick="rmChoicesForm(this)">−選択肢を削除</button></c:if>
     	</c:forEach>
     </c:otherwise>
  </c:choose>
 
  <li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li>
 </ul>
</div>

<input type="hidden" name="choicesNum" value="<c:choose><c:when test="${empty question.choicesList}">2</c:when><c:otherwise><c:out value="${question.choicesList.size()}"/></c:otherwise></c:choose>">

</div>
