package com.khoapham.service;

import java.util.Map;

public interface ICRUDService<E> {
    Map<String, String> save(E e);

    Map<String, String> update(E e);

    boolean remove(Integer id);

}
