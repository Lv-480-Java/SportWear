package com.sportwear.service.product;

import com.sportwear.dao.ProductDao;
import com.sportwear.entity.Product;
import org.apache.log4j.Logger;

import java.util.List;

public class ProductService {
    private static Logger logger = Logger.getLogger(ProductService.class.getName());
    private ProductDao productDao = new ProductDao();

    public void add(Product product) {
        productDao.create(product);
    }

    public List<Product> getAllProduct() {
        return productDao.readAll();
    }

    public Product getOneProduct(Long id) {
        return productDao.readById(id);
    }

    public void update(Product product, Long id) {
        productDao.update(product, id);
    }

    public void remove(Long id) {
        productDao.delete(id);
    }
}
