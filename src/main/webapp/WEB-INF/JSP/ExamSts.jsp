<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>統計</title>
</head>
<body>
<jsp:include page="./header.jsp" />
<h1>統計情報</h1>

<div class="container-fluid">
  <div class="row">
    <div class="col-4 mt-5">
    	<h2>基本情報</h2>
    	<div class="card">
       		<div class="card-body">
        		<h4 class="card-title">試験名</h4>
          		<p class="card-text"><c:out value="${ExamSts.exam.examName}"/></p>
          		
          		<h4 class="card-title">試験ID</h4>
          		<p class="card-text"><c:out value="${ExamSts.exam.examID}"/></p>
          		
          		<h4 class="card-title">ジャンル名</h4>
          		<p class="card-text"><c:out value="${ExamSts.exam.genreName}"/></p>
          		
          		<h4 class="card-title">タグ</h4>
          		<p class="card-text">
          			<c:forEach var="Tag" items="${ExamSts.exam.tagList}">
						<span>
							<c:out value="${Tag}"/>
						</span>
					</c:forEach>
          		</p>
          		
          		<h4 class="card-title">合格点</h4>
          		<p class="card-text"><c:out value="${ExamSts.exam.passingScore}"/></p>
          		
          		<h4 class="card-title">試験時間</h4>
          		<p class="card-text"><c:out value="${ExamSts.exam.examTime}"/></p>
          		
          		<h4 class="card-title">ブックマーク数</h4>
          		<p class="card-text"><c:out value="${ExamSts.exam.bookmarkCount}"/></p>
          		
          		<h4 class="card-title">受験者数</h4>
          		<p class="card-text"><c:out value="${ExamSts.exam.exeCount}"/></p>
        	</div>
        </div>
    </div>
    
    <div class="col-8 mt-5">
    	<h2>受験情報</h2>
    	<div class="card">
       		<div class="card-body">
       			<h4 class="card-title">受験情報提供者数</h4>
    			<p class="card-text"><c:out value="${ExamSts.infoUserCnt}"/></p>
    			
    			<h4 class="card-title">平均受験時間</h4>
    			<p class="card-text"><c:out value="${ExamSts.avgTime}"/>分</p>
    			
    			<h4 class="card-title">平均点</h4>
    			<p class="card-text"><c:out value="${ExamSts.avgScore}"/>点</p>
    		</div>
    		<div>
    		<c:choose>
			<c:when test="${ExamSts.exam.questionFormat == 0}"><jsp:include page="./BSts.jsp" /></c:when>
			<c:when test="${ExamSts.exam.questionFormat == 1}"><jsp:include page="./SSts.jsp" /></c:when>
			</c:choose>
    		</div>
    	</div>
    	<p>最終更新日(<c:out value="${ExamSts.exam.updateDate}"/>)以降の情報が表示されます<br>試験を更新した場合、取得した情報はリセットされます</p>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>