package com.geekbrains.spring.web.dto;


import com.geekbrains.spring.web.data.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {

    String title;
    Integer cost;

    public ProductDto getProductDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setTitle(product.getTitle());
        dto.setCost(product.getCost());
        return dto;
    }



}
