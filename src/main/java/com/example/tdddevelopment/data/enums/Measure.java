package com.example.tdddevelopment.data.enums;

public enum Measure {
    GRAM("gram"),
    KILOGRAM("kg"),
    MILLIGRAM("mg"),
    LITRE("l"),
    MILLILITRES("ml"),
    CUP("cup"),
    TABLESPOON("tablespoon"),
    TEASPOON("teaspoon"),
    PIECE("pc"),
    TWIG("twig"),
    PINCH("pinch"),
    DROP("drop");

    Measure(String name) {
        this.measure = name;
    }

    private final String measure;

    public String getMeasure() {
        return measure;
    }
}
