<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 小問 --%>  
<div>
 <ul class = "B_question">
  <li>
    <label for="s_toi">＜設問１＞</label>
    <textarea class="S_ques_area" name="quesution" placeholder = "問題文を入力して下さい"></textarea>
  </li>
</ul>  
<%-- 選択 --%>
<div>
 <ul class = "B_question">
  <li class = "Select">
    <label><input type="radio" name="Select_Symbol" value=0>1．</label>
    <input type="text" class="Select_text" name="Select_text" />
  </li>
  
  <li class = "Select">
    <label><input type="radio" name="Select_Symbol" value=1>2．</label>
    <input type="text" class="Select_text" name="Select_text" />
  </li>
  <li><br><button type="button" onclick="addChoicesForm(this)">＋選択肢を追加</button></li>
 </ul>
</div>
</div>

<script src="./js/choices.js"></script>