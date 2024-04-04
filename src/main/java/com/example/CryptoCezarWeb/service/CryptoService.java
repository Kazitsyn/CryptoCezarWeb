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
        LayoutEntity layout = layoutService.getLayoutEntityById(filterLongId(formData.getLayout()));
        crypto.getLayout().setLayout(layout.getContent().toCharArray());
        crypto.setWordSize(formData.getWord().length());
        this.word = filterCutDomain(formData.getWord());

    }

    public String cezar(){
        return crypto.getCryptoCesarWord(word);
    }

    private String filterCutDomain(String word){
        return word.replaceAll("\\.\\w+$", "");
    }

    private Long filterLongId(String word){
        int colonIndex = word.indexOf(':');
        String temp = word.substring(0,colonIndex);
        return Long.valueOf(temp) ;
    }

}
