package com.example.tdddevelopment.service;

import com.example.tdddevelopment.data.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SortingService {
    List<ProductDto> getSortedProducts(List<ProductDto> productList, boolean descending);
}
