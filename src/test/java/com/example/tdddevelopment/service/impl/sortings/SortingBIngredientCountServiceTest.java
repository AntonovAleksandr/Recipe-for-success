package com.example.tdddevelopment.service.impl.sortings;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.dto.StepDto;
import com.example.tdddevelopment.data.entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortingBIngredientCountServiceTest {

    @Mock
    private static SortingBIngredientCountService sortingBIngredientCountService;

    private List<ProductDto> unsortedProducts;
    private List<ProductDto> sortedProducts;
    private List<ProductDto> sortedByDiscProducts;
    private List<ProductDto> nullIngredientsProduct;
    private List<ProductDto> emptyIngredientsProduct;
    private List<ProductDto> nullIngredientsResult;
    private List<ProductDto> nullIngredientsDescResult;

    @BeforeEach
    private void setUp() {
        sortingBIngredientCountService = new SortingBIngredientCountService();
        ProductDto product1 = new ProductDto()
                .withTitle("Коньяк");
        ProductDto product2 = new ProductDto()
                .withTitle("Виски");
        ProductDto product3 = new ProductDto()
                .withTitle("Вино");
        ProductDto product4 = new ProductDto().
                withTitle("Пина колада");
        ProductDto product5 = new ProductDto().
                withTitle("Бренди");

        product1.setRecipe(List.of(new StepDto()));
        product2.setRecipe(List.of(new StepDto().
                withIngredients(new ArrayList<>())));
        product3.setRecipe(List.of(new StepDto().
                withIngredients(List.of(new Ingredient()))));
        product4.setRecipe(List.of(new StepDto().
                withIngredients(List.of(new Ingredient(), new Ingredient()))));
        product5.setRecipe(List.of(new StepDto().
                withIngredients(List.of(new Ingredient(), new Ingredient(), new Ingredient()))));


        nullIngredientsProduct = List.of(product1, product4);
        emptyIngredientsProduct = List.of(product4, product2);
        nullIngredientsDescResult = List.of(product4, product1);
        nullIngredientsResult = List.of(product1, product4);
        unsortedProducts = List.of(product3, product1, product4, product5);
        sortedProducts = List.of(product1, product3, product4, product5);
        sortedByDiscProducts = List.of(product5, product4, product3, product1);
    }


    @Test
    @DisplayName("Sort null")
    void nullSortTest() {
        assertNull(sortingBIngredientCountService.getSortedProducts(null, true));
    }

    @Test
    @DisplayName("Sort empty list")
    void sortEmptyListTest() {
        assertNull(sortingBIngredientCountService.getSortedProducts(new ArrayList<>(), true));
    }

    @Test
    @DisplayName("Sort empty ingredients of recipe")
    void emptyIngredientsSortTest() {
        assertEquals(sortingBIngredientCountService.getSortedProducts(emptyIngredientsProduct, true), emptyIngredientsProduct);
    }

    @Test
    @DisplayName("Sort null ingredients list")
    void sortEmptyIngredientsListTest() {
        assertEquals(nullIngredientsResult, sortingBIngredientCountService.getSortedProducts(nullIngredientsProduct, false));
    }

    @Test
    @DisplayName("Sort desc null ingredients list")
    void sortDiscEmptyIngredientsListTest() {
        assertEquals(nullIngredientsDescResult, sortingBIngredientCountService.getSortedProducts(nullIngredientsProduct, true));
    }

    @Test
    @DisplayName("Sort products disc")
    void sortProductsDiscTest() {
        assertEquals(sortedByDiscProducts, sortingBIngredientCountService.getSortedProducts(unsortedProducts, true));
    }

    @Test
    @DisplayName("Sort products")
    void sortProductsTest() {
        assertEquals(sortedProducts, sortingBIngredientCountService.getSortedProducts(unsortedProducts, false));
    }
}