package com.thread;

import java.util.ArrayList;

public class MyThread extends Thread  {
    private int i ;
    private static final ArrayList<String> arrList;

    static {
        arrList=new ArrayList<String>();
        for (int i = 0; i <6 ; i++) {
            arrList.add("b");
        }
    }
    public MyThread(int i) {
        this.i=i;
    }

    @Override
    public void run() {
       while(true){
        /*   if(MyThread.currentThread().isAlive()){
               MyThread.interrupted();
           }
*/
           ArrayList<String> list = new  ArrayList<String>();
           list.add("a");

           if(i==0){
               list.addAll(arrList);
           }
           for (int j = 0; j < list.size(); j++) {
               System.out.println(MyThread.currentThread()+"==="+i+list.get(j)+"===="+MyThread.currentThread().isAlive());
           }

           try {
               MyThread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }
    }
    public void test(){
        System.out.println(MyThread.currentThread()+"======");
    }
}
