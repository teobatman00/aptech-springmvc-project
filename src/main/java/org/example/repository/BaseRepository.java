package org.example.repository;

import java.util.List;

public interface BaseRepository<T, I> {

    List<T> getList();
    T getById(I id);
    void save(T entity);

    void deleteById(I id);
}
