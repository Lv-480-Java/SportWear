/*
 *
 * Author: Vadym Puiko
 *
 * Date: 17.02.2020
 *
 */
package com.sportwear.dao;

import com.sportwear.entity.Address;
import com.sportwear.connection.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressDao implements IGenericDao<Address, Long> {
    private static Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static final String SELECT_ALL_ADDRESS = "select * from addresses";
    private static final String SELECT_BY_ID_ADDRESS = "select * from addresses where id=?";
    private static final String INSERT_INTO_ADDRESS = "insert into addresses (country, city, street) values (?, ?, ?)";
    private static final String UPDATE_ADDRESS = "update addresses set country=?, city=?, street=? where id=?";
    private static final String DELETE_ADDRESS = "delete from addresses where id=?";

    /**
     * @param address
     */
    @Override
    public void create(Address address) {
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT_INTO_ADDRESS);
        ) {
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with create new field of AddressDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @return address list
     */
    @Override
    public List<Address> readAll() {
        List<Address> addresses= new ArrayList<>();
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(SELECT_ALL_ADDRESS);
        ) {
            while (rs.next()) {
                Address address = readOperation(rs);
                addresses.add(address);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of AddressDao");
            logger.error(e.getMessage());
        }
        return addresses;
    }

    /**
     * @param id
     * @return address
     */
    @Override
    public Address readById(Long id) {
        Address address = null;
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(SELECT_BY_ID_ADDRESS);
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                address = readOperation(rs);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view AddressDao by ID");
            logger.error(e.getMessage());
        }
        return address;
    }

    /**
     * @param address
     * @param id
     */
    @Override
    public void update(Address address, Long id) {
        try (
                Connection c = DatabaseConnection.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE_ADDRESS);
        ) {
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.setLong(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with update field of AddressDao");
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
                PreparedStatement ps = c.prepareStatement(DELETE_ADDRESS);
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with delete field of AddressDao");
            logger.error(e.getMessage());
        }
    }

    /**
     * @return address
     * method for readById and readAll
     */
    private Address readOperation(ResultSet resultSet) {
        Address address = null;
        try {
            address = new Address();
            address.setId(resultSet.getLong("id"));
            address.setCountry(resultSet.getString("country"));
            address.setStreet(resultSet.getString("city"));
            address.setCity(resultSet.getString("street"));
        } catch (SQLException e) {
            logger.error("Some problems with method [readOperation] of AddressDao");
            logger.error(e.getMessage());
        }
        return address;
    }
}
