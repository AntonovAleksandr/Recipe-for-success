package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.dto.ProductDto;
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

    private List<ProductDto> unfilteredProducts;
    private List<ProductDto> titleFilterProducts;
    private List<ProductDto> fullTitleFilterProducts;
    private List<ProductDto> priceFilteredProducts;
    private List<String> ingredients;
    private String title;
    private String fullTitle;

    @BeforeEach
    private void init() {
        filteringService = new FilteringServiceImpl();
        ProductDto product1 = new ProductDto()
                .withTitle("Коньяк")
                .withMaxPrice(20.0)
                .withMinPrice(10.0)
                .withSearchFrequency(18L);
        ProductDto product2 = new ProductDto()
                .withTitle("Виски")
                .withMaxPrice(25.0)
                .withMinPrice(15.0)
                .withSearchFrequency(14L);
        ProductDto product3 = new ProductDto()
                .withTitle("Вино")
                .withMaxPrice(27.0)
                .withMinPrice(24.0)
                .withSearchFrequency(7L);
        ProductDto product4 = new ProductDto()
                .withTitle("Бренди")
                .withMaxPrice(35.0)
                .withMinPrice(25.0)
                .withSearchFrequency(7L);
        ProductDto product5 = new ProductDto().
                withTitle("Пина колада")
                .withMaxPrice(40.0)
                .withMinPrice(30.0)
                .withSearchFrequency(5L);

        ingredients = List.of("Виски", "Бренди");
        unfilteredProducts = List.of(product1, product2, product3, product4, product5);
        titleFilterProducts = List.of(product2, product3);
        fullTitleFilterProducts = List.of(product3);
        priceFilteredProducts = List.of(product2, product3, product4);
        title = "Ви";
        fullTitle = "Вино";
    }


    @Test
    @DisplayName("Price filter null filtering")
    void priceFilterNullTest() {
        assertNull(filteringService.priceFilter(null, 0, 1));
    }

    @Test
    @DisplayName("Price filter min < max filtering")
    void priceFilterMaxLowerMinTest() {
        assertNull(filteringService.priceFilter(unfilteredProducts, 2, 1));
    }

    @Test
    @DisplayName("Price filter 0 > max ")
    void priceFilterMaxLowerZeroTest() {
        assertNull(filteringService.priceFilter(unfilteredProducts, -20, -11));
    }

    @Test
    @DisplayName("Price filter")
    void priceFilterTest() {
        assertEquals(priceFilteredProducts, filteringService.priceFilter(unfilteredProducts, 21, 29));
    }

    @Test
    @DisplayName("Ingredient filter null products filtering")
    void ingredientFilterNullProductsTest() {
        assertNull(filteringService.ingredientFilter(null, new ArrayList<>()));
    }

    @Test
    @DisplayName("Ingredient filter null filtering")
    void ingredientFilterNullIngredientsTest() {
        assertNull(filteringService.ingredientFilter(null, ingredients));
    }

    @Test
    @DisplayName("Ingredient filter empty products filtering")
    void ingredientFilterEmptyProductsTest() {
        assertNull(filteringService.ingredientFilter(new ArrayList<>(), ingredients));
    }

    @Test
    @DisplayName("Ingredient filter empty ingredients filtering")
    void ingredientFilterEmptyIngredientsTest() {
        assertNull(filteringService.ingredientFilter(unfilteredProducts, new ArrayList<>()));
    }

    @Test
    @DisplayName("Title filter null products filtering")
    void titleFilterNullProductsTest() {
        assertNull(filteringService.titleFilter(null, title, false));
    }

    @Test
    @DisplayName("Title filter products filtering")
    void titleFilteredProductsTest() {
        assertEquals(titleFilterProducts, filteringService.titleFilter(unfilteredProducts, title, false));
    }

    @Test
    @DisplayName("itle filter full cons products filtering")
    void fullTitleFilteredProductsTest() {
        assertEquals(fullTitleFilterProducts, filteringService.titleFilter(unfilteredProducts, fullTitle, true));
    }

    @Test
    @DisplayName("Title filter null title filtering")
    void titleFilterNullTitleTest() {
        assertNull(filteringService.titleFilter(unfilteredProducts, null, false));
    }

    @Test
    @DisplayName("Title filter empty products filtering")
    void titleFilterEmptyProductsTest() {
        assertNull(filteringService.titleFilter(new ArrayList<>(), " ", false));
    }

    @Test
    @DisplayName("Title filter empty title filtering")
    void titleFilterEmptyTitleTest() {
        assertEquals(unfilteredProducts, filteringService.titleFilter(unfilteredProducts, "", false));
    }
}