package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.service.FilteringService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringServiceImpl implements FilteringService {

    private boolean between(ProductDto productDto, double min, double max) {
        if (productDto == null) return false;
        return !(productDto.getMaxPrice() < min) || !(productDto.getMinPrice() > max);
    }


    @Override
    public List<ProductDto> priceFilter(List<ProductDto> products, double min, double max) {
        if (products == null || products.isEmpty() || min < max || max < 0) return null;
        return products.stream().filter(e -> between(e, min, max)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> ingredientFilter(List<ProductDto> products, List<String> ingredientsTitles) {
        if (products == null || products.isEmpty() || ingredientsTitles == null || ingredientsTitles.isEmpty())
            return null;
        return null;
        //return products.stream().filter(e -> e.getRecipe().size() ).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> titleFilter(List<ProductDto> products, String title, boolean fullCoincidence) {
        if (products == null || products.isEmpty() || title == null) return null;
        if (title.isEmpty()) return products;
        if (fullCoincidence)
            return products.stream().filter(e -> e.getTitle().equals(title)).collect(Collectors.toList());
        return products.stream().filter(e -> e.getTitle().contains(title) || title.contains(e.getTitle())).collect(Collectors.toList());
    }
}
