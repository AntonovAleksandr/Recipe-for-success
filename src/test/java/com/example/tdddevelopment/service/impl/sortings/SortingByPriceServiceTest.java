package com.example.tdddevelopment.service.impl.sortings;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.entity.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortingByPriceServiceTest {

    @Mock
    private static SortingByPriceService sortingByPriceService;

    private List<ProductDto> unsortedProducts;
    private List<ProductDto> sortedProducts;
    private List<ProductDto> sortedByDiscProducts;

    @BeforeEach
    private void setUp() {
        sortingByPriceService = new SortingByPriceService();
        ProductDto product1 = new ProductDto()
                .withTitle("Коньяк")
                .withMaxPrice(15000.0)
                .withMinPrice(1500.0);
        ProductDto product2 = new ProductDto()
                .withTitle("Виски")
                .withMaxPrice(12000.0)
                .withMinPrice(700.0);
        ProductDto product3 = new ProductDto()
                .withTitle("Вино")
                .withMaxPrice(14000.0)
                .withMinPrice(300.0);
        ProductDto product4 = new ProductDto().
                withTitle("Пина колада")
                .withMaxPrice(1200.0)
                .withMinPrice(200.0);

        unsortedProducts = List.of(product1, product2, product3, product4);
        sortedProducts = List.of(product4, product3, product2, product1);
        sortedByDiscProducts = List.of(product1, product3, product2, product4);
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
    @DisplayName("Sort products disc")
    void sortProductsDiscTest() {
        assertEquals(sortedByDiscProducts, sortingByPriceService.getSortedProducts(unsortedProducts, true));
    }

    @Test
    @DisplayName("Sort products")
    void sortProductsTest() {
        assertEquals(sortedProducts, sortingByPriceService.getSortedProducts(unsortedProducts, false));
    }
}