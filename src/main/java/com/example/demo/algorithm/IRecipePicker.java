package com.example.demo.algorithm;

import com.example.demo.model.ExistingIngredients;
import com.example.demo.model.Recipes;

import java.sql.SQLException;

public interface IRecipePicker {
    Recipes pickRecipes(ExistingIngredients ingredients, int maxRecipesNumber) throws SQLException;
}
