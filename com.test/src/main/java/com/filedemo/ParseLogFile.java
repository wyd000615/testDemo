package com.filedemo;


import java.io.File;
        import java.io.IOException;
        import java.io.RandomAccessFile;
        import java.nio.ByteBuffer;
        import java.nio.channels.FileChannel;
        import java.nio.charset.Charset;
        import java.util.Arrays;

/**
 * 功能：解析日志文件
 * 作者：gaohx
 * 时间：2015年5月22日上午10:15:27
 */
public class ParseLogFile {
    private File cfFile = null;
    Charset charset = null;
    RandomAccessFile raf=  null;
    FileChannel fc=null;

    //一次读取文件，读取的字节缓存数
    ByteBuffer fbb=ByteBuffer.allocate(1024*1024*5);
    //每行缓存的字节
    ByteBuffer bb=ByteBuffer.allocate(256);

    boolean EOF=false;

    public ParseLogFile(File cfFile,String charset) throws IOException {
        this.cfFile = cfFile;
        this.charset= Charset.forName("UTF-8");;
        raf = new RandomAccessFile(this.cfFile,"r");
        init();
    }

    private void init() throws IOException {
        fc=raf.getChannel();
        fc.read(fbb);
        fbb.flip();
    }

    public boolean hasNext() throws IOException {
        if(EOF)return false;

        if(fbb.position()==fbb.limit()){//判断当前位置是否到了缓冲区的限制
            if(readByte()==0)  return false;
        }
        while(true){
            if(fbb.position()==fbb.limit()){
                if(readByte()==0)  break;
            }
            byte a=fbb.get();
            if(a==13){// || a==10|| a==0
                if(fbb.position()==fbb.limit()){
                    if(readByte()==0)  break;
                }
                return true;
            }else{
                if (bb.position() < bb.limit()) {
                    bb.put(a);
                }else {
                    if(readByte()==0)  break;
                }
                //bb.put(a);
            }
        }
        return true;
    }


    private int readByte() throws IOException{
        //使缓冲区做好了重新读取已包含的数据的准备：它使限制保持不变，并将位置设置为零。
        fbb.rewind();
        //使缓冲区做好了新序列信道读取或相对 get 操作的准备：它将限制设置为当前位置，然后将该位置设置为零。
        fbb.clear();
        if(this.fc.read(fbb)==-1){
            EOF=true;
            return 0;}
        else{
            fbb.flip();
            return fbb.position();
        }
    }

    public byte[] next(){
        bb.flip();
        //此处很重要，返回byte数组方便，行被分割的情况下合并，否则如果正好达到缓冲区的限制时，一个中文汉字被拆了两个字节，就会显示不正常
        byte tm[] = Arrays.copyOfRange(bb.array(), bb.position(), bb.limit());
        bb.clear();
        return tm;
    }

}