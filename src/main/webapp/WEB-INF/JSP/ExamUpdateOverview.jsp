<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "model.data.ExamUpdatePage" %>
<%@ page import = "model.data.Genre" %>
<%@ page import = "model.data.Exam" %>
<%@ page import = "java.util.List" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/ExamOverview.css">
<jsp:include page="./title.jsp" />
</head>
<body>
<main>

<div class = "main">

<form action="/ExamPlatform/ExamCreateServlet" method="post">
<h1 class = "mi_1">試験概要更新フォーム</h1>
   <div><label for = "e_Name">試験名：<input type = "text" required name = "examName" placeholder = "examName" <c:if test="${not empty ExamUpdatePage.exam}">value = <c:out value="${ExamUpdatePage.exam.examName}" /></c:if>></label></div>

          <div>
               <label for = "genre" >ジャンル：
               <c:forEach var="genre" items="${ExamUpdatePage.genreList}">
               		<input type = "radio" name = "genre" required value = <c:out value="${genre.genreID}" /> <c:if test="${genre.genreID==ExamUpdatePage.exam.genreID}">checked="checked"</c:if>><c:out value="${genre.genreName}" />
               </c:forEach>
               </label>
          </div>
          
          <datalist id="TagList">
          <c:forEach var="tag" items="${ExamUpdatePage.tagList}">
               	<option><c:out value="${tag}" /></option>
          </c:forEach>
          </datalist>
          <div class = "tag">
               <label for = "tag" id = "tagForm">タグ：
               <c:choose>
                   <c:when test="${empty ExamUpdatePage.exam.tagList}"><span><input type = "text" name = "tag" class = "text" list = "TagList"></span></c:when>
                   <c:otherwise>
                       <c:forEach var="eTag" items="${ExamUpdatePage.exam.tagList}" varStatus="sts">
                           <c:choose>
                               <c:when test="${sts.first}"><span><input type = "text" name = "tag" class = "text" list = "TagList" value = <c:out value="${eTag}" />></span></c:when>
                               <c:otherwise><span><br><input type = "text" name = "tag" class = "text" list = "TagList" value = <c:out value="${eTag}" />><button type="button" class="btn-rmTagForm" onclick="rmTagForm(this)">-削除</button></span></c:otherwise>
                           </c:choose>
                       </c:forEach>
                   </c:otherwise>
               </c:choose>
              
               </label>
               <br><button type="button" id="btn-addTagForm" onclick="addTagForm()">＋追加</button>
          </div>
          
          <div>
               <label for = "OpenRange" >公開範囲：
               <input type = "radio" name = "OpenRange" value = "0" required onchange = "LimitedPassForm()" <c:if test="${ExamUpdatePage.exam.disclosureRange==0}">checked="checked"</c:if>>公開
               <input type = "radio" name = "OpenRange" value = "1" required onchange = "LimitedPassForm()" <c:if test="${ExamUpdatePage.exam.disclosureRange==1}">checked="checked"</c:if> id = "radio-limited">限定公開
               <input type = "radio" name = "OpenRange" value = "2" required onchange = "LimitedPassForm()" <c:if test="${ExamUpdatePage.exam.disclosureRange==2}">checked="checked"</c:if>>非公開
               </label>
          </div>
          
          <div id = "Ques_for">
               <label for="QuestionFormat">問題形式：</label>
               <label><input type="radio" value = "0" required name="QuestionFormat" <c:if test="${ExamUpdatePage.questionFormat==0}">checked="checked"</c:if>>大問</label>
               <label><input type="radio" value = "1" name="QuestionFormat"  <c:if test="${ExamUpdatePage.questionFormat==1}">checked="checked"</c:if>>小問</label>
          </div>
          
          <div><label for = "e_Time">試験時間：<input type = "number" required name = "examTime" min = 1 <c:if test="${not empty ExamUpdatePage.exam}">value = <c:out value="${ExamUpdatePage.exam.examTime}" /></c:if>>分</label></div>
          
          <div><label for = "e_score">合格点：<input type = "number" required name = "passingScore" min = 1 <c:if test="${not empty ExamUpdatePage.exam}">value = <c:out value="${ExamUpdatePage.exam.passingScore}" /></c:if>>点</label></div>
          
          <div>
               <label for = "Explanation">説明文：</label>
               <textarea name = "Explanation" placeholder = "試験概要を説明して下さい"><c:out value="${ExamUpdatePage.exam.examExplanation}" /></textarea>
          </div>
          
          <div class = "footer">
          
          <div class = "botton_area">
          <button type="button" id = "btn-back" class = "back" onclick="back()">戻る</button>
          <input type="submit" value = "ＯＫ" class = "ok"></input>
          </div>
          
          </div>
          
          <script src="./js/tag.js"></script>
          <script type="text/javascript">
 // /*         
          function LimitedPassForm(){
        		let limited = document.getElementById("radio-limited");
        		if(limited.checked && document.getElementById("limitedPassForm") == null){
        			let limitedPassHtml = '<span><br>限定公開パスワード： <input type = "password" name = "limitedPASS" class = "text" id = "limitedPassForm"><span><br>';
        			limited.parentNode.insertAdjacentHTML("beforeend",limitedPassHtml);
        			let limitedUpdatePass = '<a href ="#" id = "pass_reset" >PASS設定</a>';
        			limited.parentNode.insertAdjacentHTML("beforeend",limitedUpdatePass);
        			
        		}else if(!limited.checked && document.getElementById("limitedPassForm") != null){
        			span = document.getElementById("limitedPassForm").parentNode;
        			span.remove();
        			a = document.getElementById("pass_reset");
        			a.remove();
        		}
        	}
//	*/
          
            LimitedPassForm();
            
         	function back(){
          		result=window.confirm("入力した情報は保存されません");
          		if(result){
          			location.href='/ExamPlatform/MypageServlet'
                }
            }
          </script>
</form>
</div>
</main>
</body>
</html>