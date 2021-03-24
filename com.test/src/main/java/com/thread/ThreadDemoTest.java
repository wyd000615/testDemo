package com.thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadDemoTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ThreadDemoTest.class);
        Thread thread1 = new Thread(new ThreadDemo());
        thread1.setName("第一");
        thread1.start();
        Thread thread2 = new Thread(new ThreadDemo());
        thread2.setName("第二");
        thread2.start();
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.run();
    }
}

class ThreadDemo implements  Runnable{
    private static final Logger log = LoggerFactory.getLogger(ThreadDemo.class);

    public void run() {
        Thread.currentThread().setName("群组模组"+"JIDO");
        System.out.println(Thread.currentThread().getName()+"====子线程==ThreadDemo==");
        log.info(Thread.currentThread().getName()+"====子线程==ThreadDemo==");
    }
}
