package com.example.CryptoCezarWeb.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class Pin {
    private int pinNumber = 1206100;

    public Pin(int pinNumber)
    {
        this.pinNumber = pinNumber;
    }
    public Pin(){}


//    public int getPinNumber()
//    {
//        return pinNumber;
//    }
    public int getDigitLength()
    {
        return toString().length();
    }

    public int getDigitOfTheNumber(int index)
    {
        if (index >= getDigitLength())
        {
            index = index - getDigitLength();
        }
        return (int) (pinNumber / Math.pow(10, index))%10;
    }

    public String getReversedNumber()
    {
        return new StringBuilder(toString().replaceAll("\\D","")).reverse().toString();
    }

    public char[] getReversedNumberOfCharArray()
    {
        return getReversedNumber().toCharArray();
    }

    @Override
    public String toString()
    {
        return String.valueOf(pinNumber);
    }
}
