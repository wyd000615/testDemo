package com.thread.threadpool;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(action());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static List<String> action() {
        List<String> list = new ArrayList<String>();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<String> submit1 = pool.submit(() -> action1("action1"));
        Future<String> submit2 = pool.submit(() -> action2("action2"));
        Future<String> submit3 = pool.submit(() -> action3("action3"));
        try {
            list.add(submit1.get());
            list.add(submit2.get());
            list.add(submit3.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        return list;
    }

    private static String action1(String action1) {
        sleep(1000);
        return action1 + " # " + Thread.currentThread().getName();
    }

    private static String action2(String action2) {
        sleep(2000);
        return action2 + " # " + Thread.currentThread().getName();
    }

    private static String action3(String action3) {
        sleep(5000);
        return action3 + " # " + Thread.currentThread().getName();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
