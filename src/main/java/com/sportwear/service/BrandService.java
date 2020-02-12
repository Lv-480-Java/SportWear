package com.sportwear.service;

import com.sportwear.dao.BrandDao;
import com.sportwear.entity.Brand;
import org.apache.log4j.Logger;

import java.util.List;

public class BrandService {
    private static Logger logger = Logger.getLogger(BrandService.class.getName());
    private BrandDao brandDao = new BrandDao();

    public void add(Brand brand) {
        brandDao.create(brand);
    }

    public List<Brand> getAllBrand() {
        return brandDao.readAll();
    }

    public Brand getOneBrand(Long id) {
        return brandDao.readById(id);
    }

    public void update(Brand brand, Long id) {
        brandDao.update(brand, id);
    }

    public void remove(Long id) {
        brandDao.delete(id);
    }
}
