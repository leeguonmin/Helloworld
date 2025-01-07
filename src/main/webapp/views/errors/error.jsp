<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--  <p>Exception Type: exception.getClass().getSimpleName()  이거 에러 없애려고 만듦 -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
<h1>뭔가 잘못되었습니다.</h1>
<p>ERROR CODE: <%= response.getStatus() %></p>
<p>Exception Type: <%= exception.getClass().getSimpleName() %></p> 
<p>에러 메세지: <%= exception.getMessage() %></p>

</body>
</html>