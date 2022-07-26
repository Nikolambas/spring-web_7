package com.geekbrains.spring.web.controllers;


import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.dto.CreateProductDto;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.repositories.validate.Validator;
import com.geekbrains.spring.web.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final Validator validator;


    @GetMapping("/all")
    public List<ProductDto> getAllProducts(){
        return productService.findAllProducts();
    }



    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/add")
    public ProductDto addProduct(@RequestBody com.geekbrains.spring.web.dto.ProductDto productDto){
        validator.validateOnAdd(productDto);
        Product product = productService.add(new CreateProductDto().getProduct(productDto));
        return new CreateProductDto().getProductDto(product);
    }

    @PutMapping("/update")
    public ProductDto updateProduct(@RequestBody com.geekbrains.spring.web.dto.ProductDto productDto){
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/delete")
    public ProductDto delete(@RequestParam(value = "id") Long id){
        return productService.delete(id);
    }

    @GetMapping("/cart/{id}")
    public HashMap<ProductDto,Integer> putInCart(@PathVariable Long id){
        return productService.putIntoCart(id);
    }

    @GetMapping("/cart/delete/{id}")
    public HashMap<ProductDto,Integer> deleteInCart(@PathVariable Long id){
        return productService.deleteInCart(id);
    }

}
