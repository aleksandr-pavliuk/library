package com.pavliuk.library.service;

import java.util.List;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface GeneralService<T> {
    List<T> getAll();

    T get(long id);

    void save(T obj);

    void update(T obj);

    void delete(long id);
}
