package com;

import org.junit.Test;

public class SubstringDemo {
    @Test
    public void tets(){
        String  str ="1234567890";
        str = str.substring(str.length()-4,str.length());
        System.out.println(str);
    }

}
