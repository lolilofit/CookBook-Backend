package com.example.demo.db;

import com.example.demo.model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClickhouseQueryExecutor {
    private static final String DB_URL = "jdbc:clickhouse://localhost:8123/default";

    private final Connection conn;

    public ClickhouseQueryExecutor() throws SQLException {
        conn = DriverManager.getConnection(DB_URL);
    }

    public List<Recipe> getRecipes(String[] ingredients, int resultSize) throws SQLException {
        if (ingredients.length == 0) {
            return Collections.emptyList();
        }
        List<Recipe> result = new ArrayList<>();
        String query = buildRequest(ingredients, resultSize);

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet rs = statement.executeQuery()) {
                System.out.println("Got db result");
                while (rs.next()) {
                    Recipe recipe = RecipeAdapter.convertRecipe(rs);
                    if (recipe != null) {
                        result.add(recipe);
                    }
                }
            }
        }
        System.out.println("Found recipes size = " + result.size());
        return result;
    }

    private static String buildRequest(String[] ingredients, int resultSize) {
        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder.append("SELECT * FROM recipes WHERE");
        requestBuilder.append(" has(NER, '");
        requestBuilder.append(ingredients[0]);
        requestBuilder.append("')");
        for (int i = 1; i < ingredients.length; i++) {
            requestBuilder.append(" AND has(NER, '");
            requestBuilder.append(ingredients[i]);
            requestBuilder.append("')");
        }
        requestBuilder.append(" LIMIT ");
        requestBuilder.append(resultSize);
        requestBuilder.append(";");
        return requestBuilder.toString();
    }
}
