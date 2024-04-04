package com.example.CryptoCezarWeb.domen;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Cesar {
    private Layout layout;

//    public Cesar(Layout layout)
//    {
//        this.layout = layout;
//    }

    public char getShift(int index, int shift)
    {
        int i = index;
        int s = shift;
        int len = layout.getSize();
        if (index + shift < len){
            return layout.getLayout()[index + shift];
        }
        else
        {
            s = layout.getSize() - index;
            i = 0;
            return layout.getLayout()[i + s];
        }
    }
}
