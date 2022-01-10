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
    @Column(name = "search_frequency")
    private Long searchFrequency;
    @Column(name = "is_favorite")
    private Boolean isFavorite;
    @Column(name = "min_price")
    private Double minPrice;
    @Column(name = "max_price")
    private Double maxPrice;
    @Column(name = "title")
    private String title;
    @Column(name = "img")
    private String img;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private List<Step> recipe;
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<Ingredient> containsIn;
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<StorageElement> productsInStorage;

}
