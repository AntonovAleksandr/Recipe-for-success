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
    private List<StepDto> steps;
    private ProductDto ingredient;

    @SneakyThrows
    public void setQuantity(Double quantity) {
        if (quantity == null)
            throw new BusinessException("The quantity value cannot be null");
        this.quantity = quantity;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public void setIngredient(ProductDto ingredient) {
        this.ingredient = ingredient;
    }

    @SneakyThrows
    public IngredientDto(Double quantity, Measure measure, ProductDto ingredient) {
        if (quantity == null)
            throw new BusinessException("The quantity value cannot be null");
        if (quantity < 0) {
            throw new BusinessException("The quantity value must be positive");
        }
        if (quantity > 0 && measure == null) {
            throw new BusinessException("The measure value must be set");
        }
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }
}

