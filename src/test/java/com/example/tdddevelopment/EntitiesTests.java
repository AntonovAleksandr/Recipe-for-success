package com.example.tdddevelopment;
import com.example.tdddevelopment.data.dto.IngredientDto;
import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.dto.StepDto;
import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.enums.Measure;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EntitiesTests {
//    @Test
//    void ProductConstructorTest(){
//        Product product = new Product();
//    }
    @Test
    void StepConstructorTest(){
        IngredientDto ingredient = new IngredientDto(2.0, Measure.KILOGRAM, new ProductDto());
        assert ingredient.getQuantity() > 0;
        assert ingredient.getMeasure() != null;
    }

    @Test
    void StepConstructorNegativeTest(){
        IngredientDto ingredient = new IngredientDto(-2.0, Measure.KILOGRAM, new ProductDto());
        assert ingredient.getQuantity() > 0;
        assert ingredient.getMeasure() != null;
    }
    @Test
    void ProductConstructorTest(){
        ProductDto product = new ProductDto("Cola", List.of(new StepDto()));
        assert !product.getRecipe().isEmpty();
    }
    @Test
    void ProductConstructorNegativeTest(){
        ProductDto product = new ProductDto("Cola", new ArrayList<>());
        assert product.getRecipe().isEmpty();
    }

}
