package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.enums.Measure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StepDto {
    private Long id;
    private String img;
    private String desc;
    private Product product;
    private List<Ingredient> ingredients;
}
