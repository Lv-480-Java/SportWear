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

public class ColorDao implements IGenericDao<Color, Long> {
    private static Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static final String SELECT_ALL_COLOR = "select * from colors";
    private static final String SELECT_BY_ID_COLOR = "select * from colors where id=?";
    private static final String INSERT_INTO_COLOR = "insert into colors (name) values (?)";
    private static final String UPDATE_COLOR = "update colors set name=? where id=?";
    private static final String DELETE_COLOR = "delete from colors where id=?";

    /**
     * @param color
     */
    @Override
    public void create(Color color) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT_INTO_COLOR);
        ) {
            ps.setString(1, color.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with create new field of ColorDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @return color list
     */
    @Override
    public List<Color> readAll() {
        List<Color> colors = new ArrayList<>();
        try (
                Connection c = DatabaseConnect.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(SELECT_ALL_COLOR);
        ) {
            while (rs.next()) {
                Color color = readOperation(rs);
                colors.add(color);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of ColorDao");
            logger.error(e.getMessage());
        }
        return colors;
    }

    /**
     * @param id
     * @return color
     */
    @Override
    public Color readById(Long id) {
        Color color = null;
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(SELECT_BY_ID_COLOR);
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                color = readOperation(rs);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view ColorDao by ID");
            logger.error(e.getMessage());
        }
        return color;
    }

    /**
     * @param color
     * @param id
     */
    @Override
    public void update(Color color, Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE_COLOR);
        ) {
            ps.setString(1, color.getName());
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with update field of ColorDao");
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
                PreparedStatement ps = c.prepareStatement(DELETE_COLOR);
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with delete field of ColorDao");
            logger.error(e.getMessage());
        }
    }

    private Color readOperation(ResultSet resultSet) {
        Color color = null;
        try {
            color = new Color();
            color.setId(resultSet.getLong("id"));
            color.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            logger.error("Some problems with method [readOperation] of ColorDao");
            logger.error(e.getMessage());
        }
        return color;
    }
}
