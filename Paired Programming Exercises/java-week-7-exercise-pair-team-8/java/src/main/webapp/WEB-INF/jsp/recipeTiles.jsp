<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/header.jsp">
    <c:param name="pageTitle" value="recipeHeader" />
</c:import>

	<section id="main-content">
	<h3>Recipes</h3>
	<div id="content">
		<c:forEach var="recipe" items="${recipes}">
			<c:url var = "aRecipe" value ="/recipeDetails"> <!-- create a URL variable to define the path you want the link to be -->
				<c:param name ="recipeId">${recipe.recipeId}</c:param> <!-- define your parameter from Recipe class -->
			</c:url>
				<a class = "recipe-image" href="${aRecipe}"><img src="img/recipe${recipe.recipeId}.jpg"/> <!-- href will link using the URL variable
																											   we defined earlier -->
				<h4>${recipe.name}</h4>
			<div class="rating">
				<img src="img/${Math.round(recipe.averageRating)}-star.png" />
				<em>${recipe.ingredients.size()} ingredients</em>
				</div>
			</a>
		</c:forEach>
	</div>
	</section>
</body>
</html>