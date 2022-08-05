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
<div id = "Ques_for">
    <label for="QuestionFormat">＜問題形式＞</label>
    <label><input type="radio" value = "0" name="QuestionFormat"/>大問</label>
    <label><input type="radio" value = "1"name="QuestionFormat"/>小問</label>
</div>


<div class = "keepExam">

<ul>
    <li id = "keep_big">
    <label for="kpd_toi">大問</label>
    <select name = "keep_big">
    <option value="">新規大問</option>
    <option value="q_1">Ｑ１</option>
    <option value="q_2">Ｑ２</option>
    <option value="q_3">Ｑ３</option>
    <option value="q_4">Ｑ４</option>
    </select>
    </li>
</ul>
</div>

<%-- 大問 --%>
<div class = "Bigquestion"><%--大問が選択された時 --%>
 <ul class = "B_question">
 
  <li>
    <label for="b_toi">問１.</label>
    <textarea id="B_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea>
  </li>
<%-- 小問 --%>  
  <li>
    <label for="s_toi">＜設問１＞</label>
    <textarea id="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea>
  </li>
  
<%-- 選択 --%>
  <li id = "Select">
    <label><input type="radio" name="Select_Symbol" value=0>1．</label>
    <input type="text" id="Select_text" name="Select_text" />
  </li>
  
  <li id = "Select">
    <label><input type="radio" name="Select_Symbol" value=1>2．</label>
    <input type="text" id="Select_text" name="Select_text" />
  </li>
 </ul>
  <br><button type="button" onclick="addChoicesForm()">＋選択肢を追加</button>
</div>

<div class = "Smallquestion"><%--小問が選択された時 --%>
<ul class = "S_question">
  <%-- 小問 --%>  
  <li>
    <label for="s_toi">問１．</label>
    <textarea id="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea>
  </li>
  
  <%-- 選択 --%>
  <li id = "Select">
    <label><input type="radio" name="Select_Symbol">ア．</label>
    <input type="text" id="Select_text" name="Select_text" />
  </li>
  
  <li id = "Select">
    <label><input type="radio" name="Select_Symbol">イ．</label>
    <input type="text" id="Select_text" name="Select_text" />
  </li>
  
  <li id = "Select">
    <label><input type="radio" name="Select_Symbol">ウ．</label>
    <input type="text" id="Select_text" name="Select_text" />
  </li>
  
  <li id = "Select">
    <label><input type="radio" name="Select_Symbol">エ．</label>
    <input type="text" id="Select_text" name="Select_text" />
  </li> 
</ul>
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
 <script src="./js/choices.js"></script>
</body>
</html>