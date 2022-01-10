package com.example.tdddevelopment.service.vew_items;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.service.CheckAbilityToCookService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecipeVewItem {
    private ProductDto product;
    private boolean canBeCooked;
    private boolean isEndOfRow;
}
