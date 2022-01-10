package com.example.tdddevelopment.service.impl.sortings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;

class SortingByFrequencySearchingServiceTest {

    @Mock
    private static SortingByFrequencySearchingService sortingByFrequencySearchingService;

    @BeforeEach
    private void init() {
        sortingByFrequencySearchingService = new SortingByFrequencySearchingService();
    }
    @Test
    @DisplayName("Sort null")
    void nullSortTest() {
        assertNull(sortingByFrequencySearchingService.getSortedProducts(null, true));
    }

    @Test
    @DisplayName("Sort empty list")
    void sortEmptyListTest() {
        assertNull(sortingByFrequencySearchingService.getSortedProducts(new ArrayList<>(), true));
    }

    @Test
    @DisplayName("Sort products")
    void sortProductsTest() {
        sortingByFrequencySearchingService.getSortedProducts(new ArrayList<>(), true);
    }
}