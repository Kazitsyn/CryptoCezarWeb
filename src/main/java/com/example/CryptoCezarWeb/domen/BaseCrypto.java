package com.example.CryptoCezarWeb.domen;

import com.example.CryptoCezarWeb.service.PinCodeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BaseCrypto {

    protected final PinCodeService pinCodeService;
    protected int pin = 1206100;
    protected Layout layout;
    protected Cesar cesar;
    protected int passwordSize = 8;

    /**
     * Базовый конструктор класса Crypto
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
     * @param pinGetReversedNumberOfCharArray разворот числа?
     * @return зашифрованное слово
     */
    protected StringBuilder cycle(String word, boolean pinGetReversedNumberOfCharArray)
    {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < passwordSize; i++)
        {
            int index = layout.getIndexChar(word.toCharArray()[i]);

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
                int shift = pinCodeService.getDigitOfTheNumber(i, pin);
                char res = cesar.getShift(index, shift);
                result.append(res);
            }
        }
        return result;
    }

}
