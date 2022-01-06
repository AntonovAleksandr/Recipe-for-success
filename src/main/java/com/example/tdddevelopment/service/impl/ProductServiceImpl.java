package com.example.tdddevelopment.service.impl;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.dto.StepDto;
import com.example.tdddevelopment.data.dto.StorageElementDto;
import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.mapper.ProductMapper;
import com.example.tdddevelopment.data.mapper.StorageElementMapper;
import com.example.tdddevelopment.data.repository.ProductRepository;
import com.example.tdddevelopment.data.repository.StorageElementRepository;
import com.example.tdddevelopment.service.ProductService;
import com.example.tdddevelopment.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
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
        saveProduct(new ProductDto("", List.of(new StepDto(1L)), -1L));
    }

    public void saveNewProductTemplate() {
        Optional<Product> productTemplate = productRepository.findBySearchFrequency(-1L);
        productTemplate.orElseThrow().setSearchFrequency(0L);
        productRepository.save(productTemplate.orElseThrow());
    }

    @Override
    public void removeProductTemplate(){
        Optional<Product> productTemplate = productRepository.findBySearchFrequency(-1L);
        productRepository.deleteById(productTemplate.orElseThrow().getId());
    }

    @Override
    public ProductDto getProductTemplate(){
        Optional<Product> productTemplate = productRepository.findBySearchFrequency(-1L);
        return ProductMapper.INSTANCE.productToDto(productTemplate.orElseThrow());
    }

    @Override
    public void addNewStepTemplate(ProductDto productDto) {
        Optional<Product> productTemplate = productRepository.findBySearchFrequency(-1L);

    }

}
