package com.example.tdddevelopment.service;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.service.vew_items.RecipeVewItem;

import java.util.List;

public interface CheckAbilityToCookService {
    List<RecipeVewItem> getRecipeVews(List<ProductDto> products);

    RecipeVewItem getRecipeVew(ProductDto product);
}
