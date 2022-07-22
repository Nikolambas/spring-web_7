package com.geekbrains.spring.web.repositories.validate;

import com.geekbrains.spring.web.data.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Validator {
    List<String>errorList = new ArrayList<>();
    public void validateOnAdd(com.geekbrains.spring.web.dto.ProductDto productDto){
        if (productDto.getTitle().equals("null")){
            errorList.add("Нет названия продукта");
        }
        if (productDto.getCost()>=0){
            errorList.add("Цена продукта отрицательна или равна 0");
        }
    }

    public void valideteById(Long id,List<Product> products) {
        if (id>=0&&products.stream().filter(p -> p.getId() == id).findAny().isEmpty()){
            errorList.add("Id меньше 0 или не существует");
        }
    }

    public void validateOnUpdate(com.geekbrains.spring.web.dto.ProductDto productDto, List<Product> products) {
        validateOnAdd(productDto);
        valideteById(productDto.getId(),products);

    }
}
