package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.enums.Measure;
import com.example.tdddevelopment.data.excepptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {
    private Long id;
    private Double quantity;
    private Measure measure;
    private List<Step> steps;
    private ProductDto ingredient;

    @SneakyThrows
    public IngredientDto(Double quantity, Measure measure, ProductDto ingredient) {
//        if (quantity < 0) {
//            throw new BusinessException("The quantity value must be positive");
//        }
//        if (quantity > 0 && measure == null) {
//            throw new BusinessException("The measure value must be set");
//        }
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }
}

