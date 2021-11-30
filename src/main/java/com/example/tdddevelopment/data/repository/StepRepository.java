package com.example.tdddevelopment.data.repository;
import com.example.tdddevelopment.data.entity.Step;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;

public interface StepRepository extends PagingAndSortingRepository<Step, Long>{
    Optional<Step> findById(Long id);
}