<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>試験概要</title>
</head>
<body>
	<div style="text-align: center; font-size: xx-large">
		<span style="font-weight: bold">
			試験名：
		</span>
		
		<span>
			<c:out value="${pageData.exam.examName}"/>
		</span>
	</div>

	<div>
		試験ID:
		<span>
			<c:out value="${pageData.exam.examID}"/>
		</span>
	</div>
	
	<div style="text-align: center;">
		製作者ユーザID：
		<span>
			<c:out value="${pageData.exam.userID}"/>
		</span>
	</div>
	<br>
	<c:if test="${LoginUser.userID == pageData.exam.userID}">
	<div class = "createUser" style="text-align: right;">
		<span><a href="/ExamPlatform/ExamStatsServlet?examID=<c:out value="${pageData.exam.examID}"/>">統計</a></span><br>
		<span><a href="/ExamPlatform/UpdExam/Overview?examID=<c:out value="${pageData.exam.examID}"/>">試験更新</a></span><br>
		<span><a href="/ExamPlatform/UpdExam/Question?examID=<c:out value="${pageData.exam.examID}"/>">試験問題更新</a></span>
	</div>
	</c:if>
	<br>
	
	<div style="text-align: center">
		試験作成日：
		<span>
			<c:out value="${pageData.exam.createDate}"/>
		</span><br>
		
		更新日：
		<span>
			<c:out value="${pageData.exam.updateDate}"/>
		</span>
	</div>
	<br>
	
	<div style="text-align: center;">
		ジャンル名：
		<span>
			<c:out value="${pageData.exam.genreName}"/>
		</span>
	</div>
	
	<div style="text-align: center;">
		タグ：
		<c:forEach var="Tag" items="${pageData.exam.tagList}">
			<span>
				<c:out value="${Tag}"/>
			</span>
		</c:forEach>
	</div>
  
	<div style="text-align: center;">
		ブックマーク数：
		<span>
			<c:out value="${pageData.exam.bookmarkCount}"/>
		</span>
		<c:if test="${not empty LoginUser}"><button onclick="location.href='/ExamPlatform/BookmarkServlet?examID=<c:out value="${pageData.exam.examID}"/>'"><c:choose><c:when test="${pageData.bookmark}">ブックマークを外す</c:when><c:otherwise>ブックマーク</c:otherwise></c:choose></button></c:if>
	</div>
	<br>
	
	<div style="text-align: center; border: 1px solid black">
		<h2>試験概要</h2>
		<p>
			<c:out value="${pageData.exam.examExplanation}"/>
		</p>
	</div>
	<br>
	
	<div style="text-align: center; font-weight: bold">
		実行回数：
		<span>
			<c:out value="${pageData.exam.exeCount}" />
		</span>
	</div>
	
	<div  style="font-weight: bold; color: red; text-align: center;">
		合格点：
		<span>
			<c:out value="${pageData.exam.passingScore}"/>
		</span>
	</div>
	
	<div style="text-align: center">
		<div  style="font-weight: bold">
			試験時間：
			<span>
				<c:out value="${pageData.exam.examTime}"/>
			</span>
		</div>
		<br>
		<div>
			<form action="/ExamPlatform/ConductTheExamServlet" method="post">
			<c:if test="${not empty LoginUser}">
				<label>
    				<input type="checkbox" id="useInfo" name="useInfo" value="true" <c:if test="${LoginUser.useInfoDefault}">checked="checked"</c:if>>
  					 	受験情報を試験作成者に送信する
				</label><br>
			</c:if>
			<input type="submit" value="試験開始">
			</form>
		</div>
	</div>
</body>
</html>