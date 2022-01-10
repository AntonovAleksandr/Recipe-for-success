package com.example.tdddevelopment.controller;

import com.example.tdddevelopment.service.CheckAbilityToCookService;
import com.example.tdddevelopment.service.ProductService;
import com.example.tdddevelopment.service.vew_items.RecipeVewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app/mainPage")
public class MainPageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CheckAbilityToCookService checkAbilityToCookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        productService.removeProductTemplate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        String sortType = "Frequency";
        List<RecipeVewItem> products = checkAbilityToCookService.getRecipeVews(productService.getAllProductsOrderedBy(sortType, false));
        modelAndView.addObject("products", products);
        modelAndView.addObject("desc", false);
        modelAndView.addObject("sortType", sortType);
        modelAndView.addObject("ingredients", productService.getAllProductsOrderedBy("Frequency", false));
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView mainPageSort(
            @RequestParam("sortType") String sortType,
            @RequestParam("desc") Optional<Boolean> desc,
            @RequestParam("min") Optional<Boolean> min,
            @RequestParam("max") Optional<Boolean> max

            ) {
        boolean descending = desc.isPresent();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        List<RecipeVewItem> products = checkAbilityToCookService.getRecipeVews(productService.getAllProductsOrderedBy(sortType, descending));
        modelAndView.addObject("products", products);
        modelAndView.addObject("desc", descending);
        modelAndView.addObject("sortType", sortType);
        modelAndView.addObject("ingredients", productService.getAllProductsOrderedBy("Frequency", false));
        return modelAndView;
    }
}
