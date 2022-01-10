package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.repository.StorageElementRepository;
import com.example.tdddevelopment.service.CheckAbilityToCookService;
import com.example.tdddevelopment.service.vew_items.RecipeVewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CheckAbilityToCookServiceImpl implements CheckAbilityToCookService {
    @Autowired
    private StorageElementRepository repository;

    private boolean canBeCooked(Long productId) {
        return false;
    }
    @Override
    public List<RecipeVewItem> getRecipeVews(List<ProductDto> products){
        List<RecipeVewItem> recipeVewItems = new ArrayList<>();
        for (var i = 0; i < products.size(); i++) {
            ProductDto element = products.get(i);
            boolean isRow = i%3==2;
            recipeVewItems.add(new RecipeVewItem(element, canBeCooked(element.getId()), isRow));
        }
        return recipeVewItems;
    }
    @Override
    public RecipeVewItem getRecipeVew(ProductDto product){
        return new RecipeVewItem(product, canBeCooked(product.getId()), false);
    }

}

