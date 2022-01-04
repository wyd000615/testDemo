package com.thread;

/**
 * 单线程读、写文件
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompareTest4 {
    public static void main(String args[]) {

        final long millis1 = System.currentTimeMillis();
        System.err.println(new Date());
   /*     final CyclicBarrier cb = new CyclicBarrier(1, new Runnable() {
            public void run() {
                long millis2 = System.currentTimeMillis();
                //System.out.println(millis2);
               // System.out.println(millis2 - millis1); //大约1-2ms
            }
        });
*/

        Read4 read = new Read4(millis1);
        ExecutorService service = Executors.newFixedThreadPool(1);
        for (int i = 1; i <= 1; i++) {
            service.execute(new Thread(read, "线程" + i));
        }
        long millis2 = System.currentTimeMillis();
        System.out.println("总用时="+(millis2-millis1));
    }
}

class Read4 implements Runnable {
    static long time =0L;

    Object o = new Object();
    List<File> filePathsList = new ArrayList<File>();
    int index = 0;
   // CyclicBarrier cb2;
    long millis1 =0;
/*
    public Read4(CyclicBarrier cb) {
        this.cb2 = cb;
        File f = new File("D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\thread-file");
        getFileList(f);
    }*/

    public Read4(long millis1) {
        this.millis1 = millis1;
        File f = new File("D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\thread-file");
        getFileList(f);
    }
    private void getFileList(File f) {
        File[] filePaths = f.listFiles();
        for (File s : filePaths) {
            if (s.isDirectory()) {
                getFileList(s);
            } else {
                if (-1 != s.getName().lastIndexOf(".txt")) {
                 //System.out.println("==获取到的文件为="+s.getName());
                 filePathsList.add(s);
                }
            }
        }
    }

    public void run() {
        File file = null;
        File f2 = null;
        while (index < filePathsList.size()) {
            synchronized (o) {
                if (index > filePathsList.size()) {
                    return;
                }
                file = filePathsList.get(index);
                index++;
                //System.out.println("内部index: " + index);
            }

            // System.out.println("文件: " + file.getName());
            FileReader fr = null;
            BufferedReader br = null;
            StringBuffer sb = new StringBuffer();

            FileWriter fw = null;
            BufferedWriter bw = null;
            String filePath = "D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\out";
            File dir = new File(filePath);
            // 一、检查放置文件的文件夹路径是否存在，不存在则创建
            if (!dir.exists()) {
                dir.mkdirs();// mkdirs创建多级目录
            }
            f2 = new File(filePath + File.separator + file.getName());

            try {
                if (!f2.exists()) {
                    f2.createNewFile();// 创建目标文件
                }
                fr = new FileReader(file);
                br = new BufferedReader(fr);

                fw = new FileWriter(f2);
                bw = new BufferedWriter(fw);

                String data = "";
                while ((data = br.readLine()) != null) {
//sb.append(data + "\r");
                    bw.write(data + "\r");
                }

                bw.write("---------------" + Thread.currentThread().getName() + "---------------");
                long millis2 = System.currentTimeMillis();
/*long millis2 = System.currentTimeMillis();
 System.out.println(millis2);
 System.out.println("一个文件用时"+(millis2 - millis)); //大约1-2ms*/
                time=(millis2 - millis1);
                System.out.println(time);
                System.err.println(new Date());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bw.close();
                    br.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


