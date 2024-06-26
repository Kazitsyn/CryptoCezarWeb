package com.example.CryptoCezarWeb.services;

import org.springframework.stereotype.Service;

@Service
public class PinCodeService {
    public String getStringNumber(int pinNumber){
        return String.valueOf(pinNumber);
    }

    public int getDigitLength(int pinNumber)
    {
        String result = String.valueOf(pinNumber);
        return result.length();
    }

    public int getDigitOfTheNumber(int index, int pinNumber)
    {
        return (int) (pinNumber / Math.pow(10, enumeration(pinNumber, index)))%10;
    }

    public String getReversedNumber(int pinNumber)
    {
        String result = String.valueOf(pinNumber);
        return new StringBuilder(result.replaceAll("\\D","")).reverse().toString();
    }

    public char[] getReversedNumberOfCharArray(int pinNumber)
    {
        return getReversedNumber(pinNumber).toCharArray();
    }

    private int enumeration(int pinNumber, int index){
        if (getDigitLength(pinNumber) <= index)
        {
            index = index - getDigitLength(pinNumber);
        }
        return index;
    }
}
