package com.khoapham.service;

import java.util.List;

public interface ICRUDService<E> {
    List<E> findAll();

    void save(E e);

    void remove(E e);
}
