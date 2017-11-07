package ru.javawebinar.topjava.dao.api;


import java.util.List;


public interface Dao<K, T> {

    List<T> getAll();

    T getById(K key);

    T getBy(String fieldName, String key);

    void save(T entity);

    void delete(K key);

    void update(T entity);

}
