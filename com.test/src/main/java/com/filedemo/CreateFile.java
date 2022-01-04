package com.filedemo;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    @Test
    public void create() throws IOException {
        for (int i = 0; i <1000 ; i++) {
            createFile(String.valueOf(i));
        }
    }
    public void createFile(String i) throws IOException {
        String filePath = "D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\out";
        File dir = new File(filePath);
        // 一、检查放置文件的文件夹路径是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdirs();// mkdirs创建多级目录
        }
        File checkFile = new File(filePath + "/"+i+".txt");
        FileWriter writer = null;
        try {
            // 二、检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                checkFile.createNewFile();// 创建目标文件
            }
            // 三、向目标文件中写入内容
            // FileWriter(File file, boolean append)，append为true时为追加模式，false或缺省则为覆盖模式
            writer = new FileWriter(checkFile, true);
            writer.append("博客园Logo\n" +
                    "Powered by .NET 5.0 on Kubernetes");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer)
                writer.close();
        }
    }
}
