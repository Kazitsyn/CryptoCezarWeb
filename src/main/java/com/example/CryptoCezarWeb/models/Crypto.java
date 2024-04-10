package com.example.CryptoCezarWeb.models;


import com.example.CryptoCezarWeb.services.PinCodeService;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Crypto extends BaseCrypto implements iCrypto {


    /**
     * Базовый конструктор класса Crypto
     *
     * @param layout последовательность
     * @param cesar  сдвиг Цезаря
     */
    public Crypto(PinCodeService pinCodeService, Layout layout, Cesar cesar) {
        super(pinCodeService, layout, cesar);
    }

    /**
     * Получить базовое шифрование
     * @param word введённое слово
     * @return зашифрованое слово
     */
    public String getCryptoCesarWord(String word)
    {
        return cycle(word).toString();
    }

    /**
     * Перегрузка метода базового шифрования с условиям разворота слова.
     * @param word введённое слово
     * @param reverse нужен ли разворот слова?
     * @return зашифрованное слово
     */
    public String getCryptoCesarWord(String word, boolean reverse)
    {
        StringBuilder stringBuilder = new StringBuilder(word);
        return cycle(stringBuilder.reverse().toString(),  false)
                .reverse().toString();
    }

    /**
     * Метод получения зашифрованоего слова где индексы числа идут от старшего разряда
     * @param word введённое слово
     * @return зашифрованное  слово
     */
    public String getCryptoCesarWordReversedNum(String word)
    {
        StringBuilder stringBuilder = new StringBuilder(word);
        return cycle(stringBuilder.reverse().toString(),  true)
                .reverse().toString();
    }
}
