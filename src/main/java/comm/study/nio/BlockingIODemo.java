/**
 * Copyright(c) 2018 asura
 */
package comm.study.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <p></p>
 *  传统式的阻塞式IO完成一次 客户端 服务端通信
 * 1. 通道（Channel） 负责建立连接
 *          java.nio.channels.Channel 接口：
 *            ｜-- FileChannel
 *            ｜-- SocketChannel
 *            ｜-- ServerSocketChannel
 *            ｜-- DatagramChannel
 *
 *            ｜-- Pipe.SinkChannel
 *            ｜-- Pipe.SourceChannel
 *     2. 缓冲区（Buffer） 负责数据的存取
 *     3. 选择器（Selector） ：是SelectableChannel的多路复用器，用于监控SelectableChannel 的IO情况
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/29 9:56 下午
 */
public class BlockingIODemo {

    /**
     * 客户端
     */
    @Test
    public void client(){
        try {
            //1.获取通道
            SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));
            FileChannel inchannel = FileChannel.open(Paths.get("pom.xml"), StandardOpenOption.READ);

            //2.设置缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //3.数据发送
            while (inchannel.read(buffer) != -1){
                buffer.flip();
                schannel.write(buffer);
                buffer.clear();
            }
            //4.关闭流
            schannel.close();
            inchannel.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /**
     * 服务端
     */
    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel sschannel = ServerSocketChannel.open();
        //获取输出通道
        FileChannel outchannel = FileChannel.open(Paths.get("copy.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        //2.设置缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //3.与客户端绑定连接
        sschannel.bind(new InetSocketAddress(9988));
        //4.获取客户端连接通道数据
        SocketChannel cchannel = sschannel.accept();
        //5.读取客户端数据
        while (cchannel.read(buffer) != -1){
            buffer.flip();
            outchannel.write(buffer);
            buffer.clear();
        }
        //6.关闭流
        sschannel.close();
        outchannel.close();;
        cchannel.close();
    }
}
