package com.example.CryptoCezarWeb.models;

import com.example.CryptoCezarWeb.services.PinCodeService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BaseCryptoTest {
    @Autowired
    private PinCodeService pinCodeService;
    @Autowired
    private Layout layout;
    @Autowired
    private Cesar cesar;
    private Crypto crypto;

    @BeforeEach()
    public void setUp(){
        // начальные условия
        crypto = new Crypto(pinCodeService,layout, cesar);
        crypto.setPin(1206100);
        crypto.getLayout().setLayout("abcdefghigklmnopqrstuvwxyz".toCharArray());
        crypto.setPasswordSize(8);
        crypto.setWordSize(13);
    }

    @Test
    void cycleTest() {
        //результат
        String result = crypto.getCryptoCesarWord("geekbrains");
        //проверка результата
        assertEquals("gefQbtb3", result);
    }
}