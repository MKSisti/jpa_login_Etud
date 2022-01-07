<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Update Etudiant</title>
</head>
<body>
	<div style="width:50%;margin:auto;margin-top:3%">
		<div style="width:200px">
			<form action="goToEtudiant" method="get">
				<input class="success" type="submit" value="Go back">
			</form>
		</div>
		<form action="DoUpdate" method="post" id="etudForm">
			<label for="id">Id: ${etudiant.getId()}</label><br> 
			<input id="id" type="hidden" name="id" value="${etudiant.getId()}" ><br> 
			
			<label for="prenom">Prenom: </label><br> 
			<input id="prenom" type="text" value="${etudiant.getPrenom()}" name="prenom"><br>
			
			<label for="nom">Nom: </label><br> 
			<input id="nom" type="text" value="${etudiant.getNom()}" name="nom"><br> 
			
			<label for="email">Email: </label><br> 
			<input id="email" type="text" value="${etudiant.getEmail()}" name="email"><br> 
			
			<label for="tel">Tel: </label><br> 
			<input id="tel" type="text" value="${etudiant.getTel()}" name="tel"><br> 
			
			<label for="filiereId">Filiere: </label><br> 
			<select  form="etudForm" name="filiereId" id="filiereId">
				<option value="none" >--Please choose an option--</option>
				<c:forEach items="${filieres}" var="fil">
	    			<option value="${fil.getId()}" ${fil.getId() == etudiant.getFiliere().getId() ? "selected" : "" }>${fil.getName()}</option>
    			</c:forEach>
			</select>
			
			<input class="primary" type="submit" value="Update Etudiant">
		</form>
	</div>
</body>
</html>