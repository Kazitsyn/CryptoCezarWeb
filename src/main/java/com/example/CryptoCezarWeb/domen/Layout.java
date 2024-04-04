package com.example.CryptoCezarWeb.domen;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Getter
@Setter
public class Layout {
    private char[] layout = new char[]{
            '1','2','3','4','5','6','7','8','9','0',
            'q','w','e','r','t','y','u','i','o','p',
            'a','s','d','f','g','h','j','k','l',
            'z','x','c','v','b','n','m'};
//    private LayoutEntity layoutEntity;
//    private char[] layout ;

//    public void setLayoutEntity(LayoutEntity layout){
//        this.layoutEntity = layout;
//        this.layout = layout.getContent().toCharArray();
//    }

    public Layout(char[] layout)
    {
        this.layout = layout;
    }

    public Layout() {}

    public char[] getLayout()
    {
        return layout;
    }

    public int getIndexChar(char x)
    {
        for (int i = 0; i < layout.length; i++)
        {
            if (layout[i] == x)
            {
                return i;
            }
        }
        return -1;
    }

    public int getSize()
    {
        return layout.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(layout);
    }
}
