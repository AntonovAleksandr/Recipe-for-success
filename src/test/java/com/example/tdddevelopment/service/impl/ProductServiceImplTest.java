package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.repository.ProductRepository;
import com.example.tdddevelopment.data.repository.StorageElementRepository;
import com.example.tdddevelopment.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private static ProductRepository productRepository;
    @Mock
    private static StorageElementRepository storageElementRepository;

    @InjectMocks
    private ProductService productService;

//    @BeforeEach
//    private void init() {
//        productService = new ProductServiceImpl(productService, storageElementRepository);
//    }

    @Test
    void sort() {
    }

    @Test
    void getProducts() {
    }

    @Test
    void getFavouriteProducts() {
    }

    @Test
    void saveProduct() {
    }

    @Test
    void testSort() {
    }
}