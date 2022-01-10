package com.example.tdddevelopment.service.impl.sortings;

import com.example.tdddevelopment.data.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SortingByFrequencySearchingServiceTest {

    @Mock
    private static SortingByFrequencySearchingService sortingByFrequencySearchingService;

    private List<ProductDto> unsortedProducts;
    private List<ProductDto> sortedProducts;
    private List<ProductDto> sortedByDiscProducts;

    @BeforeEach
    private void setUp() {
        sortingByFrequencySearchingService = new SortingByFrequencySearchingService();
        ProductDto product1 = new ProductDto()
                .withTitle("Коньяк")
                .withMaxPrice(15000.0)
                .withMinPrice(1500.0)
                .withSearchFrequency(18L);
        ProductDto product2 = new ProductDto()
                .withTitle("Виски")
                .withMaxPrice(12000.0)
                .withMinPrice(700.0)
                .withSearchFrequency(14L);
        ProductDto product3 = new ProductDto()
                .withTitle("Вино")
                .withMaxPrice(14000.0)
                .withMinPrice(300.0)
                .withSearchFrequency(7L);
        ProductDto product4 = new ProductDto()
                .withTitle("Бренди")
                .withMaxPrice(14000.0)
                .withMinPrice(300.0)
                .withSearchFrequency(7L);
        ProductDto product5 = new ProductDto().
                withTitle("Пина колада")
                .withMaxPrice(1200.0)
                .withMinPrice(200.0)
                .withSearchFrequency(5L);
        unsortedProducts = List.of(product1, product2, product5, product4, product3);
        sortedProducts = List.of(product5, product4, product3, product2, product1);
        sortedByDiscProducts = List.of(product1, product2, product3, product4, product5);
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
    @DisplayName("Sort products disc")
    void sortProductsDiscTest() {
        assertEquals(sortedByDiscProducts, sortingByFrequencySearchingService.getSortedProducts(unsortedProducts, true));
    }

    @Test
    @DisplayName("Sort products")
    void sortProductsTest() {
        assertEquals(sortedProducts, sortingByFrequencySearchingService.getSortedProducts(unsortedProducts, false));
    }
}