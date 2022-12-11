package com.example.demo.algorithm;

import com.example.demo.db.ClickhouseQueryExecutor;
import com.example.demo.model.ExistingIngredients;
import com.example.demo.model.Recipe;
import com.example.demo.model.Recipes;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RecipePicker implements IRecipePicker {
    private ClickhouseQueryExecutor queryExecutor;

    public RecipePicker() throws SQLException {
        queryExecutor = new ClickhouseQueryExecutor();
    }

    @Override
    public Recipes pickRecipes(ExistingIngredients ingredients, int maxRecipesNumber) throws SQLException {
        String[] processedIngredients = preprocessIngredients(ingredients.getNames());

        List<Recipe> recipes = queryExecutor.getRecipes(processedIngredients, maxRecipesNumber);
        return new Recipes(recipes.toArray(new Recipe[0]));
    }

    private String[] preprocessIngredients(String[] original) {
        String[] result = new String[original.length];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i].toLowerCase();
        }
        return result;
    }
}
