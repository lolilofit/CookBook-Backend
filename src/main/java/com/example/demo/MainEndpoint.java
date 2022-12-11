package com.example.demo;

import com.example.demo.model.ExistingIngredients;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import com.example.demo.model.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainEndpoint {
    private static final int maxRecipesNumber = 10;

    @Autowired
    private IRecognitionHelper recognitionHelper;

    @RequestMapping(value = "/main", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipes> getRecipes(byte[] image) {
        System.out.println("See request...");
        ExistingIngredients existingIngredients = recognitionHelper.recognizeIngredients(image);
        Recipes recipes = RecipesGetter.getRecipes(existingIngredients, maxRecipesNumber);
        System.out.println("Send response");
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(recipes);
    }
}
