<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<c:import url="/WEB-INF/jsp/header.jsp">
    <c:param name="pageTitle" value="recipeTitle" />
</c:import>

<body>
<section id = "main-content">
<div id ="recipe-content">
<h3>${recipe.name}</h3>
<img src="img/recipe${recipe.recipeId}.jpg"/><br>
${recipe.recipeType}<br>
<b>Cook Time:</b> ${recipe.cookTimeInMinutes}
<p>${recipe.description}</p>
</div>

<div id="recipe-ingredients">
<b>Ingredients:</b>
<c:forEach var="ingredient" items="${recipe.ingredients}">
<li>${ingredient.quantity}
${ingredient.name}</li>
</c:forEach></div>
<br>

<div id="recipe-preparation">
<b>Preparation:</b>
<c:forEach var ="prepSteps" items="${recipe.preparationSteps}">
<li>${recipe.preparationSteps}
</li>
</c:forEach>
</div></section>
</body>
</html>