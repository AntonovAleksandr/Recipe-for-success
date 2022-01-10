package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.enums.Measure;
import com.example.tdddevelopment.data.excepptions.BusinessException;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IngredientDtoTest {
    private IngredientDto ingredientSetDto;
    private Double validQuantity;
    private Double invalidQuantity;
    private Measure validMeasure;
    private ProductDto productDto;

    @Before
    public void setUpTest() throws Exception {
        productDto = new ProductDto();
        ingredientSetDto = new IngredientDto();
        validQuantity = 1.3;
        invalidQuantity = 0.00;
        validMeasure = Measure.CUP;
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void setQuantityTest() {
        ingredientSetDto.setQuantity(validQuantity);
        Assertions.assertEquals(ingredientSetDto.getQuantity(), validQuantity);
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void setZeroQuantityTest() {
        ingredientSetDto.setQuantity(invalidQuantity);
        Assertions.fail("The quantity value must be positive");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void setNullQuantityTest() {
        ingredientSetDto.setQuantity(null);
        Assertions.fail("The quantity value cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void setMeasureTest() {
        ingredientSetDto.setQuantity(validQuantity);
        ingredientSetDto.setMeasure(validMeasure);
        Assertions.assertEquals(ingredientSetDto.getMeasure(), validMeasure);
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void setNullMeasureTest() {
        ingredientSetDto.setQuantity(validQuantity);
        ingredientSetDto.setMeasure(null);
        Assertions.fail("The measure value cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void setMeasureBeforeQuantityTest() {
        ingredientSetDto.setMeasure(validMeasure);
        Assertions.fail();
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void setIngredientTest() {
        ingredientSetDto.setIngredient(productDto);
        Assertions.assertEquals(ingredientSetDto.getIngredient(), productDto);
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void setNullIngredientTest() {
        ingredientSetDto.setIngredient(null);
        Assertions.fail("The ingredient value cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void IngredientConstructorTest(){
        IngredientDto ingredient = new IngredientDto(validQuantity, validMeasure, productDto);
        Assertions.assertEquals(ingredient.getQuantity(), validQuantity);
        Assertions.assertEquals(ingredient.getMeasure(), validMeasure);
        Assertions.assertEquals(ingredient.getIngredient(), productDto);
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void IngredientConstructorQuantityNullTest(){
       new IngredientDto(null, validMeasure, productDto);
        Assertions.fail("The quantity value cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void IngredientConstructorMeasureNullTest(){
        new IngredientDto(validQuantity, null, productDto);
        Assertions.fail("The measure value must be set");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void IngredientConstructorNullProductTest(){
        new IngredientDto(validQuantity, validMeasure, null);
        Assertions.fail("The ingredient value cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    void IngredientConstructorInvalidQuantityTest(){
        new IngredientDto(invalidQuantity, validMeasure, productDto);
        Assertions.fail("The quantity value must be positive");
    }
}