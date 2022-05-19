package com.khoapham.service;


public interface ICRUDService<E> {
    void save(E e);

    void remove(Integer id);

}
