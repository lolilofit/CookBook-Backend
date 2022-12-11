package com.example.demo;

import com.example.demo.model.ExistingIngredients;

public interface IRecognitionHelper {
    ExistingIngredients recognizeIngredients(byte[] image);
}
