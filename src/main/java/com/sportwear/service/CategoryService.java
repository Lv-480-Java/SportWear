package com.sportwear.service;

import com.sportwear.dao.CategoryDao;
import com.sportwear.entity.Category;

import java.util.List;
import java.util.logging.Logger;

public class CategoryService {
    private static Logger logger = Logger.getLogger(CategoryService.class.getName());
    private CategoryDao categoryDao = new CategoryDao();

    public void add(Category category) {
        categoryDao.create(category);
    }

    public List<Category> getAllCategory() {
        return categoryDao.readAll();
    }

    public Category getOneCategory(Long id) {
        return categoryDao.readById(id);
    }

    public void update(Category category, Long id) {
        categoryDao.update(category, id);
    }

    public void remove(Long id) {
        categoryDao.delete(id);
    }

}
