/**
 * Copyright(c) 2018 asura
 */
package comm.study.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/29 10:48 下午
 */
public class NonBlockingIODemo {

    @Test
    public void clientI() throws IOException {
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        //1.1 切换非阻塞模式
        socketChannel.configureBlocking(false);

        //2.设定缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.next();
            //3.发送数据给服务端,将数据写入缓冲区
            buffer.put((LocalDateTime.now() + "\t" +str).toString().getBytes(StandardCharsets.UTF_8));
            //4.将缓冲区数据写入通道
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        //5.关闭通道
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //2.切换非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //3.绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //4.获取选择器
        Selector selector = Selector.open();

        //5.将通道注册到选择器中,并且监听"客户端连接接收事件"
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6.轮询获取选择器上已经准备就绪的事件
        while(selector.select() > 0){
            //7.获取当前选择器中所有注册的"选择键（已就绪的监听事件）"
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                //8.迭代获取准备就绪的每一个事件
                SelectionKey next = iterator.next();
                //9.判断具体是什么事件准备就绪
                if(next.isAcceptable()){ //接受状态就绪
                    //10.获取客户端连接
                    SocketChannel accept = serverSocketChannel.accept();
                    //11.切换模式-非阻塞模式
                    accept.configureBlocking(false);
                    //12.将客户端通道注册到选择器上 - 准备读取客户端数据
                    accept.register(selector,SelectionKey.OP_READ);
                } else if(next.isReadable()){ //读状态就绪
                    //13.读就绪 那么通过监听器获取客户端读通道
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    //14.准备缓存区，将通道数据设置到缓存区中
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0 ;
                    while((len =socketChannel.read(buffer)) != -1){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                //15.取消选择键
                iterator.remove();
            }
        }
    }
}
