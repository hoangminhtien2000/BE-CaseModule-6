package com.becasemodule6.services;

import java.util.List;

public interface CrudService <E>{
    List<E> findAll();

<<<<<<< HEAD
    void save(E e);
=======
    E save(E e);
>>>>>>> 95dfe82ac936d510769d5867db2cf66d41595809

    void delete(Long id);

    E findById(Long id);
}
