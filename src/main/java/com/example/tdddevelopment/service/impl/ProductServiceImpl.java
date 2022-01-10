package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.dto.StepDto;
import com.example.tdddevelopment.data.dto.StorageElementDto;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.entity.Step;
import com.example.tdddevelopment.data.mapper.ProductMapper;
import com.example.tdddevelopment.data.mapper.StepMapper;
import com.example.tdddevelopment.data.mapper.StorageElementMapper;
import com.example.tdddevelopment.data.repository.ProductRepository;
import com.example.tdddevelopment.data.repository.StepRepository;
import com.example.tdddevelopment.data.repository.StorageElementRepository;
import com.example.tdddevelopment.service.ProductService;
import com.example.tdddevelopment.service.SortingService;
import com.example.tdddevelopment.service.impl.sortings.SortingBIngredientCountService;
import com.example.tdddevelopment.service.impl.sortings.SortingByFrequencySearchingService;
import com.example.tdddevelopment.service.impl.sortings.SortingByPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final Map<String, SortingService> sorting = new HashMap<>();
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StepRepository stepRepository;
    @Autowired
    private StorageElementRepository storageElementRepository;

    public ProductServiceImpl() {
        add("Price", new SortingByPriceService());
        add("Ingredient", new SortingBIngredientCountService());
        add("Frequency", new SortingByFrequencySearchingService());
    }

    private void add(String sortName, SortingService sorting){
        this.sorting.put(sortName,sorting);
    }

    @Override
    public List<ProductDto> getAllProductsOrderedBy(String sortName, boolean descending) {
        List<ProductDto> allProducts = ProductMapper.INSTANCE.productToDto(productRepository.findAll());
        return sorting.get(sortName).getSortedProducts(allProducts, descending);
    }

    @Override
    public List<ProductDto> getProductsOrderedBy(List<ProductDto> productList, String sortName, boolean descending){
        return sorting.get(sortName).getSortedProducts(productList, descending);
    }
    @Override
    public List<ProductDto> getAllProducts() {
        return ProductMapper.INSTANCE.productToDto(productRepository.findAll());
    }

    public List<ProductDto> getFavouriteProducts() {
        return ProductMapper.INSTANCE.productToDto(productRepository.findByIsFavoriteIsTrue());
    }
    @Override
    public void saveProduct(ProductDto productDto){
        productRepository.save(ProductMapper.INSTANCE.dtoToProduct(productDto));
    }

    @Override
    public ProductDto getProduct(Long id) {
        return ProductMapper.INSTANCE.productToDto(productRepository.findById(id).orElseThrow());
    }
    @Override
    public List<StorageElementDto> getBarProducts(){
        return StorageElementMapper.INSTANCE.storageElementToDto(storageElementRepository.findAll());
    }

    @Override
    public void generateNewProductTemplate() {
        if (!containsTemplate())
            saveProduct(new ProductDto("", List.of(new StepDto(1L)), -1L));
    }

    public void saveNewProductTemplate() {
        Optional<Product> productTemplate = productRepository.findBySearchFrequency(-1L);
        productTemplate.orElseThrow().setSearchFrequency(0L);
        productRepository.save(productTemplate.orElseThrow());
    }

    @Override
    public void removeProductTemplate(){
        if (containsTemplate()){
            Optional<Product> productTemplate = productRepository.findBySearchFrequency(-1L);
            productRepository.deleteById(productTemplate.orElseThrow().getId());
        }

    }

    @Override
    public ProductDto getProductTemplate(){
        Optional<Product> productTemplate = productRepository.findBySearchFrequency(-1L);
        return ProductMapper.INSTANCE.productToDto(productTemplate.orElseThrow());
    }

    @Override
    public void addNewStepTemplate(Long id) {
        if (productRepository.existsById(id)) {
            Product template = productRepository.findById(id).orElse(null);
            assert template != null;
            List<Step> recipe = template.getRecipe();
            Long newNumber = recipe.get(recipe.size() - 1).getNumber() + 1L;
            Step stepTemplate = StepMapper.INSTANCE.dtoToStep(new StepDto(newNumber));
            recipe.add(stepTemplate);
            template.setRecipe(recipe);
            productRepository.save(template);
            stepRepository.save(stepTemplate);


        }
    }

    @Override
    public boolean containsTemplate() {
        return productRepository.findBySearchFrequency(-1L).isPresent();
    }

    @Override
    public void incrementFrequencyById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setSearchFrequency(product.getSearchFrequency()+1);
        productRepository.save(product);
    }

    @Override
    public void changeFavorite(Long id, boolean isFavorite) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setIsFavorite(isFavorite);
        productRepository.save(product);
    }
//
//    @Override
//    public void addNewStepTemplate(ProductDto productDto) {
//        Optional<Product> productTemplate = productRepository.findBySearchFrequency(-1L);
//    }
//
//    private void saveStep(Long productId, StepDto stepDto){
//        stepRepository.save(StepMapper.INSTANCE.dtoToStep(stepDto));
//        stepRepository.find
//    }
}
