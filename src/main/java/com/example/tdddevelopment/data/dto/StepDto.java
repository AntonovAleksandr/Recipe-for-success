package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.enums.Measure;
import com.example.tdddevelopment.data.excepptions.BusinessException;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepDto {
    private Long id;
    private Long number;
    private String img;
    private String desc;

    private Product recipeOf;
    private List<Ingredient> ingredients;

    @SneakyThrows
    public StepDto(Long number) {
        if (number == null)
            throw new BusinessException("Number cannot be null");
        if (number <= 0L)
            throw new BusinessException("Number cannot be less than one");
        this.number = number;
        this.desc = "";
    }
    @SneakyThrows
    public StepDto(Long number, String desc) {
        if (number == null)
            throw new BusinessException("Number cannot be null");
        if (number <= 0L)
            throw new BusinessException("Number cannot be less than one");
        if (desc == null)
            throw new BusinessException("Description cannot be null");
        if (desc.length() > 500)
            throw new BusinessException("Description cannot be longer than 500 characters");
        this.number = number;
        this.desc = desc;
    }

    @SneakyThrows
    public void setDesc(String desc) {
        if (desc == null)
            throw new BusinessException("Description cannot be null");
        if (desc.length() > 500)
            throw new BusinessException("Description cannot be longer than 500 characters");
        this.desc = desc;
    }

    @SneakyThrows
    public void setNumber(Long number) {
        if (number == null)
            throw new BusinessException("Number cannot be null");
        if (number <= 0L)
            throw new BusinessException("Number cannot be less than one");
        this.number = number;
    }
}
