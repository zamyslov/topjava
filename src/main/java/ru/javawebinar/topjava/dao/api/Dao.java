package ru.javawebinar.topjava.dao.api;


import java.util.List;


public interface Dao<K, T> {

    List<T> getAll();

    T getById(K key);

    K create(T entity);

    void delete(K key);

    void update(T entity);

}
