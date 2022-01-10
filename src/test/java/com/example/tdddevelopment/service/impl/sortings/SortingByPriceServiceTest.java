package com.example.tdddevelopment.service.impl.sortings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortingByPriceServiceTest {

    @Mock
    private static SortingByPriceService sortingByPriceService;

    @BeforeEach
    private void init() {
    }

    @Test
    @DisplayName("Sort null")
    void nullSortTest() {
        assertNull(sortingByPriceService.getSortedProducts(null, true));
    }

    @Test
    @DisplayName("Sort empty list")
    void sortEmptyListTest() {
        assertNull(sortingByPriceService.getSortedProducts(new ArrayList<>(), true));
    }

    @Test
    @DisplayName("Sort products")
    void sortProductsTest() {
        sortingByPriceService.getSortedProducts(new ArrayList<>(), true);
    }
}