package com.example.tdddevelopment.service.impl.sortings;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.mapper.ProductMapper;
import com.example.tdddevelopment.data.repository.ProductRepository;
import com.example.tdddevelopment.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingByPriceService implements SortingService {
    @Override
    public List<ProductDto> getSortedProducts(List<ProductDto> productList, boolean descending) {
        if (productList==null || productList.isEmpty()) return null;
        if (descending) return productList.stream().sorted(Comparator.comparing(ProductDto::getMaxPrice)).distinct().collect(Collectors.toList());
        return  productList.stream().sorted((Comparator.comparing(ProductDto::getMinPrice))).collect(Collectors.toList());
//        return ProductMapper.INSTANCE.productToDto(productRepository.findByOrderByMinPriceDesc());
    }
}
