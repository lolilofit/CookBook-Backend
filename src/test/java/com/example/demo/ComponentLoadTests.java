package com.example.demo;

import com.example.demo.algorithm.IRecipePicker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ComponentLoadTests {
    @Autowired
    IRecognitionHelper recognitionHelper;

    @Autowired
    private IRecipePicker recipePicker;

    @Test
    void contextLoads() {
        assertNotNull(recognitionHelper);
        assertNotNull(recipePicker);
    }


}
