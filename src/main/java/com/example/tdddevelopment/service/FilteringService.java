package com.example.tdddevelopment.service;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.entity.Product;

import java.util.List;

public interface FilteringService {
    List<ProductDto> priceFilter(List<ProductDto> products, double min, double max);
    List<ProductDto> ingredientFilter(List<ProductDto> products, List<String> ingredientsTitles);
    List<ProductDto> titleFilter(List<ProductDto> products, String title, boolean fullCoincidence);

}
