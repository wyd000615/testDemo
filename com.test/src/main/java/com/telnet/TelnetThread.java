package com.telnet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TelnetThread  implements  Runnable{
    private String hostName ="";
    private int start;
    private int end;
    private int  timeOut ;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public TelnetThread(String hostName, int start, int end, int timeOut) {
        this.hostName = hostName;
        this.start = start;
        this.end = end;
        this.timeOut = timeOut;
    }

    /**
     * 测试telnet 机器端口的连通性
     * @param hostname
     * @param port
     * @param timeout
     * @return
     */
    public static boolean telnet(String hostname, int port, int timeout){
        Socket socket = new Socket();
        boolean isConnected = false;
        try {
            socket.connect(new InetSocketAddress(hostname, port), timeout); // 建立连接
            isConnected = socket.isConnected(); // 通过现有方法查看连通状态
//            System.out.println(isConnected);    // true为连通
        } catch (IOException e) {
            //System.out.println(Thread.currentThread()+"====false1===port=="+port+"=e"+e);        // 当连不通时，直接抛异常，异常捕获即可
        }finally{
            try {
                socket.close();   // 关闭连接
            } catch (IOException e) {
                System.out.println("false");
            }
        }
        return isConnected;
    }
    @Override
    public void run() {
        for (int i = start; i <end ; i++) {

            boolean isConnected = telnet(hostName,i,timeOut);
            if(isConnected){
                System.err.println("telnet "+ hostName + " " +i + "==>isConnected: " + isConnected);
            }
        }
    }
}
