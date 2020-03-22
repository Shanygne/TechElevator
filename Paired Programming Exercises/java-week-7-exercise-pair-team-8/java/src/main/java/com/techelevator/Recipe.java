package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Recipe {

	private Long recipeId;
	private String name;
	private String description;
	private List<Ingredient> ingredients;
	private List<String> preparationSteps;
	private double averageRating;
	private int cookTimeInMinutes;
	private String recipeType;

	public Recipe(Long id) {
		this.recipeId = id;
		this.ingredients = new ArrayList<>();
		this.preparationSteps = new ArrayList<>();
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Ingredient> getIngredients() {
		return Collections.unmodifiableList(ingredients);
	}

	public Recipe addIngredient(String quantity, String ingredientName) {
		this.ingredients.add(new Ingredient(quantity, ingredientName));
		return this;
	}

	public List<String> getPreparationSteps() {
		return Collections.unmodifiableList(preparationSteps);
	}

	public Recipe addPreparationStep(String preparationStep) {
		this.preparationSteps.add(preparationStep);
		return this;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public Recipe setAverageRating(double averageRating) {
		this.averageRating = averageRating;
		return this;
	}

	public int getCookTimeInMinutes() {
		return cookTimeInMinutes;
	}

	public Recipe setCookTimeInMinutes(int cookTimeInMinutes) {
		this.cookTimeInMinutes = cookTimeInMinutes;
		return this;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public Recipe setRecipeType(String recipeType) {
		this.recipeType = recipeType;
		return this;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public Recipe setName(String name) {
		this.name = name;
		return this;
	}

	public Recipe setDescription(String description) {
		this.description = description;
		return this;
	}
}
