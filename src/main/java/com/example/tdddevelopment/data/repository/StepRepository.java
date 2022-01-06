package com.example.tdddevelopment.data.repository;
import com.example.tdddevelopment.data.entity.Step;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StepRepository extends PagingAndSortingRepository<Step, Long>{

}