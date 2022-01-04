package com.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 注意看到核心线程数和最大线程数都为nThreads，表明线程池内自始至终可用线程数为nThread；如果线程池内线程数已经达到nThreads，那么新到达的Runnable任务直接放入等待队列，由于不会再新建线程，所以为了保证池的可用性就使用无界等待队列。
 * 注意提供重载的方法，提供自定义的线程工厂。
 * ————————————————
 * 版权声明：本文为CSDN博主「Starry-」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/nobody_1/article/details/99360455s
 */
public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i <6 ; i++) {
            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try{
                        //Thread.sleep(10000);
                        System.out.println(Thread.currentThread().getName()+"----被创建");

                    }catch (Exception e){

                    }
                }
            });
        }
    }
}
