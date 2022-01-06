package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.service.FilteringService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilteringServiceImpl implements FilteringService {

    @Override
    public List<Product> priceFilter(double min, double max) {
        return null;
    }

    @Override
    public List<Product> ingredientFilter(List<String> names) {
        return null;
    }
}
