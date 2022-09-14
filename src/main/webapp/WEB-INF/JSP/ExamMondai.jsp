<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>試験</title>
</head>
<body style="margin: 50px 0">
	<div style="text-align: center; background-color: aqua; position: fixed; width: 100%; top: 0; left: 0;">
		試験時間：<span></span>
	</div>

	<h1>[試験名]</h1>
	
	<h2>大問1</h2>
	問題文：
	<p></p>
	
	<div>
		小問1
		<p>問題文：</p>
	
		<input name="q1" type="radio" ><label>1.</label>
		<input name="q1" type="radio" ><label>2.</label>
		<input name="q1" type="radio" ><label>3.</label>
		<input name="q1" type="radio" ><label>4.</label>
	</div>
	
	
	<div>
		小問2
		<p>問題文：</p>
	
		<input name="q2" type="radio" ><label>1.</label>
		<input name="q2" type="radio" ><label>2.</label>
		<input name="q2" type="radio" ><label>3.</label>
		<input name="q2" type="radio" ><label>4.</label>	
	</div>
	
	<div style="text-align: center; background-color: aqua; position: fixed; width: 100%; bottom: 0; left: 0;">
		<button>試験終了</button>
	</div>
</body>
</html>