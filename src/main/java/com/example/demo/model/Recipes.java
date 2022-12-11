package com.example.demo.model;

public class Recipes {
    private Recipe[] recipes;

    public Recipes() {

    }

    public Recipes(Recipe[] recipes) {
        this.recipes = recipes;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe[] recipes) {
        this.recipes = recipes;
    }
}
