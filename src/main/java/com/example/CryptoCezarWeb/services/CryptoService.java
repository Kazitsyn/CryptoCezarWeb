package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.*;
import org.springframework.stereotype.Service;

@Service
public class CryptoService implements iServiceWeb {
    private final iCrypto crypto;
    private final LayoutService layoutService;
    private String word;
    private final Filters filters;

    public CryptoService(Crypto crypto, LayoutService layoutService, Filters filters) {
        this.crypto = crypto;
        this.layoutService = layoutService;
        this.filters = filters;
    }

    /**
     * Метод инициализации даный в классы решающую криптографическую задачу
     * @param formData вводимый пакет данный
     */
    public void init(FormData formData){
        crypto.setPin(formData.getPinCode());
        crypto.setPasswordSize(formData.getPasswordSize());

        if (layoutService.getLayoutEntityById(filters.filterLongId(formData.getLayout())) != null){
            LayoutEntity layout = layoutService.getLayoutEntityById(filters.filterLongId(formData.getLayout()));
            crypto.getLayout().setLayout(layout.getContent().toCharArray());
        }else {
            crypto.getLayout().setLayout("abcdefghigklmnopqrstuvwxyz".toCharArray());
        }
        crypto.setWordSize(formData.getWord().length());
        this.word = filters.filterCutDomain(formData.getWord());
    }

    /**
     * вызов решение задачи
     * @return результат решение задачи
     */
    public String cezar(){
        return crypto.getCryptoCesarWord(word);
    }


}
