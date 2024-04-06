package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.LayoutEntity;

import java.util.List;

public interface iServiceCRUD {
    /**
     * Найти все последовательности
     * @return список сущностей последовательности
     */
    List<LayoutEntity> findAll();

    /**
     * Найти последовательность по id
     * @param id id
     * @return сущность последовательности
     */
    LayoutEntity getLayoutEntityById(Long id);

    /**
     * Сохранить сущность последовательности
     * @param layout сущность псоледовательности
     */
    void addLayoutEntity(LayoutEntity layout);

    /**
     * Изменить сущность последовательности по id
     * @param layout новая последовательность
     * @param id id старой последовательности
     */
    void update(LayoutEntity layout, Long id);

    /**
     * Удалить сущность последовательности по id
     * @param id id
     */
    void delete(Long id);

}
