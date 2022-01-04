package com.filedemo;


import java.io.*;

public class FileUtil {

    /**
     * 按行读取文件
     */
    public static void ReadFileByLine(String filename, String outFileName) {
        File file = new File(filename);
        File outFile = new File(outFileName);
        InputStream is = null;
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            is = new FileInputStream(file);
            reader = new InputStreamReader(is);
            bufferedReader = new BufferedReader(reader);
            //
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufw = new BufferedWriter(outputStreamWriter);//缓冲
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {

                // System.out.println(line);
                //bufferedReader.
                // outputStreamWriter.write(bufferedReader.readLine());
                System.out.println(bufferedReader.readLine());
                bufw.write(bufferedReader.readLine());
                bufw.newLine();
                bufw.flush();

                //bufw.;
            }
            bufw.flush();//刷新
            bufw.close();//关闭缓冲区
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedReader)
                    bufferedReader.close();
                if (null != reader)
                    reader.close();
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按字节读取文件
     *
     * @param filename
     */
    public static void ReadFileByBytes(String filename) {
        File file = new File(filename);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            int index = 0;
            while (-1 != (index = is.read())) {
                System.out.write(index);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-----------------------------------");
        try {
            is = new FileInputStream(file);
            byte[] tempbyte = new byte[1000];
            int index = 0;
            while (-1 != (index = is.read(tempbyte))) {
                System.out.write(tempbyte, 0, index);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按字符读取文件
     *
     * @param filename
     */
    public static void ReadFileByChar(String filename) {
        File file = new File(filename);
        InputStream is = null;
        Reader isr = null;
        try {
            is = new FileInputStream(file);
            isr = new InputStreamReader(is);
            int index = 0;
            while (-1 != (index = isr.read())) {
                System.out.print((char) index);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
                if (null != isr)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过OutputStreamWriter写文件
     *
     * @param filename
     */
    public static void Write2FileByOutputStream(String filename) {
        File file = new File(filename);
        FileOutputStream fos = null;
        // BufferedOutputStream bos = null;
        OutputStreamWriter osw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            osw.write("Write2FileByOutputStream");
            // bos = new BufferedOutputStream(fos);
            // bos.write("Write2FileByOutputStream".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != osw) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 通过BufferedWriter写文件
     *
     * @param filename
     */
    public static void Write2FileByBuffered(String filename) {
        File file = new File(filename);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            bw.write("Write2FileByBuffered");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != osw) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 通过FileWriter写文件
     *
     * @param filename
     */
    public static void Write2FileByFileWriter(String filename) {
        File file = new File(filename);
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write("Write2FileByFileWriter");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fw) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String inFileStr = "D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\nioInput.txt";//nioInput.txtD:\work_tydic\testDemo\com.test\src\main\resources\nioInput.txt
        String outFileStr = "D:\\work_tydic\\testDemo\\com.test\\src\\main\\resources\\nioOutput.txt";

        Long startTime = System.nanoTime();
        String filename = "D:/testfile.txt";
        ReadFileByLine(inFileStr,outFileStr);
        Long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
    }
}

