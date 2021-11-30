package com.example.tdddevelopment.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    private Long id;
    private String title;
    private List<StepDto> recipe;
}
