package com.example.tdddevelopment.data.repository;

import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.entity.Step;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
