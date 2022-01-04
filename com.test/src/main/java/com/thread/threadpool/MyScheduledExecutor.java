package com.thread.threadpool;

import java.util.concurrent.*;

public class MyScheduledExecutor {

        // 全局用于处理接收Future对象的集合
        private ConcurrentHashMap<String, Future> futureMap = new ConcurrentHashMap<>();

        // 计划执行任务
        private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5);

        private MyScheduledExecutor() {
        }

        // 设计为单例模式
        private static final class InnerExecutorService {
            private static final MyScheduledExecutor INSTANCE = new MyScheduledExecutor();
        }
        public static MyScheduledExecutor getInstance() {
            return InnerExecutorService.INSTANCE;
        }

        public ConcurrentHashMap<String, Future> getFutureMap() {
            return futureMap;
        }

        public void shutdown() {
            executorService.shutdown();
        }

        /**
         * 执行任务
         * @param runnable {@code Runnable}
         */
        public void execute(Runnable runnable) {
            executorService.execute(runnable);
        }

        /**
         * 执行延时任务
         *
         * @param runnable {@code Runnable}
         * @param delay    延迟时间
         * @param timeUnit 时间单位
         */
        public void scheduler(Runnable runnable, long delay, TimeUnit timeUnit) {
            executorService.schedule(runnable, delay, timeUnit);
        }

        /**
         * 执行延时周期性任务scheduleAtFixedRate
         *
         * @param runnable     {@code ScheduledExecutorService.JobRunnable}
         * @param initialDelay 延迟时间
         * @param period       周期时间
         * @param timeUnit     时间单位
         * @param <T>          {@code ScheduledExecutorService.JobRunnable}
         */
        public <T extends JobRunnable> void scheduleAtFixedRate(T runnable, long initialDelay, long period, TimeUnit timeUnit) {
            Future future = executorService.scheduleAtFixedRate(runnable, initialDelay, period, timeUnit);
            futureMap.put(runnable.getJobId(), future);
        }

        /**
         * 执行延时周期性任务scheduleWithFixedDelay
         *
         * @param runnable     {@code ScheduledExecutorService.JobRunnable}
         * @param initialDelay 延迟时间
         * @param period       周期时间
         * @param timeUnit     时间单位
         * @param <T>          {@code ScheduledExecutorService.JobRunnable}
         */
        public <T extends JobRunnable> void scheduleWithFixedDelay(T runnable, long initialDelay, long period, TimeUnit timeUnit) {
            Future future = executorService.scheduleWithFixedDelay(runnable, initialDelay, period, timeUnit);
            futureMap.put(runnable.getJobId(), future);
        }

        public static abstract class JobRunnable implements Runnable {
            private String jobId;

            public JobRunnable(String jobId) {
                this.jobId = jobId;
            }

            public void terminal() {
                try {
                    Future future = MyScheduledExecutor.getInstance().getFutureMap().remove(jobId);
                    future.cancel(true);
                } finally {
                    System.out.println("jobId " + jobId + " had cancel");
                }
            }

            public String getJobId() {
                return jobId;
            }
        }
    }
