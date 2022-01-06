package com.example.tdddevelopment.controller;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/app")
public class RecipeController {
//    @Autowired
//    private ProductService productService;
//
//    @RequestMapping(value = "/mainPage/sort", method = RequestMethod.GET)
//    public ModelAndView mainPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("mainPage");
//        modelAndView.addObject("products",  productService.getProducts());
//        return modelAndView;
//    }

//    @RequestMapping(value = "/newProductPage/add", method = RequestMethod.POST)
//    public ModelAndView addRecipe(
//            @RequestParam("title") String title,
//            @RequestParam("product_img") String productImg,
//            @RequestParam("ingredient_title") String ongredient_title,
//            @RequestParam("min_price") Double minPrice,
//            @RequestParam("max_price") Double maxPrice,
//            @RequestParam("ingredient_img") String ingredientImg,
//            @RequestParam("desc") String desc
//    ) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("newProductPage");
//
//        productService.saveProduct();
//        if (!title.equals("") && minPrice > 0 && maxPrice > minPrice) {
//            ProductDto productDto = new ProductDto(title, img, minPrice, maxPrice);
//            productService.saveProduct(productDto);
//        }
//        modelAndView.addObject("products", productService.getProducts());
//
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/newProductPage/addStep", method = RequestMethod.POST)
//    public ModelAndView addStep(
//            @RequestParam("img") String img,
//            @RequestParam("desc") String minPrice,
//            @RequestParam("max_price") Double maxPrice,
//            @RequestParam("template") ProductDto template
//    ) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("newProductPage");
//        productService.addNewStepTemplate(template);
//        modelAndView.addObject("template", productService.addNewStepTemplate());
//        return modelAndView;
//    }

//    @RequestMapping(value = "/newProductPage/removeStep", method = RequestMethod.POST)
//    public ModelAndView removeStep(
//            @RequestParam("number") Long number
//    ) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("newProductPage");
//
//        modelAndView.addObject("products", productService.getProducts());
//        return modelAndView;
//    }


}
