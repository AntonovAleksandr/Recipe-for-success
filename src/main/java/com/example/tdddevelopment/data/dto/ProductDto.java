package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.entity.StorageElement;
import com.example.tdddevelopment.data.excepptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    private Long id;
    private String title;
    private Boolean is_favorite;
    private List<StorageElementDto> productsInStorage;
    private List<StepDto> recipe;
    private List<Ingredient> containsIn;


    @SneakyThrows
    public ProductDto(String title, List<StepDto> recipe) {
//        if(recipe.isEmpty()){
//            throw new BusinessException("The recipe must contain at least one step");
//        }
        this.title = title;
        this.recipe = recipe;
    }
}
