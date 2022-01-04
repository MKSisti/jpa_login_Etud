<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Create Etudiant</title>
</head>
<body>
	<div style="width:50%;margin:auto;margin-top:3%">
		<div style="width:200px">
			<form action="goToEtHome" method="get">
				<input class="success" type="submit" value="Go back">
			</form>
		</div>
		<form action="createetud" method="post" id="etudForm">
		
			<label for="prenom">Prenom: </label><br> 
			<input id="prenom" type="text" name="prenom"><br>
			
			<label for="nom">Nom: </label><br> 
			<input id="nom" type="text" name="nom"><br> 
			
			<label for="email">Email: </label><br> 
			<input id="email" type="text" name="email"><br>
			
			<label for="tel">Tel: </label><br> 
			<input id="tel" type="number" name="tel"><br>
			
			<label for="filiereId">Filiere: </label><br> 
			<select form="etudForm" name="filiereId" id="filiereId">
				<option value="">--Please choose an option--</option>
				<c:forEach items="${filieres}" var="fil">
	    			<option value="${fil.getId()}">${fil.getName()}</option>
    			</c:forEach>
			</select>
			
			<input class="primary" type="submit" value="Ajouter Etudiant">
		</form>
	</div>
</body>
</html>