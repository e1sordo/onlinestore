package com.epam.laba.onlinestore.service;

import com.epam.laba.onlinestore.dao.ProductDao;
import com.epam.laba.onlinestore.model.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        this.productDao.addProduct(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        this.productDao.updateProduct(product);
    }

    @Override
    @Transactional
    public void removeProduct(int id) {
        this.productDao.removeProduct(id);
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        return this.productDao.getProductById(id);
    }

    @Override
    @Transactional
    public List<Product> listProducts() {
        return this.productDao.listProducts();
    }
}
