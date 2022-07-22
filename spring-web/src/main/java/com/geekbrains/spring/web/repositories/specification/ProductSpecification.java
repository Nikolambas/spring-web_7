package com.geekbrains.spring.web.repositories.specification;


import com.geekbrains.spring.web.data.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> scoreGreaterOrElseThan(Integer score){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("score"), score));
    }

    public static Specification<Product> lessThanOrEqualTo(Integer score){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("score"), score));
    }

    public static Specification<Product> nameLike(String namePart){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", namePart)));
    }

}
