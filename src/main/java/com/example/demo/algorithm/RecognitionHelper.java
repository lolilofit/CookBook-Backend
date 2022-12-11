package com.example.demo.algorithm;

import com.example.demo.IRecognitionHelper;
import com.example.demo.model.ExistingIngredients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecognitionHelper implements IRecognitionHelper {
    private static final String url = "http://localhost:8081/food";

    @Override
    public ExistingIngredients recognizeIngredients(byte[] image) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.IMAGE_PNG);
//        HttpEntity<byte[]> entity = new HttpEntity<>(image, header);
//        HttpEntity<ExistingIngredients> response = restTemplate.exchange(url, HttpMethod.POST, entity, ExistingIngredients.class);
//        return response.getBody();
        return new ExistingIngredients(new String[] {"butter", "banana", "milk"});
    }
}
