package com.aoo.productservice.service;

import com.aoo.productservice.entity.Product;

import java.net.URI;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product findProductById(Long id);
    URI saveProduct(Product product);
}
