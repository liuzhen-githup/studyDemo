/**
 * Copyright(c) 2018 asura
 */
package comm.study.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <p></p>
 * 1. 通道-Channel ：用于源节点与目标节点的连接，在 Java NIO 中负责缓冲区中数据的传输。Channel本身不存储数据，因此需要配合缓冲区进行数据传输
 *
 * 2. 通道的主要实现类
 *  java.nio.channels.Channel 接口：
 *      ｜-- FileChannel
 *      ｜-- SocketChannel
 *      ｜-- ServerSocketChannel
 *      ｜-- DatagramChannel
 * 3.获取通道
 *   a.Java针对支持通道的类提供了 getChannel() 方法
 *      本地IO：
 *         FileInputStream/FileOutputStream
 *         RandomAccessFileInputStream
 *      网络IO：
 *          Socket
 *          ServerSocket
 *          DatagramSocket
 *  b. 在JDK 1.7中 NIO.2 针对各个通道提供了静态方法open()
 *
 *  c. 在JDK1.7中的NIO.2 的File工具类 的newByteChannel()
 *
 * 4. 通道间的直接传输，直接缓冲区
 *    transferTo(long position, long count,WritableByteChannel target)
 *      表示将通道数据复制给谁，position 初始位置，count 截止位置，target 传输给谁；一般属于输出通道调用
 *    transferFrom
 *      表示将通道的数据读取出来，position 初始位置，count 截止位置
 *
 * 5. 分散(Scatter) 和 聚集（Gather）
 *      分散读取是指从Channel中读取的数据"分散"到多个buffer中
 *      注意：按照缓冲区的顺序，从Channel 中读取的数据一次将buffer填充满
 *      聚集写入指的是从多个缓冲区中数据聚集到通道中
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/29 3:30 下午
 */
public class TestChannel {

    /**
     * 分散与聚集
     */
    @Test
    public  void test4(){
        File file;
        try {
            FileInputStream fis = new FileInputStream("a.txt");
            // 聚集写入
            FileOutputStream fos = new FileOutputStream("b.txt");
            //1.获取通道
            FileChannel channel = fis.getChannel();
            //1.获取通道
            FileChannel channel2 = fos.getChannel();


            //2.分配多个缓冲区
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            ByteBuffer buffer2 = ByteBuffer.allocate(2048);

            //3.分散读取数据
            ByteBuffer[] buffers = {buffer1,buffer2};
            while (channel.read(buffers) != -1){ //channel.read(buffers)-将通道的数据读到缓冲区
                buffer1.flip();
                buffer2.flip();
                System.out.println(new String(buffers[0].array(),0,buffers[0].limit()));
                System.out.println("---------------------------------");
                System.out.println(new String(buffers[1].array(),0,buffers[1].limit()));
                //"--------------聚集写入-------------------";
                //2.往通道写数据
                channel2.write(buffers);
                buffer1.clear();
                buffer2.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /**
     * 通道间的直接传输，直接缓冲区
     * inChannel.transferTo
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        //创建输入通道，并指定为读模式
        FileChannel inChannel = FileChannel.open(Paths.get("img.png"), StandardOpenOption.READ);
        //创建输出通道，指定为写模式，且不存在则创建文件，存在则报错
        /**
         * StandardOpenOption.CREATE_NEW - 表示文件存在则报错，否则创建
         * StandardOpenOption.WRITE - 表示支持通道的写模式
         * StandardOpenOption.READ - 表示支持通道的读模式
         */
        FileChannel outChannel = FileChannel.open(Paths.get("file3.png"), new StandardOpenOption[]{StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE});

        inChannel.transferTo(0,inChannel.size(),outChannel);
//        outChannel.transferFrom(inChannel,0,outChannel.size());
        inChannel.close();
        outChannel.close();

    }
    /**
     * 通过内存使用 直接缓冲区进行文件的复制
     */
    @Test
    public void test2(){
        try {
            //创建输入通道，并指定为读模式
            FileChannel inChannel = FileChannel.open(Paths.get("img.png"), StandardOpenOption.READ);
            //创建输出通道，指定为写模式，且不存在则创建文件，存在则报错
            /**
             * StandardOpenOption.CREATE_NEW - 表示文件存在则报错，否则创建
             * StandardOpenOption.WRITE - 表示支持通道的写模式
             * StandardOpenOption.READ - 表示支持通道的读模式
             */
            FileChannel outChannel = FileChannel.open(Paths.get("file.png"), new StandardOpenOption[]{StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE});

            //将通道数据写入到内存中，内存映射文件
            MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区(内存)进行数据的读写操作
            byte[] arrs = new byte[inMapped.limit()];
            inMapped.get(arrs);
            outMapped.put(arrs);

            inChannel.close();
            outChannel.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    /**
     * 利用通道完成文件的复制（非直接缓冲区）
     */
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("img.png");
            fos = new FileOutputStream("file.png");

            //1. 通过IO流 获取数据传输通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //2. 分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //3.将输入通道 inChannel 的数据读取到缓冲区
            while(inChannel.read(buffer) != -1){
                //切换缓冲区读取模式
                buffer.flip();
                //4.每读一次，则将缓冲区中的数据写入到输出通道 outChannel
                outChannel.write(buffer);
                //每操作一次则，重置缓冲区
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
