package com.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * 自定义
 * */
public class CustomizeThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建数组型缓冲等待队列
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(10);
        // ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为3，允许最大的线程数为6
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 100, 50, TimeUnit.MILLISECONDS, bq);
/*        // 创建3个任务
        Runnable t1 = new myThread();
        Runnable t2 = new myThread();
        Runnable t3 = new myThread();
        Runnable t4 = new myThread();
        Runnable t5 = new myThread();
        Runnable t6 = new myThread();

        // 3个任务在分别在3个线程上执行
        tpe.execute(t1);
        tpe.execute(t2);
        tpe.execute(t3);
        tpe.execute(t4);
        tpe.execute(t5);
        tpe.execute(t6);*/
     /*   for (int i = 0; i <100 ; i++) {
            tpe.execute(new myThread());

        }*/
        for (int i = 0; i <100 ; i++) {
            Thread.sleep(1000);
            tpe.execute(new myThread());

        }
        // 关闭自定义线程池
        tpe.shutdown();
    }

    static class myThread implements Runnable {

                 @Override
            public void run() {

                     try{
                         Thread.sleep(5000);
                         System.out.println(Thread.currentThread().getName()+"----被创建");

                     }catch (Exception e){

                     }

        }
    }
}
