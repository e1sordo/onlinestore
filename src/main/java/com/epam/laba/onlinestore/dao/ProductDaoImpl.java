package com.epam.laba.onlinestore.dao;

import com.epam.laba.onlinestore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    public static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
        logger.info("Product successfully added. Product details: " + product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("Product has been updated. Product details:" + product);
    }

    @Override
    public void removeProduct(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, new Integer(id));

        if (null != product) {
            session.delete(product);
        }
        logger.info("Product successfully deleted. Product details:" + product);
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, new Integer(id));
        logger.info("Product successfully loaded. Product details: " + product);

        return product;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> listProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("from Product").list();

        for (Product product : productList) {
            logger.info("Product list: " + product);
        }

        return productList;
    }
}
