package com.example.tdddevelopment.data.repository;

import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.entity.Step;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findByIsFavoriteIsTrue();
    Optional<Product> findBySearchFrequency(Long searchFrequency);
    Iterable<Product> findByOrderByMaxPrice();
    Iterable<Product> findByOrderByMinPriceDesc();
}
