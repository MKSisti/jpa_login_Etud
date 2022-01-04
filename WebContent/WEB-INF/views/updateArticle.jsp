<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Update</title>
</head>
<body>
	<div style="width:50%;margin:auto;margin-top:3%">
		<div style="width:200px">
			<form action="goHome" method="get">
				<input class="success" type="submit" value="Go back">
			</form>
		</div>
		<form action="DoUpdate" method="post">
			<label for="">Code: ${article.code}</label><br> 
			<input id="code" type="hidden" name="code" value="${article.code}" ><br> 
			
			<label for="count">Count: </label><br> 
			<input id="count" type="number" value="${article.count}" name="count"><br>
			
			<label for="description">Description: </label><br> 
			<input id="description" type="text" value="${article.description}" name="description"><br> 
			
			<label for="name">Name: </label><br> 
			<input id="name" type="text" value="${article.name}" name="name"><br>
			
			<label for="price">Price: </label><br> 
			<input id="price" type="number" value="${article.price}" name="price"><br>
			
			<input class="primary" type="submit" value="Update Article">
		</form>
	</div>
</body>
</html>