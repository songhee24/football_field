package com.football_field.football_field.Servicies;

import java.util.List;

public interface BaseService<T> {
    T getById(Long id);

    List<T> getAll();

    T save (T item);
}
