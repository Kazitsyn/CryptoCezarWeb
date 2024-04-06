package com.example.CryptoCezarWeb.models;

import com.example.CryptoCezarWeb.services.PinCodeService;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BaseCrypto {

    protected final PinCodeService pinCodeService;
    protected int pin = 1206100;
    protected Layout layout;
    protected Cesar cesar;
    protected int passwordSize = 8;
    protected int wordSize;

    /**
     * Базовый конструктор класса Crypto
     * @param pinCodeService сервисный класс пин-кода
     * @param layout последовательность
     * @param cesar сдвиг Цезаря
     */
    public BaseCrypto(PinCodeService pinCodeService, Layout layout, Cesar cesar)
    {
        this.pinCodeService = pinCodeService;
        this.layout = layout;
        this.cesar = cesar;
    }

    /**
     * Внутренний  метод класса, базовый алгоритм.
     * @param word введённое слово
     * @return зашифрованное слово
     */
    protected StringBuilder cycle(String word)
    {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < passwordSize-1; i++)
        {
            int index = layout.getIndexChar(word.toCharArray()[enumerationIndex(i,word)]);
            int shift = pinCodeService.
                    getDigitOfTheNumber(enumerationIndex(i, pinCodeService.getStringNumber(pin)),pin);
            char res = cesar.getShift(index, shift);
            result.append(res);
        }
        changeRegisterAndAddNumber(result, getIndexForNumber(word));
        return result;
    }
    /**
     * Метод изменения регистра по индексу и замены последнего элемента на этот индекс
     * @param word исходное слово
     * @param index индекс
     */
    private void changeRegisterAndAddNumber(StringBuilder word, int index){
        char ch = word.charAt(index);
        word.setCharAt(index,Character.toUpperCase(ch));
        word.append(index);
    }

    /**
     * Определения индекса в случае когда он не в границах слова
     * @param index исходный индекс
     * @param word исходное слово
     * @return новый индекс
     */
    private int enumerationIndex(int index, String word){
        while (word.length() <= index){
            index = index - word.length();
        }
        return index;
    }
    /**
     * Метод определения индекса в котом будет изменен регистр
     * @param word исходное слово
     * @return индекс
     */
    private int getIndexForNumber(String word){
        int result = wordSize % 10;
        while (wordSize <= result){
            result = result - word.length();
        }
        return result;
    }
    /**
     * Внутренний  метод класса, базовый алгоритм.(перегрузка)
     * @param word введённое слово
     * @param pinGetReversedNumberOfCharArray разворот числа?
     * @return зашифрованное слово
     */
    protected StringBuilder cycle(String word, boolean pinGetReversedNumberOfCharArray)
    {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < passwordSize-1; i++)
        {
            int indexForChar = enumerationIndex(i,word);
            int index = layout.getIndexChar(word.toCharArray()[indexForChar]);

            if (pinGetReversedNumberOfCharArray)
            {
                if (pinCodeService.getDigitLength(pin) < i+1){
                    int shift = pinCodeService
                            .getReversedNumberOfCharArray(pin)[i-pinCodeService.getDigitLength(pin)]-'0';
                    char res = cesar.getShift(index, shift);
                    result.append(res);
                    continue;
                }
                int shift = pinCodeService.getReversedNumberOfCharArray(pin)[i]-'0';
                char res = cesar.getShift(index, shift);
                result.append(res);
            }
            else
            {
                int shift = pinCodeService.
                        getDigitOfTheNumber(enumerationIndex(i, pinCodeService.getStringNumber(pin)),pin);
                char res = cesar.getShift(index, shift);
                result.append(res);
            }
        }
        changeRegisterAndAddNumber(result, getIndexForNumber(word));
        return result;
    }




}
