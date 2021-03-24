package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JobTest {
    public JobTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
    }
}
