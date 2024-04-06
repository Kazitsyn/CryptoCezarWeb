package com.example.CryptoCezarWeb.models;

import org.springframework.stereotype.Component;

@Component
public class Filters {
    /**
     * Фильтр обрезающий символы после точки
     * @param word исходная строка
     * @return строка после фильтра
     */
    public String filterCutDomain(String word){
        return word.replaceAll("\\.\\w+$", "");
    }

    /**
     * Фильтр вырезания ID
     * @param word исходная строка
     * @return ID
     */
    public Long filterLongId(String word){
        int colonIndex = word.indexOf(':');
        if (colonIndex < 0) return Long.valueOf(word);
        String temp = word.substring(0,colonIndex);
        return Long.valueOf(temp) ;
    }


}
