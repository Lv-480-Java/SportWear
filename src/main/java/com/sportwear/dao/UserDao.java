/*
 *
 * Author: Vadym Puiko
 *
 * Date: 17.02.2020
 *
 */
package com.sportwear.dao;

import com.sportwear.entity.Product;
import com.sportwear.entity.User;
import com.sportwear.connection.DatabaseConnect;
import com.sportwear.entity.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDao implements IGenericDao<User, Long> {
    private static Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static final String SELECT_ALL_USER = "select * from users";
    private static final String SELECT_BY_ID_USER = "select * from users where id=?";
    private static final String INSERT_INTO_USER = "insert into users (first_name, last_name, email, password) values (?, ?, ?, ?)";
    private static final String UPDATE_USER = "update users set first_name=?, last_name=?, phone=?, address_id=?, email=?, password=? where id=?";
    private static final String DELETE_USER = "delete from users where id=?";

    /**
     * @param user
     */
    @Override
    public void create(User user) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT_INTO_USER);
        ) {
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error UserDao");
        }
    }

    /**
     * @return user list
     */
    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        try (
                Connection c = DatabaseConnect.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(SELECT_ALL_USER);
        ) {
            while (rs.next()) {
                User user = readOperation(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            logger.info("Error UserDao");
        }
        return users;
    }

    /**
     * @param id
     * @return user
     */
    @Override
    public User readById(Long id) {
        User user = null;
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(SELECT_BY_ID_USER);
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = readOperation(rs);
            }
        } catch (SQLException e) {
            logger.info("Error UserDao");
        }
        return user;
    }

    /**
     * @param user
     * @param id
     */
    @Override
    public void update(User user, Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE_USER);
        ) {
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getPhone());
            ps.setLong(4, user.getAddress_id());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setLong(7, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error UserDao");
        }
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(DELETE_USER);
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error UserDao");
        }
    }

    private User readOperation(ResultSet resultSet) {
        User user = null;
        try {
            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setFirst_name(resultSet.getString("first_name"));
            user.setLast_name(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setPhone(resultSet.getString("phone"));
            user.setAddress_id(resultSet.getLong("address_id"));
//            user.setUserRole(UserRole.valueOf(resultSet.getString("userRole")));
        }catch (SQLException e) {
            logger.info("Error UserDao");
        }
        return user;
    }
}
