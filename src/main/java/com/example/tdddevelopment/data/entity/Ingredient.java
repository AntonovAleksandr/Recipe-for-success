package com.example.tdddevelopment.data.entity;

import com.example.tdddevelopment.data.excepptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.sql.PreparedStatement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredients", schema = "public")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "measure")
    private String measure;

    @ManyToMany(mappedBy = "ingredients")
    private List<Step> steps;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product ingredient;

    @SneakyThrows
    public Ingredient(Double quantity, String measure, List<Step> steps) {
        if(quantity < 0){
            throw new BusinessException("The quantity value must be positive");
        }
        if(quantity > 0 && measure == null){
            throw new BusinessException("The measure value must be set");
        }
        this.quantity = quantity;
        this.measure = measure;
        this.steps = steps;
    }

    @SneakyThrows
    public Ingredient(Double quantity, String measure){
        if(quantity < 0){
            throw new BusinessException("The quantity value must be positive");
        }
        if(quantity > 0 && measure.equals("")){
            throw new BusinessException("The measure value must be set");
        }
        this.quantity = quantity;
        this.measure = measure;
    }
}
