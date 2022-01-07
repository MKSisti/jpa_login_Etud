<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Update Filiere</title>
</head>
<body>
	<div style="width:50%;margin:auto;margin-top:3%">
		<div style="width:200px">
			<form action="goToFiliere" method="get">
				<input class="success" type="submit" value="Go back">
			</form>
		</div>
		<form action="DoUpdate" method="post">
			<label for="id">Id: ${filiere.getId()}</label><br> 
			<input id="id" type="hidden" name="id" value="${filiere.getId()}" ><br> 
			
			<label for="name">Nom: </label><br> 
			<input id="name" type="text" value="${filiere.getName()}" name="name"><br>
			
			<label for="description">Description: </label><br> 
			<input id="description" type="text" value="${filiere.getDescription()}" name="description"><br> 
			
			<input class="primary" type="submit" value="Update Filiere">
		</form>
	</div>
</body>
</html>