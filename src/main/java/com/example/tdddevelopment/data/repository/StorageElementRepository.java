package com.example.tdddevelopment.data.repository;

import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.entity.StorageElement;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StorageElementRepository extends PagingAndSortingRepository<StorageElement, Long> {

}
