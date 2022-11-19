package ru.gamesphere.dao;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Dao<T, D> {

    @NotNull List<@NotNull T> all();

    void save(@NotNull D dto);

}