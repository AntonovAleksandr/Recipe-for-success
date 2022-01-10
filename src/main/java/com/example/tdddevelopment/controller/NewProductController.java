package com.example.tdddevelopment.controller;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.service.CheckAbilityToCookService;
import com.example.tdddevelopment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app/newProductPage")
public class NewProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CheckAbilityToCookService checkAbilityToCookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView newProductPage() {
        productService.generateNewProductTemplate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newProductPage");
        ProductDto productDto = productService.getProductTemplate();
        modelAndView.addObject("template", productDto);
        modelAndView.addObject("isEmpty", productDto.getRecipe().isEmpty());
        return modelAndView;
    }
    @RequestMapping(value = "/removeStep", method = RequestMethod.POST)
    public ModelAndView removeStep(
            @RequestParam("number") Long number
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newProductPage");

        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/addStep", method = RequestMethod.GET)
    public ModelAndView addStep(
            @RequestParam("id") Long id
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newProductPage");
        productService.addNewStepTemplate(id);
        modelAndView.addObject("template", productService.getProductTemplate());
        return modelAndView;
    }
}
