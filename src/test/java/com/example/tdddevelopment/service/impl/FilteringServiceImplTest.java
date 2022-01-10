package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.service.FilteringService;
import com.example.tdddevelopment.service.impl.sortings.SortingBIngredientCountService;
import com.example.tdddevelopment.service.impl.sortings.SortingByFrequencySearchingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilteringServiceImplTest {

    @Mock
    private static FilteringService filteringService;

    @BeforeEach
    private void init() {
        filteringService = new FilteringServiceImpl();
    }


    @Test
    @DisplayName("Price filter null filtering")
    void priceFilterNullTest() {
        assertNull(filteringService.priceFilter(null, 0, 1));
    }

    @Test
    @DisplayName("Price filter min > max filtering")
    void priceFilterMaxLowerMinTest() {
        assertNull(filteringService.priceFilter(null, 0, 1));
    }

    @Test
    @DisplayName("Price filter 0 > max ")
    void priceFilterMaxLowerZeroTest() {
        assertNull(filteringService.priceFilter(null, -20, -11));
    }

    @Test
    @DisplayName("Ingredient filter null products filtering")
    void ingredientFilterNullProductsTest() {
        assertNull(filteringService.ingredientFilter(null, new ArrayList<>()));
    }

    @Test
    @DisplayName("Ingredient filter null filtering")
    void ingredientFilterNullIngredientsTest() {
        assertNull(filteringService.ingredientFilter(null, new ArrayList<>()));
    }

    @Test
    @DisplayName("Ingredient filter empty products filtering")
    void ingredientFilterEmptyProductsTest() {
        assertNull(filteringService.ingredientFilter(new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    @DisplayName("Ingredient filter empty ingredients filtering")
    void ingredientFilterEmptyIngredientsTest() {
        assertNull(filteringService.ingredientFilter(null, new ArrayList<>()));
    }

    @Test
    @DisplayName("Title filter null products filtering")
    void titleFilterNullProductsTest() {
        assertNull(filteringService.titleFilter(null, " ", false));
    }

    @Test
    @DisplayName("Title filter null title filtering")
    void titleFilterNullTitleTest() {
        assertNull(filteringService.titleFilter(null, null, false));
    }

    @Test
    @DisplayName("Title filter empty products filtering")
    void titleFilterEmptyProductsTest() {
        assertNull(filteringService.titleFilter(new ArrayList<>(), " ", false));
    }

    @Test
    @DisplayName("Title filter empty title filtering")
    void titleFilterEmptyTitleTest() {
        assertNull(filteringService.titleFilter(null, "", false));
    }
}