package com.example.demo;

import com.example.demo.algorithm.IRecipePicker;
import com.example.demo.model.ExistingIngredients;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import com.example.demo.model.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class MainEndpoint {
    private static final int maxRecipesNumber = 10;

    @Autowired
    private IRecognitionHelper recognitionHelper;

    @Autowired
    private IRecipePicker recipePicker;

    @RequestMapping(value = "/main", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipes> getRecipes(@RequestBody byte[] image) throws SQLException {
        System.out.println("See request...");
        ExistingIngredients existingIngredients = recognitionHelper.recognizeIngredients(image);
        Recipes recipes = recipePicker.pickRecipes(existingIngredients, maxRecipesNumber);
        System.out.println("Send response");
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(recipes);
    }
}
