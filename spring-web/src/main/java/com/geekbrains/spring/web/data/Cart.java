package com.geekbrains.spring.web.data;

import com.geekbrains.spring.web.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    HashMap<ProductDto,Integer> productCart = new HashMap<>();

    public void putInCart(ProductDto product){
        if (productCart.containsKey(product)){
            Integer value = productCart.get(product);
            value++;
            productCart.put(product,value);
            return;
        }
        productCart.put(product,1);
    }
    public void deleteOnCart(ProductDto product){
        if (productCart.containsKey(product)){
            Integer value = productCart.get(product);
            value--;
            if (value==0){
                productCart.remove(product);
                return;
            }
            productCart.put(product,value);
        }
    }
}
