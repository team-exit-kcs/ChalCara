<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div style="text-align: center">
	<ul class="nav nav-tabs">
	<c:forEach var="BQ" items="${ExamSts.bqStsList}" varStatus="sts">
        <li class="nav-item">
         	<a href="#BQ<c:out value="${BQ.bigQuestionID}"/>" class="nav-link<c:if test="${sts.first}"> active</c:if>" data-bs-toggle="tab">問<c:out value="${BQ.bigQuestionID}"/></a>
        </li>
	</c:forEach>
	</ul>
	
	<div class="tab-content">
	<c:forEach var="BQ" items="${ExamSts.bqStsList}" varStatus="sts">
    <div id="BQ<c:out value="${BQ.bigQuestionID}"/>" class="tab-pane<c:if test="${sts.first}"> active</c:if>">
    <h4>問<c:out value="${BQ.bigQuestionID}"/></h4>
    <p><c:out value="${BQ.bigQuestionSentence}"/></p><br>
	<table class="table table-bordered">
		<tr>
			<th>問題番号</th>
			<th>問題文</th>
			<th>配点</th>
			<th>答え</th>
			<th>選択肢</th>
			<th>選択者数</th>
			<th>選択率</th>
		</tr>

		<c:forEach var="Q" items="${BQ.questionStsList}">
			<tr>
				<td rowspan="<c:out value="${Q.choicesList.size() + 1}"/>"><c:out value="${Q.questionID}"/></td>
				
				<td rowspan="<c:out value="${Q.choicesList.size() + 1}"/>">
				<c:out value="${Q.questionSentence}"/>
				<details>
   					<summary>解説</summary>
    				<c:out value="${Q.questionExplanation}"/>
				</details>
				</td>
				
				<td rowspan="<c:out value="${Q.choicesList.size() + 1}"/>"><c:out value="${Q.allocationOfPoint}"/></td>
				<td rowspan="<c:out value="${Q.choicesList.size() + 1}"/>"><c:out value="${Q.answer}"/></td>
			</tr>
			<c:forEach var="C" items="${Q.choicesList}">
				<tr>
					<td><c:out value="${C.chioces.choicesID}"/>. <c:out value="${C.chioces.choices}"/></td>
					<td><c:out value="${C.ansCnt}"/></td>
					<td><c:out value="${C.selectRate}"/>％</td>
				</tr>
			</c:forEach>
			
		</c:forEach>
	</table>
	</div>
	</c:forEach>
	</div>
</div>