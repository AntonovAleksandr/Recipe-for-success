package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.mapper.ProductMapper;
import com.example.tdddevelopment.data.repository.ProductRepository;
import com.example.tdddevelopment.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getFavouriteProducts() {
        return ProductMapper.INSTANCE.productToDto(productRepository.findByIsFavoriteIsTrue());
    }
}
