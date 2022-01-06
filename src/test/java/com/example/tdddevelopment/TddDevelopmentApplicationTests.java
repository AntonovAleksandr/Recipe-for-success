package com.example.tdddevelopment;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TddDevelopmentApplicationTests {
    @Autowired
    private RecipeService recipeService;

    @Test
    void contextLoads() {
    }

    @Test
    void favoriteProductTest() {
        List<ProductDto> productDtos = recipeService.getFavouriteProducts();
        for (ProductDto productDto : productDtos) {
            assert productDto.getIsFavorite();
        }
    }





}
