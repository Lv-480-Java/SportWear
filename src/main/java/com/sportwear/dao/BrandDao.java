/*
 *
 * Author: Vadym Puiko
 *
 * Date: 17.02.2020
 *
 */
package com.sportwear.dao;

import com.sportwear.entity.Brand;
import com.sportwear.connection.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandDao implements IGenericDao<Brand, Long> {
    private static Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static final String SELECT_ALL_BRAND = "select * from brands";
    private static final String SELECT_BY_ID_BRAND = "select * from brands where id=?";
    private static final String INSERT_INTO_BRAND = "insert into brands (name) values (?)";
    private static final String UPDATE_BRAND = "update brands set name=? where id=?";
    private static final String DELETE_BRAND = "delete from brands where id=?";

    /**
     * @param brand
     */
    @Override
    public void create(Brand brand) {
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT_INTO_BRAND);
        ) {
            ps.setString(1, brand.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with create new field of BrandDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @return brand list
     */
    @Override
    public List<Brand> readAll() {
        List<Brand> brands = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(SELECT_ALL_BRAND);
        ) {
            while (rs.next()) {
                Brand brand = readOperation(rs);
                brands.add(brand);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of BrandDao");
            logger.error(e.getMessage());
        }
        return brands;
    }

    /**
     * @param id
     * @return brand
     */
    @Override
    public Brand readById(Long id) {
        Brand brand = null;
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(SELECT_BY_ID_BRAND);
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                brand = readOperation(rs);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view BrandDao by ID");
            logger.error(e.getMessage());
        }
        return brand;
    }

    /**
     * @param brand
     * @param id
     */
    @Override
    public void update(Brand brand, Long id) {
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE_BRAND);
        ) {
            ps.setString(1, brand.getName());
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with update field of BrandDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(DELETE_BRAND);
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with delete field of BrandDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @return brand
     * method for readById and readAll
     */
    private Brand readOperation(ResultSet resultSet) {
        Brand brand = null;
        try {
            brand = new Brand();
            brand.setId(resultSet.getLong("id"));
            brand.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            logger.error("Some problems with method [readOperation] of BrandDao");
            logger.error(e.getMessage());
        }
        return brand;
    }
}
