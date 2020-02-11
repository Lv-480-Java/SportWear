/*
 *
 * Author: Vadym Puiko
 *
 * Date: 17.02.2020
 *
 */
package com.sportwear.dao;

import java.util.List;

public interface IGenericDao<T, N> {

    // create
    void create(T t);

    // read
    List<T> readAll();

    // read one element by id
    T readById(N n);

    // update
    void update(T t, N n);

    // delete
    void delete(N n);
}
