package com.example.CryptoCezarWeb.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FormData {
    private int pinCode;
    private String word;
    private int passwordSize;
    private String layout;
}
