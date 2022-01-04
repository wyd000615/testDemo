package com.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {
    /**
     * 采用nio方式
     * @param inFileStr
     * @param outFileStr
     */
    public static void nio01(String inFileStr, String outFileStr){
        long startTime, elapsedTime;
        int bufferSizeKB = 4;
        int bufferSize = bufferSizeKB * 1024;

        // Check file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");
        System.out.println("Buffer size is " + bufferSizeKB + " KB");
        System.out.println("Using FileChannel with an indirect ByteBuffer of " + bufferSizeKB + " KB");

        try (FileChannel in = new FileInputStream(inFileStr).getChannel();
             FileChannel out = new FileOutputStream(outFileStr).getChannel()) {
            // Allocate an indirect ByteBuffer
            ByteBuffer bytebuf = ByteBuffer.allocate(bufferSize);

            startTime = System.nanoTime();

            int bytesCount = 0;
            // Read data from file into ByteBuffer
            while ((bytesCount = in.read(bytebuf)) > 0) {
                // flip the buffer which set the limit to current position, and position to 0.
                bytebuf.flip();
                out.write(bytebuf); // Write data from ByteBuffer to file
                bytebuf.clear(); // For the next read
            }

            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void putong01(String inFileStr , String outFileStr){

    }
    public static void main(String[] args) {
      String  inFileStr= "D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\nioInput.txt";//nioInput.txtD:\work_tydic\testDemo\com.test\src\main\resources\nioInput.txt
        String outFileStr  = "D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\nioOutput.txt";
        String outFileStr2  = "D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\nioOutput2.txt";

        nio01(inFileStr,outFileStr);
        putong01(inFileStr,outFileStr2);
    }

}
