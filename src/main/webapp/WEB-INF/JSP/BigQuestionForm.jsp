<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.ExaminationPage" %>
<%@ page import = "model.data.BigQuestion" %>
<%@ page import = "model.data.Question" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>

<!DOCTYPE html>

<c:set var="bigQuestionNum" value="${param.bigQuestionNum}" />
<c:set var="bigQuestion" value="${ExamCreatePage.bigQuestionList[bigQuestionNum-1]}" />

<%-- 大問 --%>
<div class = "Bigquestion">
 <ul class = "B_question">
  <li><label for="b_toi">問<c:out value="${bigQuestionNum}" />.</label></li>
  <li>
    <textarea id="B_ques_area" required name="Bquestion" placeholder = "問題文を入力して下さい"><c:out value="${bigQuestion.bigQuestionSentence}" /></textarea>
    <c:if test="${bigQuestionNum != 1}"><button type="button" onclick="rmBigQuestionForm(this)">−大問を削除</button></c:if>
  </li>
 </ul> 
<div>
<c:choose>
	<c:when test="${empty bigQuestion.questionList}">
		<jsp:include page="./QuestionForm.jsp">
			<jsp:param name="bigQuestionNum" value = "${bigQuestionNum}" />
			<jsp:param name="questionNum" value = "1" />
		</jsp:include>
	</c:when>
	<c:otherwise>
		<c:forEach var="q" items="${bigQuestion.questionList}">
			<jsp:include page="./QuestionForm.jsp">
 				<jsp:param name="bigQuestionNum" value = "${bigQuestionNum}" />	
				<jsp:param name="questionNum" value = "${q.questionID}" />
			</jsp:include>
		</c:forEach>
	</c:otherwise>
</c:choose>
 
 <span><br><button type="button" onclick="addQuestionForm(this)">＋設問を追加</button></span>
</div>

<input type="hidden" name="questionNum" value="<c:choose><c:when test="${empty bigQuestion.questionList}">1</c:when><c:otherwise><c:out value="${bigQuestion.questionList.size()}"/></c:otherwise></c:choose>">
</div>