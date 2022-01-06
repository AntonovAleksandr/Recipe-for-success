package com.example.tdddevelopment.service;

import com.example.tdddevelopment.data.entity.Product;

import java.util.List;

public interface FilteringService {
    List<Product> priceFilter(double min, double max);
    List<Product> ingredientFilter(List<String> names);
}
