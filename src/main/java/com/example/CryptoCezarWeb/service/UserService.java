package com.example.CryptoCezarWeb.service;

import com.example.CryptoCezarWeb.domen.Crypto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@AllArgsConstructor
@Getter
public class UserService {
    private final Crypto crypto;

    public String cezar(String word){
        return crypto.getCryptoCesarWord(word);
    }
    public String baseCrypto(String word, int pinCode){
//        crypto.getPin().setPinNumber(pinCode);
        return crypto.getCryptoCesarWord(word);
    }
}
