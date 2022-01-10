package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.entity.StorageElement;
import com.example.tdddevelopment.data.excepptions.BusinessException;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With

public class ProductDto {
    private Long id;
    private Long searchFrequency;
    private String title;
    private String img;
    private Boolean isFavorite;
    private Double minPrice;
    private Double maxPrice;


    private List<StorageElementDto> productsInStorage;
    private List<StepDto> recipe;
    private List<Ingredient> containsIn;

    public ProductDto(String title, String img, Double minPrice, Double maxPrice) {
        this.title = title;
        this.img = img;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.searchFrequency = 0L;
        this.isFavorite = false;
    }
    public void setRecipe(List<StepDto> recipe) {
        this.recipe = recipe;
    }

    @SneakyThrows
    public ProductDto(String title, List<StepDto> recipe, Long searchFrequency) {
        if(recipe.isEmpty()){
            throw new BusinessException("The recipe must contain at least one step");
        }
        this.searchFrequency = searchFrequency;
        this.title = title;
        this.recipe = recipe;
        this.isFavorite = false;
        this.minPrice = 0D;
        this.maxPrice = 0D;
    }

    public void addStep(){

    }

}
