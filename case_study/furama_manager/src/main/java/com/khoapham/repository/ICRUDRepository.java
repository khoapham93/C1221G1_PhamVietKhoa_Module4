package com.khoapham.repository;

public interface ICRUDRepository<E> {

    void save(E e);

    boolean update(E e);

    boolean remove(Integer id);
}
