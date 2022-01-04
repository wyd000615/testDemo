package com.thread;

public class ThreadTest {

    public static void main(String[] args) {
        MyThreadTest t1 = new  MyThreadTest();
        MyThreadTest t2= new  MyThreadTest();
        MyThreadTest t3 = new  MyThreadTest();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }


}

class MyThreadTest implements Runnable {
    static volatile int count = 50;
    // 创建一个静态钥匙
    static Object ob = "aa"; //值是任意的

    // 通过构造方法给线程名字赋值

    @Override
    public void run() {
        while(count>0) {
            synchronized (ob) {
                if (count > 0) {
                    count--;
                    System.out.println(Thread.currentThread().getName() + "===" + count);
                   // System.out.println(() +count);
                }
            }
        }

    }


}