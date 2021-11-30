package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.entity.Product;
import com.example.tdddevelopment.data.enums.Measure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageElementDto {
    private Long id;
    private Double quantity;
    private Measure measure;
    private Boolean isOpen;
    private Date validUntil;

    private ProductDto product;
}
