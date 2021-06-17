package ru.runanddone.admin.utils;

import java.util.List;

public interface DatabaseDataMapper<T, I> {
    List<T> getAll();

    T getById(I id);

    boolean save(T object);

    boolean delete(I id);
}
