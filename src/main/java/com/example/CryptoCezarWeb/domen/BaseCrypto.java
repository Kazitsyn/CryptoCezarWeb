package com.example.CryptoCezarWeb.domen;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BaseCrypto {
    protected Pin pin;
    protected Layout layout;
    protected Cesar cesar;
    protected int passwordSize = 8;

    /**
     * Базовый конструктор класса Crypto
     * @param pin pin-код
     * @param layout последовательность
     * @param cesar сдвиг Цезаря
     */
    public BaseCrypto(Pin pin, Layout layout, Cesar cesar)
    {
        this.pin = pin;
        this.layout = layout;
        this.cesar = cesar;
    }

    public int getPasswordSize() {
        return passwordSize;
    }
    public void setPasswordSize(int passwordSize) {
        this.passwordSize = passwordSize;
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
                if (pin.getDigitLength() < i+1){
                    int shift = pin.getReversedNumberOfCharArray()[i-pin.getDigitLength()]-'0';
                    char res = cesar.getShift(index, shift);
                    result.append(res);
                    continue;
                }
                int shift = pin.getReversedNumberOfCharArray()[i]-'0';
                char res = cesar.getShift(index, shift);
                result.append(res);
            }
            else
            {
                int shift = pin.getDigitOfTheNumber(i);
                char res = cesar.getShift(index, shift);
                result.append(res);
            }
        }
        return result;
    }

}
