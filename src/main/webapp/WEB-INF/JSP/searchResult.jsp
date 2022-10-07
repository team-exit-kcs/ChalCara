<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
</head>
<body>
<jsp:include page="./header.jsp" />
<jsp:include page="./searchForm.jsp" /><br/>
<c:if test="${not empty msg}"><p><c:out value="${msg}"/></p></c:if>
<c:forEach var="result" items="${searchResult.resultList}" begin="${(searchResult.page - 1)*searchResult.STEP}" end="${searchResult.page * searchResult.STEP - 1}">
<span><img src="<c:out value="${result.icon}"/>" style="width: 25px;"><a href="<c:out value="${result.URL}"/>" ><c:out value="${result.name}"/></a></span><br/>
</c:forEach>
</body>
</html>