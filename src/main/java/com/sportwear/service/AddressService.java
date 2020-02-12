package com.sportwear.service;

import com.sportwear.dao.AddressDao;
import com.sportwear.entity.Address;
import org.apache.log4j.Logger;

import java.util.List;

public class AddressService {
    private static Logger logger = Logger.getLogger(AddressService.class.getName());
    private AddressDao addressDao = new AddressDao();

    public void add(Address address) {
        addressDao.create(address);
    }

    public List<Address> getAllAddress() {
        return addressDao.readAll();
    }

    public Address getOneAddress(Long id) {
        return addressDao.readById(id);
    }

    public void update(Address address, Long id) {
        addressDao.update(address, id);
    }

    public void remove(Long id) {
        addressDao.delete(id);
    }
}
