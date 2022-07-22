package com.geekbrains.spring.web.services;


import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.dto.CreateProductDto;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.exceptions.GlobalExceptionHandler;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundExeption;
import com.geekbrains.spring.web.repositories.ProductRepository;
import com.geekbrains.spring.web.repositories.specification.ProductSpecification;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;



    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDto findById(Long id)  {
        List<Product> products = productRepository.findAll();
        if (products.stream().filter(p -> p.getId() == id).findAny().isEmpty()) {
            try {
                throw new NotFoundException("Нет такого Id");
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return productRepository.findById(id).map(p -> new CreateProductDto().getProductDto(p)).orElseThrow();
    }


    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream().map(p->new CreateProductDto().getProductDto(p)).collect(Collectors.toList());
    }
}
