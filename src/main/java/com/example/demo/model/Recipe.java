package com.example.demo.model;

import com.example.demo.model.Ingredient;

public class Recipe {
    private String name;
    private Ingredient[] ingredients;
    private String[] steps;

    public Recipe() {}

    public Recipe(String name, Ingredient[] ingredients, String[] steps) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getSteps() {
        return steps;
    }

    public void setSteps(String[] steps) {
        this.steps = steps;
    }
}
