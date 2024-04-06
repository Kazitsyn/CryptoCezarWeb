package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.Crypto;
import com.example.CryptoCezarWeb.models.Filters;
import com.example.CryptoCezarWeb.models.FormData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@AllArgsConstructor
public class RestService implements iServiceTaskREST{
    private final Crypto crypto;
    private final LayoutService layoutService;
    private final Filters filters;
    private final CryptoService cryptoService;


    public String cryptoTaskParam(String siteName, int pinCode, int passportSize,  Long id){

        crypto.setWordSize(siteName.length());
        crypto.setPin(pinCode);
        crypto.setPasswordSize(passportSize);
        crypto.getLayout().setLayout(layoutService.getLayoutEntityById(id).getContent().toCharArray());

        return crypto.getCryptoCesarWord(filters.filterCutDomain(siteName));
    }

    public String cryptoTaskFormData(FormData formData){
        cryptoService.init(formData);
        return cryptoService.cezar();
    }
}
