package com.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        int arg1 = 2;//核心线程
        int arg2 = 40;//最大线程数量
        int arg3 = 100;//空余保留时间

        ThreadPoolExecutor pool = new ThreadPoolExecutor(arg1, arg2, arg3, TimeUnit.MILLISECONDS, // 时间单位

                new LinkedBlockingQueue<Runnable>(3));//默认构造的队列大小为Integer.Max, 可指定大小new LinkedBlockingQueue<Runnable>(3)，队列容量为3
        for (int i = 0; i < 200000000; i++) {
            pool.execute(new Mythread(String.valueOf(i)));
        }
    }

}

class Mythread implements Runnable {
    String str = "";

    public Mythread() {
    }

    public Mythread(String str) {
        this.str = str;
    }


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()
                    + "正在被执行" + str);
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
}
