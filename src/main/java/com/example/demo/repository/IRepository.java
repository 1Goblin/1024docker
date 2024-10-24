package com.example.demo.repository;

import java.util.List;

public interface IRepository<T, F> {

    F findById(T id);

    List<F> findAll();

    F save(F entity);

}
