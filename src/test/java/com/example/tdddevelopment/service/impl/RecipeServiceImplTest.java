package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {
    @Test
    void getFavouriteProducts() {
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        List<ProductDto> productDtos = recipeService.getFavouriteProducts();
        for (ProductDto productDto : productDtos) {
            assert productDto.getIsFavorite();
        }
    }
}