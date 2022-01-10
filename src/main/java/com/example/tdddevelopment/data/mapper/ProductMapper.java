package com.example.tdddevelopment.data.mapper;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto productToDto(Product product);
    List<ProductDto> productToDto(Iterable<Product> products);
    Product dtoToProduct(ProductDto dto);
    List<Product> dtoToProduct(Iterable<ProductDto> dtoIterable);
}