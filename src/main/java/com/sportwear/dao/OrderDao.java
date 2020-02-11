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

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Logger;

public class OrderDao implements IGenericDao<Order, Long> {
    private static Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static final String SELECT_ALL_ORDER = "select * from orders";
    private static final String SELECT_BY_ID_ORDER = "select * from orders where id=?";
    private static final String INSERT_INTO_ORDER = "insert into orders (date, count, is_buy) values (?, ?, ?)";
    private static final String UPDATE_ORDER = "update orders set date=?, count=?, user_id=?, is_buy=? where id=?";
    private static final String DELETE_ORDER = "delete from orders where id=?";

    /**
     * @param order
     */
    @Override
    public void create(Order order) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT_INTO_ORDER);
        ) {
            ps.setDate(1, Date.valueOf(order.getLocalDate()));
            ps.setLong(2, order.getCount());
            ps.setBoolean(3, order.getIs_buy());
            ps.executeUpdate();
        }catch (SQLException e) {
            Logger.getGlobal().info("Error OrderDao");
        }
    }

    /**
     * @return order list
     */
    @Override
    public List<Order> readAll() {
        List<Order> orders = new ArrayList<>();
        try (
                Connection c = DatabaseConnect.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(SELECT_ALL_ORDER);
        ) {
            while (rs.next()) {
                Order order = readOperation(rs);
                orders.add(order);
            }
        }catch (SQLException e) {
            Logger.getGlobal().info("Error OrderDao");
        }
        return orders;
    }

    /**
     * @param id
     * @return order
     */
    @Override
    public Order readById(Long id) {
        Order order = null;
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(SELECT_BY_ID_ORDER);
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = readOperation(rs);
            }
        }catch (SQLException e) {
            logger.info("Error OrderDao");
        }
        return order;
    }

    /**
     * @param order
     * @param id
     */
    @Override
    public void update(Order order, Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE_ORDER);
        ) {
            ps.setDate(1, Date.valueOf(order.getLocalDate()));
            ps.setLong(2, order.getCount());
            ps.setLong(3, order.getUser_id());
            ps.setBoolean(4, order.getIs_buy());
            ps.setLong(5, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            logger.info("Error OrderDao");
        }
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(DELETE_ORDER);
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            logger.info("Error OrderDao");
        }
    }

    private Order readOperation(ResultSet resultSet) {
        Order order = null;
        try {
            order = new Order();
            order.setId(resultSet.getLong("id"));
            order.setLocalDate(resultSet.getDate("date").toLocalDate());
            order.setCount(resultSet.getLong("count"));
            order.setUser_id(resultSet.getLong("user_id"));
            order.setIs_buy(resultSet.getBoolean("is_buy"));
        }catch (SQLException e) {
            logger.info("Error OrderDao");
        }
        return order;
    }
}
