package com.example.tdddevelopment;
import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.enums.Measure;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
public class EntitiesTests {
//    @Test
//    void ProductConstructorTest(){
//        Product product = new Product();
//    }
    @Test
    void StepConstructorTest(){
        Ingredient ingredient = new Ingredient(2.0, Measure.KILOGRAM.toString());
        assert ingredient.getQuantity() > 0;
        assert ingredient.getMeasure() != null;
    }

    @Test
    void StepConstructorNegativeTest(){
        Ingredient ingredient = new Ingredient(-2.0, Measure.KILOGRAM.toString());
        assert ingredient.getQuantity() > 0;
        assert ingredient.getMeasure() != null;
    }

}
