package com.example.CryptoCezarWeb.repository;

import com.example.CryptoCezarWeb.domen.LayoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LayoutRepository extends JpaRepository<LayoutEntity, Long> {
    String getContentLayoutEntityByTitle(String title);
    LayoutEntity getFirstLayoutEntityByTitle(String title);
    LayoutEntity getById(Long id);
}
