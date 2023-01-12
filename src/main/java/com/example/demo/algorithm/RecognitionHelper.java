package com.example.demo.algorithm;

import com.example.demo.IRecognitionHelper;
import com.example.demo.model.ExistingIngredients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RecognitionHelper implements IRecognitionHelper {
    private static final String url = "http://localhost:5000/food";

    @Override
    public ExistingIngredients recognizeIngredients(byte[] image) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.IMAGE_JPEG);
        HttpEntity<byte[]> entity = new HttpEntity<>(image, header);
        HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        String body = response.getBody();
        if (body == null) {
            System.out.println("Empty body response!!!");
            return new ExistingIngredients();
        }

        System.out.println("Got ingredients : " + body);

        String[] parts = body.split(",");
        List<String> strings = Arrays.stream(parts)
                .map(s -> s.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", ""))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();
        return new ExistingIngredients(strings.toArray(new String[0]));
//        return new ExistingIngredients(new String[] {"butter", "banana", "milk"});
    }
}
