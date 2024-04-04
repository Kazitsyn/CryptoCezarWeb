package com.example.CryptoCezarWeb.service;

import com.example.CryptoCezarWeb.domen.LayoutEntity;
import com.example.CryptoCezarWeb.repository.LayoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LayoutService {
    private final LayoutRepository layoutRepository;

    public List<LayoutEntity> findAll(){
        return layoutRepository.findAll();
    }

    public String getEntityContentByTitle(String title){
        return layoutRepository.getContentLayoutEntityByTitle(title);
    }

    public LayoutEntity getFirstLayoutEntityByTitle(String title){
        return layoutRepository.getFirstLayoutEntityByTitle(title);
    }

    public void addLayoutEntity(LayoutEntity layout){
        layoutRepository.save(layout);
    }

    public LayoutEntity getLayoutEntityById(Long id){
        return layoutRepository.getById(id);
    }


}
