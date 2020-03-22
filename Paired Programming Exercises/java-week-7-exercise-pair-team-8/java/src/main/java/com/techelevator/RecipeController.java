package com.techelevator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipeController {

	@RequestMapping({ "/", "/recipeTiles" })
	public String displayRecipeTiles(HttpServletRequest request) {
		request.setAttribute("recipes", getAllRecipes());
		return "recipeTiles";
	}

	@RequestMapping("/recipeTable")
	public String displayRecipeTable(HttpServletRequest request) {
		request.setAttribute("recipes", getAllRecipes());
		return "recipeTable";
	}

	@RequestMapping("/recipeDetails")
	public String displayRecipeDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String recipeIdParam = request.getParameter("recipeId");
			Long recipeId = Long.parseLong(recipeIdParam);
			request.setAttribute("recipe", getRecipeById(recipeId));
			return "recipeDetails";
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

	private Recipe getRecipeById(Long recipeId) {
		for (Recipe r : getAllRecipes()) {
			if (r.getRecipeId().equals(recipeId)) {
				return r;
			}
		}
		return null;
	}

	private List<Recipe> getAllRecipes() {
		List<Recipe> recipes = new ArrayList<>();

		Recipe r = new Recipe(0L).setName("Chili-Garlic Roasted Broccoli").setDescription(
				"A tasty vegetable side that comes together in minutes and cooks without fuss? Yes, please. Allow the broccoli to roast until the florets are well browned and a bit crispy, and you’ll be hooked.")
				.setAverageRating(3.2).setCookTimeInMinutes(20).setRecipeType("Vegetarian")
				.addIngredient("2 Tbs.", "olive oil").addIngredient("2 Tbs.", "lime juice")
				.addIngredient("4 Cloves", "garlic, minced").addIngredient("1 Tbs.", "chili powder")
				.addIngredient("2 medium heads", "broccoli, cut into long spears")
				.addPreparationStep("Preheat oven to 425° F.").addPreparationStep(
						"Combine olive oil, lime juice, garlic, and chili powder in bottom of large bowl. Add broccoli and mix until spears are coated. Season with salt and pepper, if desired. Arrange on baking sheet, and roast 17 to 20 minutes, until florets are brown and crispy at the edges.");
		recipes.add(r);

		r = new Recipe(1L).setName("Mexican Green Rice Pilaf").setDescription(
				"This bright side dish goes especially well with enchiladas or tacos. Unsweetened almond milk lends a natural, delicate sweetness and moistness to the rice while also boosting protein content.")
				.setAverageRating(4.2).setCookTimeInMinutes(35).setRecipeType("Vegetarian")
				.addIngredient("1½ cups", "low-sodium vegetable broth")
				.addIngredient("1 cup", "plain unsweetened almond milk")
				.addIngredient("1 cup", "packed, trimmed watercress sprigs, plus more watercress for garnish, divided")
				.addIngredient("½ cup", "packed cilantro leaves").addIngredient("½ tsp.", "salt")
				.addIngredient("1 ½ Tbs.", "olive oil").addIngredient("1 ½ cups", "jasmine rice")
				.addIngredient("1 small", "onion, finely chopped (¾ cup)").addIngredient("2 cloves", "garlic, minced")
				.addIngredient("6 Tbs.", "toasted, salted pepitas or pumpkin seeds, optional")
				.addPreparationStep(
						"Purée broth, almond milk, watercress sprigs, cilantro, and salt in blender until smooth.")
				.addPreparationStep(
						"Heat oil in medium saucepan over medium-high heat. Add rice, and sauté 2 minutes. Add onion and garlic. Stir in watercress purée, and bring to simmer, stirring often. Reduce heat to low. Cover tightly, and simmer 15 minutes, or until rice is almost tender. Remove from heat. Let stand, covered, 3 minutes")
				.addPreparationStep(
						"Gently fluff rice with fork. Transfer to bowl, and serve sprinkled with watercress leaves and pumpkin seeds, if using.");
		recipes.add(r);

		r = new Recipe(2L).setName("Pasta with Blue Cheese, Arugula, Figs, and Walnuts").setDescription(
				"Lightly wilted arugula lends a fresh, green, peppery flavor to this quick pasta recipe. The dish is a great way to use up bunches of arugula that are slightly wilted or just past their prime.")
				.setAverageRating(2.3).setCookTimeInMinutes(35).setRecipeType("Vegetarian")
				.addIngredient("½ lb.", "curly pasta, such as cavatappi")
				.addIngredient("½ cup", "low-fat cottage cheese")
				.addIngredient("2 oz.",
						"strong blue cheese, such as Point Reyes or Danish Blue, plus more for garnish (optional)")
				.addIngredient("3 cups", "arugula, divided").addIngredient("6", "dried figs, chopped (⅓ cup)")
				.addIngredient("⅓ cup", "chopped toasted walnuts or pistachios")
				.addIngredient("¼ tsp.", "coarsely ground black pepper")
				.addPreparationStep(
						"Whisk together shallots, vinegar, vegetable oil, ginger, and sesame oil in small bowl. Season with salt and pepper, if desired.")
				.addPreparationStep(
						"Toss together watercress and mushrooms in large bowl with half of dressing. Spread salad out on medium platter. Tuck tangerine slices and avocado wedges in between watercress sprigs. Drizzle remaining dressing over salad.");
		recipes.add(r);

		return recipes;
	}
}
