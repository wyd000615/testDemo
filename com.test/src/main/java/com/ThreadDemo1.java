package com;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread01 myThread = new MyThread01();
        myThread.setName("主线程1=");
        myThread.start();


    }
}

class MyThread01 extends Thread {
    private static final ArrayList<String> arrList;

    static {
          arrList=new ArrayList<String>();
          for (int i = 0; i <100000 ; i++) {
              arrList.add("b");
          }
      }
    @Override
    public void run() {
        while(true){
            for (int i = 0; i < 2; i++) {
                //System.out.println("子线程" + i);
                test(i);
            }
        }

    }

    public void test(int i){
        //System.out.println("===="+i);
        List<String> list = new ArrayList<String>();
        list.add("a");
        if(i==0){
           list.addAll(arrList);
        }
        for (int j = 0; j <list.size() ; j++) {
            System.out.println(list.get(j));
        }
    }

}

