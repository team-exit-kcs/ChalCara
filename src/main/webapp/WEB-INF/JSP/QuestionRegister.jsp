<%--問題登録フォーム --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./title.jsp" />
<link rel="stylesheet" href="./css/QuestionRegister.css">
</head>
<body>
<form action="/ExamPlatform/ExamCreateServlet/Question" method="post">
<h1>問題登録フォーム</h1>
<main>
<jsp:include page="./QuestionForm.jsp" />

<div class = "Smallquestion"><%--小問が選択された時 --%>
<ul class = "S_question">
  <%-- 小問 --%>  
  <li>
    <label for="s_toi">問１．</label>
    <textarea class="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea>
  </li>
  
  <%-- 選択 --%>
  <li class = "Select">
    <label><input type="radio" name="Select_Symbol">ア．</label>
    <input type="text" class="Select_text" name="Select_text" />
  </li>
  
  <li class = "Select">
    <label><input type="radio" name="Select_Symbol">イ．</label>
    <input type="text" class="Select_text" name="Select_text" />
  </li>
  
  <li class = "Select">
    <label><input type="radio" name="Select_Symbol">ウ．</label>
    <input type="text" class="Select_text" name="Select_text" />
  </li>
  
  <li class = "Select">
    <label><input type="radio" name="Select_Symbol">エ．</label>
    <input type="text" class="Select_text" name="Select_text" />
  </li> 
</ul>
</div>

<div class = "footer">
          <div class = "botton_area">
          <button type="button" id = "btn-back" class = "back" onclick="back()">戻る</button>
          <input type="submit" value = "ＯＫ" class = "ok"></input>
          </div>          
</div>
</main>
</form>
<script type="text/javascript">
         	function back(){
          		result=window.confirm("保存されていないデータは破棄されます");
          		if(result){
          			location.href='/ExamPlatform//ExamCreateServlet'
                }
            }
</script>
</body>
</html>