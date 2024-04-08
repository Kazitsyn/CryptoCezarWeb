package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.Crypto;
import com.example.CryptoCezarWeb.models.Filters;
import com.example.CryptoCezarWeb.models.FormData;
import com.example.CryptoCezarWeb.models.LayoutEntity;
import com.example.CryptoCezarWeb.repository.DataLoader;
import com.example.CryptoCezarWeb.repository.LayoutRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CryptoServiceTest {

    private FormData formData;
    @Autowired
    private Crypto crypto;

    @MockBean
    private LayoutService layoutService;
    @Autowired
    private Filters filters;
    private CryptoService cryptoService;



    @BeforeEach
    public void setUpFormData(){
        formData = new FormData();
        formData.setWord("geekbrains.ru");
        formData.setPinCode(1206100);
        formData.setLayout("1");
        formData.setPasswordSize(8);
        cryptoService = new CryptoService(crypto,layoutService,filters);
        cryptoService.init(formData);
    }

    @Test
    void initPin() {
        assertEquals(1206100, crypto.getPin());
    }
    @Test
    void initPasswordSize() {
        assertEquals(8, crypto.getPasswordSize());
    }
    @Test
    void initWordSize() {
        assertEquals(13, crypto.getWordSize());
    }

    @Test
    void cezar() {
        String result = cryptoService.cezar();
        assertEquals("gefQbtb3", result);
    }
}