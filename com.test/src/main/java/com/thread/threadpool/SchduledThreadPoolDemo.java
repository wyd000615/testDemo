package com.thread.threadpool;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class SchduledThreadPoolDemo {
/*    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> future = scheduled.schedule(() -> {
            try {
                System.out.println("开始执行任务");
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕");
        }, 1000, TimeUnit.MILLISECONDS);
        System.out.println("阻塞开始");
        System.out.println(future.get() + "");
        System.out.println("阻塞结束");
    }*/
/*public static void main(String[] args) throws ExecutionException, InterruptedException {
    ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<String> future = scheduled.schedule(() -> {
        try {
            System.out.println("开始执行任务");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕");
        return "success";
    }, 1000, TimeUnit.MILLISECONDS);
    System.out.println("阻塞开始");
    System.out.println(future.get() + "");
    System.out.println("阻塞结束");
}*/
public static void main(String[] args) throws Exception {

    MyScheduledExecutor service = MyScheduledExecutor.getInstance();
    service.execute(() -> System.out.println("execute"));
//    service.scheduler(new Runnable() {
//        @Override
//        public void run() {
//            for (Map.Entry<String, Future> next : service.getFutureMap().entrySet()) {
//                String key = next.getKey();
//                int i = Integer.parseInt(key.substring(3));
//                // 停止部分线程
//                if (i % 2 == 0) {
//                    next.getValue().cancel(true);
//                }
//            }
//        }
//    }, 20, TimeUnit.SECONDS);

    for (int i = 0; i < 5; i++) {
        int num = new Random().nextInt(500);
        service.scheduleAtFixedRate(new MyScheduledExecutor.JobRunnable("scheduleAtFixedRate" + num) {
            @Override
            public void run() {
                System.out.println(num);
            }
        }, 10, 2, TimeUnit.SECONDS);
    }
    Thread.sleep(15000);
    for (Map.Entry<String, Future> next : service.getFutureMap().entrySet()) {
        String key = next.getKey();
        int i = Integer.parseInt(key.substring(3));
        // 停止部分线程
        if (i % 2 == 0) {
            next.getValue().cancel(true);
        }
    }
    Thread.sleep(20000);
    service.shutdown();
}

}
