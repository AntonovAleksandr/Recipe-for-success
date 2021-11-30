package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.enums.Measure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {
    private Long id;
    private Double quantity;
    private Measure measure;
    private List<Step> steps;
    private Product product;
}
