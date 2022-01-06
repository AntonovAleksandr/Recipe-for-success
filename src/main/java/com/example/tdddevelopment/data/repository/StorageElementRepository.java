package com.example.tdddevelopment.data.repository;

import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.entity.StorageElement;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageElementRepository extends PagingAndSortingRepository<StorageElement, Long> {
    List<StorageElement> findAll();
}
