package com;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("主线程1=");
        myThread.start();

        MyThread2 myThread2 = new MyThread2();
        myThread.setName("主线程2=");

        myThread2.start();

        MyThread3 myThread3 = new MyThread3();
        myThread3.run();
        MyThread4 myThread4 = new MyThread4();
        new Thread(myThread4).start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程" + i);
        }
    }
}
class MyThread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程====" + i);
        }
    }
}
class MyThread3 implements  Runnable{

    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("runnable====="+i);
        }
    }
}
class MyThread4 implements  Runnable{

    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("runnable==!==="+i);
        }
    }
}