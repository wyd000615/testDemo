package com.thread;

/**
 * 多线程读、写文件
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
* 多线程处理文件  492ms
*
* */
public class CompareTest3 {
    public static void main(String args[]) {
        long millis1 = System.currentTimeMillis();
        System.out.println(millis1);
        Read3 read = new Read3(millis1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 3; i++) {
            service.execute(new Thread(read, "线程" + i));
        }
        long millis2 = System.currentTimeMillis();
        //System.out.println("总用时="+(millis2-millis1));
    }
}

class Read3 implements Runnable {
    static long time =0L;
    Object o = new Object();
    List<File> filePathsList = new ArrayList<File>();
    int index = 0;
    private long millis;

    public Read3(long millis1) {
        this.millis = millis1;
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
            //     System.out.println("==获取到的文件为="+s.getName());
                    filePathsList.add(s);
                }
            }
        }
    }

    @Override
    public void run() {

        File file = null;
        File f2 = null;
        while (index < filePathsList.size()) {
            //此处，保证了多线程不会交叉读取文件
            //--1.1方法内的变量是线程安全的
            //解释：由于方法内的变量是私有的，本体访问的同时别人访问不了，所以是线程安全的。
            //--1.2实例变量是非线程安全的
            //解释：由于实例变量可以由多个线程访问，当本体操作变量过程中，别人也可以抢占资源操作变量，使数据不同步了，所以是非线程安全的。

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
            f2 = new File(filePath+ File.separator + file.getName());

            try {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                if (!f2.exists()) {
                    f2.createNewFile();// 创建目标文件
                }
                fw = new FileWriter(f2);
                bw = new BufferedWriter(fw);

                String data = "";
                while ((data = br.readLine()) != null) {
//sb.append(data + "\r");
                    bw.write(data + "\r");
                }

                bw.write("---------------" + Thread.currentThread().getName() + "---------------");
              // System.out.println(Thread.currentThread().getName() + " : " + file.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bw.close();
                    br.close();
                    long millis2 = System.currentTimeMillis();
/*long millis2 = System.currentTimeMillis();
 System.out.println(millis2);
 System.out.println("一个文件用时"+(millis2 - millis)); //大约1-2ms*/
                    time=(millis2 - millis);
                    System.out.println(time);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

