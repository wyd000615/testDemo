package com.thread;

public class TestThread {
    public static void main(String[] args) {
        for (int i = 0; i <5; i++) {
            Thread thread = new MyThread(i);
            thread.setName("线程"+i);
            thread.start();
        }
    }
}
