package com.example.ainurbayanova.degirmen.models;

public class TypeOfMeals {
    String nameOfType;
    String image;

    public TypeOfMeals( String image, String nameOfType) {
        this.nameOfType = nameOfType;
        this.image = image;
    }

    public String getNameOfType() {
        return nameOfType;
    }

    public String getImage() {
        return image;
    }
}
