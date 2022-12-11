package com.example.demo.model;

public class ExistingIngredients {
    private String[] names;

    public ExistingIngredients() {
    }

    public ExistingIngredients(String[] names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}
