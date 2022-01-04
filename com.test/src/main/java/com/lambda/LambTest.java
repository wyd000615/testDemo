package com.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LambTest {

    @Test
    public void test01() throws Exception {
        System.out.println("hello");
    }
    @Test
    public void test02() throws Exception {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("world");
        //strList.forEach(x -> System.out.println(x));
        strList.forEach(x-> System.out.println( x.split("l")[0]));
        strList.forEach((x->{
           char a= x.charAt(0);
            System.out.println(a);
        }));

       // Collections

    }

}
