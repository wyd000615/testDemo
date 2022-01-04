package com.thread;

public class MyThread2 implements Runnable {

    String body;

    public MyThread2(String body) {
        this.body=body;
    }

    @Override
    public void run() {
        try {
            System.out.println("=----------1--------------"+body+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("=----------2--------------"+body+System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

