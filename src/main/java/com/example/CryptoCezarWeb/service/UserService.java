package com.example.CryptoCezarWeb.service;

import com.example.CryptoCezarWeb.domen.Crypto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final Crypto crypto;

    public String cezar(String word){
        return crypto.getCryptoCesarWord(word);
    }
}
