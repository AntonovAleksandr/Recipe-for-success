package com.example.tdddevelopment.data.entity;

import com.example.tdddevelopment.data.excepptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<Step> recipe;
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<Ingredient> containsIn;

    @SneakyThrows
    public Product(String title, List<Step> recipe) {
        if(recipe.isEmpty()){
            throw new BusinessException("The recipe must contain at least one step");
        }
        this.title = title;
        this.recipe = recipe;
    }
}
