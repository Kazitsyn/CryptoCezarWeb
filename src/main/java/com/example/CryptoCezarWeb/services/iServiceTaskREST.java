package com.example.CryptoCezarWeb.services;

import com.example.CryptoCezarWeb.models.FormData;

public interface iServiceTaskREST {
    String cryptoTaskParam(String siteName, int pinCode, int passportSize,  Long id);
    String cryptoTaskFormData(FormData formData);
}
