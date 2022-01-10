package com.example.tdddevelopment.service.impl.sortings;

import com.example.tdddevelopment.data.dto.ProductDto;
import com.example.tdddevelopment.data.mapper.ProductMapper;
import com.example.tdddevelopment.data.repository.ProductRepository;
import com.example.tdddevelopment.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
public class SortingByFrequencySearchingService implements SortingService {

    public List<ProductDto> getSortedProducts(List<ProductDto> productList, boolean descending) {
        if (productList==null || productList.isEmpty()) return null;
        if (descending)
            return  productList.stream().sorted((o1, o2) -> !Objects.equals(o2.getSearchFrequency(), o1.getSearchFrequency()) ? o2.getSearchFrequency().compareTo(o1.getSearchFrequency()): o2.getTitle().compareTo(o1.getTitle())).collect(Collectors.toList());
        return productList.stream().sorted((o1, o2) -> !Objects.equals(o1.getSearchFrequency(), o2.getSearchFrequency()) ? o1.getSearchFrequency().compareTo(o2.getSearchFrequency()) : o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
    }
}
