package com.example.CryptoCezarWeb.service;

import org.springframework.stereotype.Service;

@Service
public class PinCodeService {

    public int getDigitLength(int pinNumber)
    {
        String result = String.valueOf(pinNumber);
        return result.length();
    }

    public int getDigitOfTheNumber(int index, int pinNumber)
    {
        if (index >= getDigitLength(pinNumber))
        {
            index = index - getDigitLength(pinNumber);
        }
        return (int) (pinNumber / Math.pow(10, index))%10;
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
}
