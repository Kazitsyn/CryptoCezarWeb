package com.example.CryptoCezarWeb.domen;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FormData {
    private int pinCode;
    private String word;
}
