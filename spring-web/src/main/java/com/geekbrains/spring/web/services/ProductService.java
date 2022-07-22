package com.geekbrains.spring.web.services;


import com.geekbrains.spring.web.data.Cart;
import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.dto.CreateProductDto;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.repositories.ProductRepository;
import com.geekbrains.spring.web.repositories.validate.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final Validator validator;
    private final Cart cart;



    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public com.geekbrains.spring.web.dto.ProductDto findById(Long id)  {
        List<Product> products = productRepository.findAll();
        validator.valideteById(id,products);
        return productRepository.findById(id).map(p -> new CreateProductDto().getProductDto(p)).orElseThrow();
    }


    public List<com.geekbrains.spring.web.dto.ProductDto> findAllProducts() {
        return productRepository.findAll().stream().map(p->new CreateProductDto().getProductDto(p)).collect(Collectors.toList());
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public com.geekbrains.spring.web.dto.ProductDto updateProduct(com.geekbrains.spring.web.dto.ProductDto productDto) {
        validator.validateOnUpdate(productDto,productRepository.findAll());
        Product product = new CreateProductDto().getProduct(productDto);
        Product product1= productRepository.save(product);
        return new CreateProductDto().getProductDto(product1);
    }

    public com.geekbrains.spring.web.dto.ProductDto delete(Long id) {
        validator.valideteById(id,productRepository.findAll());
        productRepository.deleteById(id);
        return findById(id);
    }

    public HashMap<ProductDto,Integer> putIntoCart(Long id) {
        ProductDto productDto = findById(id);
        cart.putInCart(productDto);
        return cart.getProductCart();
    }

    public HashMap<ProductDto, Integer> deleteInCart(Long id) {
        ProductDto productDto = findById(id);
        cart.deleteOnCart(productDto);
        return cart.getProductCart();
    }
}
