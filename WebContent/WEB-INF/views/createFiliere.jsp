<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Create Filiere</title>
</head>
<body>
	<div style="width:50%;margin:auto;margin-top:3%">
		<div style="width:200px">
			<form action="goToFilHome" method="get">
				<input class="success" type="submit" value="Go back">
			</form>
		</div>
		<form action="Createfil" method="post">
		
			<label for="name">Nom: </label><br> 
			<input id="name" type="text" name="name"><br>
			
			<label for="description">Description: </label><br> 
			<input id="description" type="text" name="description"><br>
			
			<input class="primary" type="submit" value="Create New">
		</form>
	</div>
</body>
</html>