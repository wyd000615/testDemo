package com.thread.threadpool;

import com.thread.SaleTicketThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SaleTicketThreadPool  extends Thread{

        public static int tickets = 100;

        private Object obj = new Object();

        @Override
        public void run() {

            while(true){
                synchronized (obj) {
                    if(tickets > 0){
                        System.out.printf("%s线程正在卖出第%d张票\n",Thread.currentThread().getName(),tickets);
                        --tickets;
                    }else{
                        break;
                    }
                }
            }
        }

        public static void main(String[] args) {
            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
            for (int i = 0; i <10 ; i++) {
               // cachedThreadPool.execute(new SaleTicketThreadPool());
            new SaleTicketThread().start();

            }

        }

    }
