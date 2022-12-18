<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div style="text-align: center">
	<c:set var="BQ" value="${ExamSts.bqStsList[0]}" />
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