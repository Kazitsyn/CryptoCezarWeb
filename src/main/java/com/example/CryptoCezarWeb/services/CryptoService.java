package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.Crypto;
import com.example.CryptoCezarWeb.models.FormData;
import com.example.CryptoCezarWeb.models.LayoutEntity;
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

    /**
     * Метод инициализации даный в классы решающую криптографическую задачу
     * @param formData вводимый пакет данный
     */
    public void init(FormData formData){
        crypto.setPin(formData.getPinCode());
        crypto.setPasswordSize(formData.getPasswordSize());
        LayoutEntity layout = layoutService.getLayoutEntityById(filterLongId(formData.getLayout()));
        crypto.getLayout().setLayout(layout.getContent().toCharArray());
        crypto.setWordSize(formData.getWord().length());
        this.word = filterCutDomain(formData.getWord());

    }

    /**
     * вызов решение задачи
     * @return результат решение задачи
     */
    public String cezar(){
        return crypto.getCryptoCesarWord(word);
    }

    /**
     * Фильтр обрезающий символы после точки
     * @param word исходная строка
     * @return строка после фильтра
     */
    private String filterCutDomain(String word){
        return word.replaceAll("\\.\\w+$", "");
    }

    /**
     * Фильтр вырезания ID
     * @param word исходная строка
     * @return ID
     */
    private Long filterLongId(String word){
        int colonIndex = word.indexOf(':');
        String temp = word.substring(0,colonIndex);
        return Long.valueOf(temp) ;
    }
}
