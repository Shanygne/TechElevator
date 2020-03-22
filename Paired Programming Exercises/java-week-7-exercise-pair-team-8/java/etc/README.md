# Recipes

## Day 1 (Thursday)

A class has already been created called Recipe. Your job is to develop a number of different views for a List of Recipes based on the visuals provided in the `etc` folder.

1. [Tile View](etc/day1/recipe-tile.png)
2. [Table View](etc/day1/recipe-table.png)


Model classes representing a `Recipe` and an `Ingredient` have been provided for you. **Do not modify or simplify the model's properties**
for this exercise.

You will need to implement a view for each to display a list of recipes. Recipe images have been provided.

---

## Day 2 (Friday)

Convert your existing pages to use a shared layout view so that you are not continually repeating each site template.

Make the Table and Tile view have clickable links that redirect the user to the recipe specific detail view. Suggestions include making the image clickable, the recipe name clickable, etc. 

The links should target `.../recipeDetails?recipeId=3` where the `recipeId` parameter is set to the recipeId of the recipe to be displayed.

Implement the [Detail View](etc/day2/recipe-detail-pair.png) for your individual recipe. The JSP file should be named `recipeDetails.jsp`.

