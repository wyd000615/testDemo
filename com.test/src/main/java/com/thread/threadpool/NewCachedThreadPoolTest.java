package com.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个线程池，该线程池根据需要创建新线程，但在可用时将重用以前构造的线程。这些池通常会提高执行许多短期异步任务的程序的性能。如果可用，要执行的调用将重用以前构造的线程。如果没有可用的现有线程，将创建一个新线程并将其添加到池中。未使用60秒的线程将被终止并从缓存中删除。因此，长时间空闲的池不会消耗任何资源。注意，可以使用ThreadPoolExecutor构造函数创建具有相似属性但不同细节(例如超时参数)的池。
 * ————————————————
 * 版权声明：本文为CSDN博主「Starry-」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/nobody_1/article/details/99360455
 */
public class NewCachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i <10 ; i++) {
            cachedThreadPool.execute(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"----被创建");
                }
            });
        }
    }
}
