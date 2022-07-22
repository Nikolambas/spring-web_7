package com.geekbrains.spring.web.controllers;


import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/all")
    public List<ProductDto> getAllProducts(){
        return productService.findAllProducts();
    }



    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    

}
