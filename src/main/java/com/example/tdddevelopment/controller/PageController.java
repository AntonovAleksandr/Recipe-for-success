package com.example.tdddevelopment.controller;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.entity.Ingredient;
import com.example.tdddevelopment.service.CheckAbilityToCookService;
import com.example.tdddevelopment.service.ProductService;
import com.example.tdddevelopment.service.vew_items.RecipeVewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class PageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CheckAbilityToCookService checkAbilityToCookService;

    @RequestMapping(value = "/recipePage", method = RequestMethod.POST)
    public ModelAndView recipePage( @RequestParam("id") Long id) {
        productService.incrementFrequencyById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recipePage");
        ProductDto product = productService.getProduct(id);
        List<Ingredient> ingredientsDto = new ArrayList<>();
        product.getRecipe().forEach(e ->  ingredientsDto.addAll(e.getIngredients()));
        modelAndView.addObject("product", product);
        if (!ingredientsDto.isEmpty())
            modelAndView.addObject("isIngredient", false);
        modelAndView.addObject("ingredients", ingredientsDto);

        return modelAndView;
    }

    @RequestMapping(value = "/barPage", method = RequestMethod.GET)
    public ModelAndView barPage() {
        productService.removeProductTemplate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("barPage");
        modelAndView.addObject("bar", productService.getBarProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/personalAccountPage", method = RequestMethod.GET)
    public ModelAndView personalAccountPage() {
        productService.removeProductTemplate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personalAccountPage");
        modelAndView.addObject("favourites", checkAbilityToCookService.getRecipeVews(productService.getFavouriteProducts()));
        modelAndView.addObject("bar", productService.getBarProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/barPage/add", method = RequestMethod.POST)
    public ModelAndView barAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recipePage");
        modelAndView.addObject("prodict", productService.getAllProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/favorite", method = RequestMethod.GET)
    public ModelAndView barAddPage(
            @RequestParam("favorite") Optional<Boolean> favorite,
            @RequestParam("id") Long id

    ) {
        boolean fav = favorite.isPresent();
        productService.changeFavorite(id, fav);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        String sortType = "Frequency";
        List<RecipeVewItem> products = checkAbilityToCookService.getRecipeVews(productService.getAllProductsOrderedBy(sortType, false));
        modelAndView.addObject("products", products);
        modelAndView.addObject("desc", false);
        modelAndView.addObject("sortType", sortType);
        return modelAndView;
    }

    @RequestMapping(value = "/personalAccountPage", method = RequestMethod.POST)
    public ModelAndView personalAccountPage(
            @RequestParam("favorite") Optional<Boolean> favorite,
            @RequestParam("id") Long id
    ) {
        boolean fav = favorite.isPresent();
        productService.changeFavorite(id, fav);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personalAccountPage");
        modelAndView.addObject("favourites", checkAbilityToCookService.getRecipeVews(productService.getFavouriteProducts()));
        modelAndView.addObject("bar", productService.getBarProducts());
        return modelAndView;
    }


}
