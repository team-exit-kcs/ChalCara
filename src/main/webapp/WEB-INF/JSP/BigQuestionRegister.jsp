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
<%-- 大問 --%>
<div class = "Bigquestion"><%--大問が選択された時 --%>
 <ul class = "B_question">
 
  <li class = "B_mon">
    <label for="b_toi">問１.</label>
    <textarea id="B_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea>
  </li>
 </ul> 

<jsp:include page="./QuestionForm.jsp" />

<jsp:include page="./QuestionForm.jsp" />

</div>
<div class = "footer">
          <div class = "botton_area">
          <button type="button" id = "btn-back" class = "back" onclick="back()">戻る</button>
          <input type="submit" value = "ＯＫ" class = "ok"></input>
          </div>          
</div>
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