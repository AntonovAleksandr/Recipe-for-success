package com.example.tdddevelopment.data.repository;

import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.data.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long> {
    Optional<Ingredient> findById(Long id);
}
