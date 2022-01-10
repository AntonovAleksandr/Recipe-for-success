package com.example.tdddevelopment.service.impl.sortings;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.dto.StepDto;
import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.mapper.ProductMapper;
import com.example.tdddevelopment.data.repository.ProductRepository;
import com.example.tdddevelopment.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class SortingBIngredientCountService implements SortingService {

    private int getCount(ProductDto productDto){
        int sum = 0;
        for (StepDto stepDto : productDto.getRecipe()) {
            if (stepDto.getIngredients() != null)
                sum += stepDto.getIngredients().size();
        }
        return sum;
    }

    private boolean invalidProductIngredient(ProductDto productDto){
        return productDto.getRecipe() == null;
    }

    @Override
    public List<ProductDto> getSortedProducts(List<ProductDto> productList, boolean descending) {
        if (productList==null || productList.isEmpty()) return null;
        for (ProductDto element:productList) {
            if(invalidProductIngredient(element)) return null;
        }
        if (descending)
            return productList.stream().sorted((Comparator.comparing(this::getCount).reversed())).collect(Collectors.toList());
        return  productList.stream().sorted((Comparator.comparing(this::getCount))).collect(Collectors.toList());
    }
}
