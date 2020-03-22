<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<c:import url="/WEB-INF/jsp/header.jsp">
    <c:param name="pageTitle" value="recipeHeader" />
</c:import>

    <section id="main-content">
    <h1>Recipes</h1>
    <div id="main">
   	<table>
   		<tr>
   			<td></td>
			<c:forEach var="recipe" items="${recipes}">
				<td>
				<c:url var = "aRecipe" value ="/recipeDetails">
				<c:param name ="recipeId">${recipe.recipeId}</c:param>
				</c:url>
				<a class = "recipe-image" href="${aRecipe}">
					<img src="<c:url value="/img/recipe${recipe.recipeId}.jpg" />" />
				</a>
				</td>
			</c:forEach>
		</tr>
   		
   		<tr id = name>
   			<td>Name</td>
			<c:forEach var="recipe" items="${recipes}">
				<td><c:url var = "aRecipe" value ="/recipeDetails">
				<c:param name ="recipeId">${recipe.recipeId}</c:param>
			</c:url>
				<a class = "recipe-image" href="${aRecipe}">${recipe.name}</a></td>
			</c:forEach>
		</tr>
		
		<tr id = type>
   			<td>Type</td>
			<c:forEach var="recipe" items="${recipes}">
					<td>${recipe.recipeType}</td>
			</c:forEach>
		</tr>
		
		<tr id = cooktime>
   			<td>Cook Time</td>
			<c:forEach var="recipe" items="${recipes}">
					<td>${recipe.cookTimeInMinutes}</td>
			</c:forEach>
		</tr>
		
		<tr id = ingredients>
   			<td>Ingredients</td>
			<c:forEach var="recipe" items="${recipes}">
					<td>${recipe.ingredients.size()}</td>
			</c:forEach>
		</tr>
		
		<tr id = rating>
   			<td>Rating</td>
			<c:forEach var="recipe" items="${recipes}">
					<td><img src="img/${Math.round(recipe.averageRating)}-star.png" /></td> <!-- allows us to pull the rating depending 
																								 on averageRating and will automatically round -->
			</c:forEach>
		</tr>
	</table>
    </div></section>
</body>
</html>