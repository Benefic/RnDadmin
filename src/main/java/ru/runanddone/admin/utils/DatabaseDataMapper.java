package ru.runanddone.admin.utils;

import java.util.List;

public interface DatabaseDataMapper<T, I> {
    List<T> getAll();

    T getById(I id);

    T save(T object);

    boolean delete(I id);
}
