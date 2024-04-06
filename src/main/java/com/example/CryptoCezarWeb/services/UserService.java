package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.Crypto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

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
