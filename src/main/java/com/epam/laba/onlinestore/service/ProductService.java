package com.epam.laba.onlinestore.service;

import com.epam.laba.onlinestore.model.Product;

import java.util.List;

public interface ProductService {

    public void addProduct(Product product);

    public void updateProduct(Product product);

    public void removeProduct(int id);

    public Product getProductById(int id);

    public List<Product> listProducts();
}
