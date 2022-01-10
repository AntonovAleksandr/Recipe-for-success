package com.example.tdddevelopment.service;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.dto.StepDto;
import com.example.tdddevelopment.data.dto.StorageElementDto;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.mapper.ProductMapper;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProductsOrderedBy(String sortName, boolean descending);
    List<ProductDto> getProductsOrderedBy(List<ProductDto> productList, String sortName, boolean descending);

    List<ProductDto> getAllProducts();

    List<ProductDto> getFavouriteProducts();
    void saveProduct(ProductDto productDto);
    ProductDto getProduct(Long id);
    List<StorageElementDto> getBarProducts();
    void generateNewProductTemplate();
    void removeProductTemplate();
    ProductDto getProductTemplate();
    void addNewStepTemplate(Long id);
    boolean containsTemplate();
    void incrementFrequencyById(Long id);

    void changeFavorite(Long id, boolean isFavorite);
}