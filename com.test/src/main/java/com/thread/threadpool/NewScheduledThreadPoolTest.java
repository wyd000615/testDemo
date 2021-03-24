package com.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 创建一个线程池，该线程池可以调度在给定延迟之后运行的命令，或者定期执行命令。
 */
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            scheduledThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"----被创建");
                }
            });
        }
    }
}
