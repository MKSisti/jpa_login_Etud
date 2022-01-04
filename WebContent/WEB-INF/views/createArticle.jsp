<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Create</title>
</head>
<body>
	<div style="width:50%;margin:auto;margin-top:3%">
		<div style="width:200px">
			<form action="goHome" method="get">
				<input class="success" type="submit" value="Go back">
			</form>
		</div>
		<form action="DoCreate" method="post">
		
			<label for="count">Count: </label><br> 
			<input id="count" type="number" name="count"><br>
			
			<label for="description">Description: </label><br> 
			<input id="description" type="text" name="description"><br> 
			
			<label for="name">Name: </label><br> 
			<input id="name" type="text" name="name"><br>
			
			<label for="price">Price: </label><br> 
			<input id="price" type="number" name="price"><br>
			
			<input class="primary" type="submit" value="Submit new Article">
		</form>
	</div>
</body>
</html>