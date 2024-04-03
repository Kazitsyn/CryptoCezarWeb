package com.example.CryptoCezarWeb.service;

import com.example.CryptoCezarWeb.domen.Crypto;
import com.example.CryptoCezarWeb.domen.FormData;
import com.example.CryptoCezarWeb.domen.LayoutEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CryptoService {
    private final Crypto crypto;
    private final LayoutService layoutService;
    private String word;

    public CryptoService(Crypto crypto, LayoutService layoutService) {
        this.crypto = crypto;
        this.layoutService = layoutService;
    }

    public void init(FormData formData){
        crypto.setPin(formData.getPinCode());
        crypto.setPasswordSize(formData.getPasswordSize());
        LayoutEntity layout = layoutService.getFirstLayoutEntityByTitle(formData.getLayout());
        crypto.getLayout().setLayout(layout.getContent().toCharArray());
        this.word = formData.getWord();

    }

    public String cezar(){
        return crypto.getCryptoCesarWord(word);
    }

}
