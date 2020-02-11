/*
 *
 * Author: Vadym Puiko
 *
 * Date: 17.02.2020
 *
 */
package com.sportwear.dao;

import com.sportwear.entity.Category;
import com.sportwear.connection.DatabaseConnect;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements IGenericDao<Category, Long> {
    private static Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static final String SELECT_ALL_CATEGORY = "select * from categories";
    private static final String SELECT_BY_ID_CATEGORY = "select * from categories where id=?";
    private static final String INSERT_INTO_CATEGORY = "insert into categories (name) values (?)";
    private static final String UPDATE_CATEGORY = "update categories set name=?, category_id=? where id=?";
    private static final String DELETE_CATEGORY = "delete from categories where id=?";

    /**
     * @param category
     */
    @Override
    public void create(Category category) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT_INTO_CATEGORY);
        ) {
            ps.setString(1, category.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with create new field of CategoryDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @return category list
     */
    @Override
    public List<Category> readAll() {
        List<Category> categories = new ArrayList<>();
        try (
                Connection c = DatabaseConnect.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(SELECT_ALL_CATEGORY);
        ) {
            while (rs.next()) {
                Category category = readOperation(rs);
                categories.add(category);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of CategoryDao");
            logger.error(e.getMessage());
        }
        return categories;
    }

    /**
     * @param id
     * @return category
     */
    @Override
    public Category readById(Long id) {
        Category category = null;
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(SELECT_BY_ID_CATEGORY);
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category = readOperation(rs);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view CategoryDao by ID");
            logger.error(e.getMessage());
        }
        return category;
    }

    /**
     * @param category
     * @param id
     */
    @Override
    public void update(Category category, Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE_CATEGORY);
        ) {
            ps.setString(1, category.getName());
            ps.setLong(2, category.getCategory_id());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with update field of CategoryDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(DELETE_CATEGORY);
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with delete field of CategoryDao");
            logger.error(e.getMessage());
        }
    }

    private Category readOperation(ResultSet resultSet) {
        Category category = null;
        try {
            category = new Category();
            category.setId(resultSet.getLong("id"));
            category.setName(resultSet.getString("name"));
            category.setCategory_id(resultSet.getLong("category_id"));
        } catch (SQLException e) {
            logger.error("Some problems with method [readOperation] of CategoryDao");
            logger.error(e.getMessage());
        }
        return category;
    }
}
