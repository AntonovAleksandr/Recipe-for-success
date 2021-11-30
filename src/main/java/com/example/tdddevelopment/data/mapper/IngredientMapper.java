package com.example.tdddevelopment.data.mapper;

import com.example.tdddevelopment.data.dto.IngredientDto;
import com.example.tdddevelopment.data.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);
    IngredientDto ingredientToDto(Ingredient ingredient);
    List<IngredientDto> ingredientToDto(Iterable<Ingredient> ingredients);
    Ingredient dtoToIngredient(IngredientDto dto);
    List<Ingredient> dtoToIngredient(Iterable<IngredientDto> dtoIterable);
}
