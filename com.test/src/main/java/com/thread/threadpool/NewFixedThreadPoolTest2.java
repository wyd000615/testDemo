package com.thread.threadpool;

import java.util.concurrent.*;

public class NewFixedThreadPoolTest2 {


    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>(2);

        // 创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool =new ThreadPoolExecutor(3, 5,0L, TimeUnit.MILLISECONDS,
                runnables  );
        for (int i = 0; i < 100; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName()
                                + "正在被执行");
                        //Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}




