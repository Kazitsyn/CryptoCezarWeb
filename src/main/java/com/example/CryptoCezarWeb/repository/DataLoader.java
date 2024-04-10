package com.example.CryptoCezarWeb.repository;

import com.example.CryptoCezarWeb.models.LayoutEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private LayoutRepository layoutRepository;
    @Override
    public void run(String... args) throws Exception {

        LayoutEntity layoutEntity1 = new LayoutEntity();
        layoutEntity1.setId(1L);
        layoutEntity1.setTitle("The Latin alphabet");
        layoutEntity1.setContent("abcdefghijklmnopqrstuvwxyz");
        layoutEntity1.setStatusBuild("Basic");
        layoutRepository.save(layoutEntity1);

        LayoutEntity layoutEntity2 = new LayoutEntity();
        layoutEntity2.setId(2L);
        layoutEntity2.setTitle("Keyboard layout EN");
        layoutEntity2.setContent("qwertyuiopasdfghjklzxcvbnm");
        layoutEntity2.setStatusBuild("Basic");
        layoutRepository.save(layoutEntity2);

        LayoutEntity layoutEntity3 = new LayoutEntity();
        layoutEntity2.setId(3L);
        layoutEntity2.setTitle("Keyboard layout EN all");
        layoutEntity2.setContent("qwertyuiopasdfghjklzxcvbnm1234567890!@#$%^&*()_+-=*");
        layoutEntity2.setStatusBuild("Basic");
        layoutRepository.save(layoutEntity2);
    }
}
