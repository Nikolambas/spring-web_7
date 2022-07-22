package com.geekbrains.spring.web.dto;


import com.geekbrains.spring.web.data.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {

    String title;
    Integer cost;

    public com.geekbrains.spring.web.dto.ProductDto getProductDto(Product product){
        com.geekbrains.spring.web.dto.ProductDto dto = new com.geekbrains.spring.web.dto.ProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setCost(product.getCost());
        return dto;
    }

    public Product getProduct(com.geekbrains.spring.web.dto.ProductDto productDto){
        Product product = new Product();
        product.setId(product.getId());
        product.setTitle(product.getTitle());
        product.setCost(product.getCost());
        return product;
    }



}
