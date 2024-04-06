package com.example.CryptoCezarWeb.domain;

import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TaskCrypto {
    private FormData formData;
    private final Crypto crypto;

    public TaskCrypto(Crypto crypto) {
        this.crypto = crypto;
    }

    public void init(FormData formData){}
}
