package com.thread;

public class SaleTicketThread extends Thread{

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
        SaleTicketThread st1 = new SaleTicketThread();
        st1.start();

        SaleTicketThread st2 = new SaleTicketThread();
        st2.start();

    }

}
