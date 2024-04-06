package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.LayoutEntity;

import java.util.List;

public interface iServiceLayoutEntity {
    List<LayoutEntity> findAll();
    void addLayoutEntity(LayoutEntity layout);
    LayoutEntity getLayoutEntityById(Long id);
}
