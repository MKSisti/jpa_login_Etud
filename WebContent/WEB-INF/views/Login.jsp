<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Login</title>
</head>
<body>
	<div style="width:50%;margin:auto;margin-top:3%">
		<div style="width:200px">
			<form action="goSignUp" method="get">
				<input class="success" type="submit" value="SignUp ?">
			</form>
		</div>
		<c:if test="${Message.length() > 0}">
			<div class="errorText">
				<c:out value="${Message}" />
			</div>
		</c:if>
		<form action="UserLogin" method="post">
		
			<label for="userName">UserName: </label><br> 
			<input id="userName" type="text" name="userName"><br>
			
			<label for="password">Password: </label><br> 
			<input id="password" type="password" name="password"><br> 
			
			<input class="primary" type="submit" value="Login">
		</form>
	</div>
</body>
</html>