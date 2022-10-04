<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<form action="/ExamPlatform/SearchServlet" method="post">
<select required name="searchFormat">
<option value="1">試験検索</option>
<option value="2">試験ID検索</option>
<option value="3">ユーザID検索</option>
</select>
<input type = "text" required name = "searchWord" placeholder = "検索" />
<input type="submit" value = "検索" class = "ok" />
</form>