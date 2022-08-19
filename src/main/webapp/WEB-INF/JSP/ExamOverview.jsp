<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "model.data.ExamCreatePage" %>
<%@ page import = "model.data.Genre" %>
<%@ page import = "model.data.EntryExam" %>
<%@ page import = "java.util.List" %>
    
     <% 
     	ExamCreatePage pageData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
        List<Genre> genreList = pageData.getGenreList();
        List<String> tagList = pageData.getTagList();
        EntryExam entryExam = pageData.getEntryExam();
    	int questionFormat = pageData.getQuestionFormat();
      %>
      
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
<h1 class = "mi_1">試験概要入力フォーム</h1>
   <div><label for = "e_Name">試験名：<input type = "text" name = "examName" <%= entryExam == null ? "placeholder = \"examName\"" : "value = \""+entryExam.getExamName()+"\""%>></label></div>

          <div>
               <label for = "genre" >ジャンル：
               <% for(Genre genre : genreList){ %>
               		<input type = "radio" name = "genre" value = <%= genre.getGenreID() %> <%= entryExam==null ? "":genre.getGenreID()==entryExam.getGenreID() ? "checked=\"checked\"" : ""%>><%= genre.getGenreName() %> <%--getGenre --%>
               <% } %>
               </label>
          </div>
          
          <datalist id="TagList">
			<% for(String tag : tagList){ %>
               		<option value=<%= tag %> ></option>
          <% } %>
          </datalist>
          <div class = "tag">
               <label for = "tag" id = "tagForm">タグ：
               <%if(entryExam==null || entryExam.getTagList().isEmpty()){%>
               		<span><input type = "text" name = "tag" class = "text" list = "TagList"></span>
               <%
               }else{
            	   int i=0;
                   for(String tag:entryExam.getTagList()){
                	   if(i==0){
               %>
               	          <span><input type = "text" name = "tag" class = "text" list = "TagList" value = <%= tag%>></span>
                       <%}else{%>
                          <span><br><input type = "text" name = "tag" class = "text" list = "TagList" value = <%= tag%>><button type="button" class="btn-rmTagForm" onclick="rmTagForm(this)">-削除</button></span>
               <%
                       }
                	   i++;
                   }
               }
               %>
               </label>
               <br><button type="button" id="btn-addTagForm" onclick="addTagForm()">＋追加</button>
          </div>
          
          <div>
               <label for = "OpenRange" >公開範囲：
               <input type = "radio" name = "OpenRange" value = "0" onchange = "LimitedPassForm()" <%= entryExam==null ? "" : entryExam.getDisclosureRange()==0 ? "checked=\"checked\"" : ""%>>公開
               <input type = "radio" name = "OpenRange" value = "1" onchange = "LimitedPassForm()" <%= entryExam==null ? "" : entryExam.getDisclosureRange()==1 ? "checked=\"checked\"" : ""%> id = "radio-limited">限定公開
               <input type = "radio" name = "OpenRange" value = "2" onchange = "LimitedPassForm()" <%= entryExam==null ? "" : entryExam.getDisclosureRange()==2 ? "checked=\"checked\"" : ""%>>非公開
               </label>
          </div>
          
          <div id = "Ques_for">
               <label for="QuestionFormat">問題形式：</label>
               <label><input type="radio" value = "0" name="QuestionFormat" <%= questionFormat==0 ? "checked=\"checked\"" : ""%>>大問</label>
               <label><input type="radio" value = "1"name="QuestionFormat"  <%= questionFormat==1 ? "checked=\"checked\"" : ""%>>小問</label>
          </div>
          
          <div><label for = "e_Time">試験時間：<input type = "number" name = "examTime" min = 1 <%= entryExam == null ? "" : "value = \""+entryExam.getExamTime()+"\""%>>分</label></div>
          
          <div><label for = "e_score">合格点：<input type = "number" name = "passingScore" min = 1 <%= entryExam == null ? "" : "value = \""+entryExam.getPassingScore()+"\""%>>点</label></div>
          
          <div>
               <label for = "Explanation">説明文：</label>
               <textarea name = "Explanation" placeholder = "試験概要を説明して下さい"><%= entryExam == null ? "" : entryExam.getExamExplanation()%></textarea>
          </div>
          
          <div class = "footer">
          
          <div class = "botton_area">
          <button type="button" id = "btn-back" class = "back" onclick="back()">戻る</button>
          <input type="submit" value = "ＯＫ" class = "ok"></input>
          </div>
          
          </div>
          
          <script src="./js/tag.js"></script>
          <script src="./js/openRange.js"></script>
          <script type="text/javascript">
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