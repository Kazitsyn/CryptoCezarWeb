package com.example.CryptoCezarWeb.models;

public interface iCrypto {
    String getCryptoCesarWord(String word);
    void setPin(int pin);
    void setPasswordSize(int size);
    Layout getLayout();
    void setWordSize(int size);
}
