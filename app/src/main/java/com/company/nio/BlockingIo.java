package com.company.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Buffer是缓冲区
 * channel从文件或者网络读取数据都要经过buffer
 * channel->buffer channel.read buf.put
 * buffer->channel channel.write buf.get
 */
public class BlockingIo {
    public static void method2(){
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("1.txt"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void method1() throws IOException {
        RandomAccessFile aFile;
        aFile = new RandomAccessFile("1.txt", "rw");
        FileChannel fileChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = fileChannel.read(buf);
    }

    public static void test4() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("a.txt", "rw");
        // 获取通道
        FileChannel channel = raf.getChannel();
        // 分配指定大小缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(2);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        // 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel.read(bufs);  // 参数需要一个数组
        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();  // 切换到读模式
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));  // 打印 he
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));  // 打印 llo

        // 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("e.txt","rw");
        // 获取通道
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);  // 把 bufs 里面的几个缓冲区聚集到 channel2 这个通道中，聚集到通道中，也就是到了 e.txt 文件中
        channel2.close();
    }
}
