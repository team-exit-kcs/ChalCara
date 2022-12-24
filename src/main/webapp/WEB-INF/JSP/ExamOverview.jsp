<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.Genre" %>
<%@ page import = "model.data.EntryExam" %>
<%@ page import = "java.util.List" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/ExamOverview.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<jsp:include page="./title.jsp" />
</head>
<body>
<main>

<div id = "main_box" class = "container">

<div class = "d-flex row">
<div class = "col-2"></div>
<div class = "col-8">
<form action="/ExamPlatform/ExamCreateServlet" method="post">
<div class = "text-center"><h1 id = "mi">試験概要入力フォーム</h1></div>
   <div class="form-group"><label for = "e_Name">試験名：<input type = "text" class="form-control" required name = "examName" placeholder = "examName" <c:if test="${not empty ExamCreatePage.entryExam}">value = <c:out value="${ExamCreatePage.entryExam.examName}" /></c:if>></label></div>

          <div class="form-group">
               <label for = "genre" >ジャンル：
               <c:forEach var="genre" items="${ExamCreatePage.genreList}">
               		<input type = "radio" name = "genre" required value = <c:out value="${genre.genreID}" /> <c:if test="${genre.genreID==ExamCreatePage.entryExam.genreID}">checked="checked"</c:if>><c:out value="${genre.genreName}" />
               </c:forEach>
               </label>
          </div>
          
          <datalist id="TagList">
          <c:forEach var="tag" items="${ExamCreatePage.tagList}">
               	<option><c:out value="${tag}" /></option>
          </c:forEach>
          </datalist>
          <div class = "tag form-group">
               <label for = "tag" id = "tagForm">タグ　：
               <c:choose>
                   <c:when test="${empty ExamCreatePage.entryExam.tagList}"><span><input type = "text" class="form-control" name = "tag" class = "text" list = "TagList"></span></c:when>
                   <c:otherwise>
                       <c:forEach var="eTag" items="${ExamCreatePage.entryExam.tagList}" varStatus="sts">
                    
                           <c:choose>
                               <c:when test="${sts.first}"><span><input type = "text" name = "tag" class = "text form-control" list = "TagList" value = <c:out value="${eTag}" />></span></c:when>
                               <c:otherwise><span><br><input type = "text" class = "text form-control" name = "tag"  list = "TagList" value = <c:out value="${eTag}" />><button type="button" class = "btn-rmTagForm add_drop border-0 btn-outline-primary" onclick="rmTagForm (this)">-削除</button></span></c:otherwise>
                           </c:choose>
                      
                       </c:forEach>
                   </c:otherwise>
               </c:choose>
              
               </label>
               <br><button type="button" id="btn-addTagForm" class = "add_drop border-0 btn-outline-primary" onclick="addTagForm()">＋追加</button>
          </div>
          
          <div class = "form-group">
               <label for = "OpenRange" >公開範囲：
               <input type = "radio" name = "OpenRange" value = "0" required onchange = "change()" <c:if test="${ExamCreatePage.entryExam.disclosureRange==0}">checked="checked"</c:if> id = "radio-open">公開
               <input type = "radio" name = "OpenRange" value = "1" required onchange = "change()" <c:if test="${ExamCreatePage.entryExam.disclosureRange==1}">checked="checked"</c:if> id = "radio-limited">限定公開
               <input type = "radio" name = "OpenRange" value = "2" required onchange = "change()" <c:if test="${ExamCreatePage.entryExam.disclosureRange==2}">checked="checked"</c:if>>非公開<br>
               </label>
          </div>
          <div id = "Ques_for" class = "tag form-group">
               <label for="QuestionFormat">問題形式：</label>
               <label><input type="radio" value = "0" onchange = "useGameCheckboxCtl();" required name="QuestionFormat" <c:if test="${ExamCreatePage.entryExam.questionFormat==0}">checked="checked"</c:if>>大問</label>
               <label><input type="radio" value = "1" onchange = "useGameCheckboxCtl();" name="QuestionFormat" id = "radio-question" <c:if test="${ExamCreatePage.entryExam.questionFormat==1}">checked="checked"</c:if>>小問</label>
          </div>
          
          <div class = "form-group"><label for = "e_Time">試験時間：<input type = "number" required name = "examTime" min = 1 <c:if test="${not empty ExamCreatePage.entryExam}">value = <c:out value="${ExamCreatePage.entryExam.examTime}" /></c:if>>分</label></div>
          
          <div class = "form-group"><label for = "e_score">合格点：<input type = "number" required name = "passingScore" min = 1 <c:if test="${not empty ExamCreatePage.entryExam}">value = <c:out value="${ExamCreatePage.entryExam.passingScore}" /></c:if>>点</label></div>
          
          <div class = "tag form-group">
               <label for = "Explanation">説明文：</label>
               <textarea name = "Explanation" class = "form-control" placeholder = "試験概要を説明して下さい"><c:out value="${ExamCreatePage.entryExam.examExplanation}" /></textarea>
          </div>
          
          <div class = "tag form-group">
  			<label>
    			<input type="checkbox" id="useGame" name="useGame" value="true" <c:if test="${ExamCreatePage.entryExam.useGame}">checked="checked"</c:if>>
   				ゲームの問題としての使用を許可する
   				(小問形式かつ公開設定の場合のみ選択できます)
  			</label>
          </div>
          
          <div id = "botton_area" class = "d-flex justify-content-center row">
          
          <div class = "row justify-content-center">
          <div class = "col-auto">
          <button type="button" id = "btn-back" class = "btn btn-outline-primary btn-block" onclick="back()">戻る</button>
          </div>
          <div class = "col-auto">
          <input type="submit" value = "ＯＫ" class = "btn btn-outline-primary btn-block"></input>
          </div>
          </div>
          
          </div>
          
          <script src="./js/tag.js"></script>
          <script src="./js/useGame.js"></script>
          <script src="./js/openRange.js"></script>
          <script type="text/javascript">
          	change();
          	
          	function change(){
           		LimitedPassForm();
         		useGameCheckboxCtl();
          	}
            
         	function back(){
          		result=window.confirm("入力した情報は保存されません");
          		if(result){
          			location.href='/ExamPlatform/MypageServlet'
                }
            }
          </script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</form>
</div>
<div class = "col-2"></div>
</div>

</div>
</main>
</body>
</html>