package com.example.demo;

import com.example.demo.db.ClickhouseQueryExecutor;
import com.example.demo.model.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DbTest {
    @Test
    public void testDbConnection() throws SQLException {
        ClickhouseQueryExecutor queryExecutor = new ClickhouseQueryExecutor();
        List<Recipe> recipes = queryExecutor.getRecipes(new String[] {"strawberry", "sugar", "egg" }, 10);
        assertTrue(recipes.size() == 10);
    }
}
