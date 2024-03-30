package com.example.CryptoCezarWeb.domen;


import org.springframework.stereotype.Component;

@Component
public class Crypto extends BaseCrypto {


    /**
     * Базовый конструктор класса Crypto
     *
     * @param pin    pin-код
     * @param layout последовательность
     * @param cesar  сдвиг Цезаря
     */
    public Crypto(Pin pin, Layout layout, Cesar cesar) {
        super(pin, layout, cesar);
    }

    /**
     * Получить базовое шифрование
     * @param word введённое слово
     * @return зашифрованое слово
     */
    public String getCryptoCesarWord(String word)
    {
        return cycle(word,  false).toString();
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
