package com.example.tdddevelopment.service.impl.sortings;

import com.example.tdddevelopment.data.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortingBIngredientCountServiceTest {

    @Mock
    private static SortingBIngredientCountService sortingBIngredientCountService;

    @BeforeEach
    private void init() {
        sortingBIngredientCountService = new SortingBIngredientCountService();
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
    @DisplayName("Sort products")
    void sortProductsTest() {
        sortingBIngredientCountService.getSortedProducts(new ArrayList<>(), true);
    }
}