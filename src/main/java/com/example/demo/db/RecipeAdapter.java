package com.example.demo.db;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter {
    public static Recipe convertRecipe(ResultSet rs) throws SQLException {
        String title = rs.getString("title");

        Array ingredientsNamesArray = rs.getArray("ingredients");
        String[] ingredientsNames = (String[])ingredientsNamesArray.getArray();
        List<Ingredient> ingredients = new ArrayList<>();
        for (String i : ingredientsNames) {
            ingredients.add(new Ingredient(i, 1, ""));
        }

        Array directionsArray = rs.getArray("directions");
        String[] directions = (String[])directionsArray.getArray();
        List<String> steps = List.of(directions);

        return new Recipe(title,
                ingredients.toArray(new Ingredient[0]),
                steps.toArray(new String[0]));
    }
}
