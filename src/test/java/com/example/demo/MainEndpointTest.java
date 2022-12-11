package com.example.demo;

import com.example.demo.model.ExistingIngredients;
import com.example.demo.model.Recipe;
import com.example.demo.model.Recipes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainEndpointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        Recipes recipes = sendRequest(readTestImage());
        assertNotNull(recipes);
    }

    private Recipes sendRequest(byte[] image) {
        String url = "http://localhost:" + port + "/main";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.IMAGE_PNG);
        HttpEntity<byte[]> entity = new HttpEntity<>(image, header);
        HttpEntity<Recipes> response = restTemplate.exchange(url, HttpMethod.POST, entity, Recipes.class);
        return response.getBody();
    }

    private byte[] readTestImage() throws IOException {
        File f = new File("src/test/resources/test.PNG");
        return Files.readAllBytes(f.toPath());
    }
}
