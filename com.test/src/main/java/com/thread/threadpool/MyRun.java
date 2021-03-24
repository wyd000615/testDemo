package com.thread.threadpool;

import java.util.ArrayList;

public class MyRun implements  Runnable {
    private int i;

    private static final ArrayList<String> arrList1;
    private static final ArrayList<String> arrList2;
    private static final ArrayList<String> arrList3;

    static {
        arrList1=new ArrayList<String>();
        for (int i = 0; i <2 ; i++) {
            arrList1.add("a");
        }

        arrList2=new ArrayList<String>();
        for (int i = 0; i <6 ; i++) {
            arrList2.add("b");
        }

        arrList3=new ArrayList<String>();
        for (int i = 0; i <10 ; i++) {
            arrList3.add("c");
        }
    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public MyRun(int i) {
        this.i=i;
    }

    public void run() {
        while(true){
    /*        ArrayList<String> arrList = new  ArrayList<String>();
            if(i==0){
                arrList.addAll(arrList1);
            }else if (i==1){
                arrList.addAll(arrList2);
            }else{
                arrList.addAll(arrList3);
            }
            for (int j = 0; j <arrList.size() ; j++) {
                System.out.println(Thread.currentThread()+"==="+arrList.get(i));

            }*/
    Thread thread =Thread.currentThread();
            System.out.println(thread.getName()+"==============="+i);
        }
    }
}
