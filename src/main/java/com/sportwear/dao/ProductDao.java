/*
 *
 * Author: Vadym Puiko
 *
 * Date: 17.02.2020
 *
 */
package com.sportwear.dao;

import com.sportwear.entity.*;
import com.sportwear.connection.DatabaseConnect;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IGenericDao<Product, Long> {
    private static Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static final String SELECT_ALL_PRODUCT = "select * from products";
    private static final String SELECT_BY_ID_PRODUCT = "select * from products where id=?";
    private static final String INSERT_INTO_PRODUCT = "insert into products (name, model, sex, size, price) values (?, ?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT = "update products set name=?, model=?, sex=?, size=?, color_id=?, price=?, category_id=?, brand_id=? where id=?";
    private static final String DELETE_PRODUCT = "delete from products where id=?";

    /**
     * @param product
     */
    @Override
    public void create(Product product) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT_INTO_PRODUCT);
        ) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getModel());
            ps.setString(3, product.getSex());
            ps.setByte(4, product.getSize());
            ps.setDouble(5, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with create new field of ProductDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @return product list
     */
    @Override
    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        try (
                Connection c = DatabaseConnect.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(SELECT_ALL_PRODUCT);
        ) {
            while (rs.next()) {
                Product product = readOperation(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of ProductDao");
            logger.error(e.getMessage());
        }
        return products;
    }

    /**
     * @param id
     * @return product
     */
    @Override
    public Product readById(Long id) {
        Product product = null;
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(SELECT_BY_ID_PRODUCT);
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = readOperation(rs);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view ProductDao by ID");
            logger.error(e.getMessage());
        }
        return product;
    }

    /**
     * @param product
     * @param id
     */
    @Override
    public void update(Product product, Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE_PRODUCT);
        ) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getModel());
            ps.setString(3, product.getSex());
            ps.setByte(4, product.getSize());
            ps.setLong(5, product.getColor_id());
            ps.setDouble(6, product.getPrice());
            ps.setLong(7, product.getCategory_id());
            ps.setLong(8, product.getBrand_id());
            ps.setLong(9, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with update field of ProductDao");
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
                PreparedStatement ps = c.prepareStatement(DELETE_PRODUCT);
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with delete field of ProductDao");
            logger.error(e.getMessage());
        }
    }

    private Product readOperation(ResultSet resultSet) {
        Product product = null;
        try {
            product = new Product();
            product.setId(resultSet.getLong("id"));
            product.setName(resultSet.getString("name"));
            product.setModel(resultSet.getString("model"));
            product.setSex(resultSet.getString("sex"));
            product.setSize(resultSet.getByte("size"));
            product.setColor_id(resultSet.getLong("color_id"));
            product.setPrice(resultSet.getDouble("price"));
            product.setCategory_id(resultSet.getLong("category_id"));
            product.setBrand_id(resultSet.getLong("brand_id"));
        } catch (SQLException e) {
            logger.error("Some problems with method [readOperation] of ProductDao");
            logger.error(e.getMessage());
        }
        return product;
    }
}
