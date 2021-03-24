package com.thread.juc;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        //final CountDownLatch latch = new CountDownLatch(10);//有多少个线程这个参数就是几
        //MyThread ld = new MyThread(latch);
        MyThread ld = new MyThread();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(ld).start();
        }
      //  latch.await();
        long endTime = System.currentTimeMillis();
        System.err.println((endTime - startTime));
    }


    static class MyThread implements Runnable {
        CountDownLatch latch = null;
        MyThread(){

        }
        MyThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            synchronized (this) {
                try {

                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "====");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                   // latch.countDown();//每执行完一个就递减一个
                }
            }
        }
    }
}
