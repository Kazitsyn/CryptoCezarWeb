package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.LayoutEntity;
import com.example.CryptoCezarWeb.repository.LayoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LayoutService implements iServiceLayoutEntity, iServiceCRUD{
    private final LayoutRepository layoutRepository;

    public List<LayoutEntity> findAll(){
        return layoutRepository.findAll();
    }

    /**
     * Найти последовательность по id
     *
     * @param id id
     * @return сущность последовательности
     */
    @Override
    public LayoutEntity getLayoutEntityById(Long id) {
        return layoutRepository.getById(id);
    }

    /**
     * Сохранить сущность последовательности
     *
     * @param layout сущность псоледовательности
     */
    @Override
    public void addLayoutEntity(LayoutEntity layout) {
        layoutRepository.save(layout);
    }

    /**
     * Изменить сущность последовательности по id
     *
     * @param layout новая последовательность
     * @param id     id старой последовательности
     */
    @Override
    public void update(LayoutEntity layout, Long id) {
        layout.setId(id);
        layoutRepository.save(layout);
    }

    /**
     * Удалить сущность последовательности по id
     *
     * @param id id
     */
    @Override
    public void delete(Long id) {
        layoutRepository.deleteById(id);
    }

    public String getEntityContentByTitle(String title){
        return layoutRepository.getContentLayoutEntityByTitle(title);
    }

    public LayoutEntity getFirstLayoutEntityByTitle(String title){
        return layoutRepository.getFirstLayoutEntityByTitle(title);
    }

}
