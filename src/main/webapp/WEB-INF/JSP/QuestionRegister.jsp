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
<form>
<h1>問題登録フォーム</h1>

<div class="QuestionFormat_q">
    <label for="QuestionFormat">問題形式：</label>
    <input type="radio" id="QuestionFormat" name="QuestionFormat" value = "大問"/>大問
</div>

 <ul>
  
  <li>
    <label for="mail">E-mail:</label>
    <input type="email" id="mail" name="user_email" />
  </li>
  
  <li>
    <label for="msg">Message:</label>
    <textarea id="msg" name="user_message"></textarea>
  </li>
  
 </ul>
</form>


</body>
</html>