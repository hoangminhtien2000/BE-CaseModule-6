package com.becasemodule6.services;

import java.util.List;

public interface CrudService <E>{
    List<E> findAll();

    void save(E e);

    void delete(Long id);

    E findById(Long id);
}
