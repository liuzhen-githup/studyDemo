/**
 * Copyright(c) 2018 asura
 */
package comm.study.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * <p></p>
 *
 1. 在 Java NIO中负责数据的存取，缓冲区就是数组，用于存储不同数据类型的数据
     根据数据类型不同（除了Boolean除外），提供了相应类型的缓冲区
     ByteBuffer
     CharBuffer
     ShortBuffer
     IntBuffer
     LongBuffer
     FloatBuffer
     DoubleBuffer
    上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
 2. 缓冲区存取数据的两个核心的方法：
    put(); 存入数据到缓冲区
    get(); 从缓冲区中取数据
 3. 缓冲区中的四个核心的属性：
     capacity: 容量，表示缓冲区中最大的存储数据的容量，一旦申明不能改变
     limit: 界限，表示缓冲区中可以操作数据的大小 （limit后数据不能进行读写）
     position:位置，表示缓冲区中正在操作的数据的位置

 position <= limit <= capacity
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/29 11:28 上午
 */
public class TestPicsBuffer {

    @Test
    public void  testBuffers(){
        //分配缓冲区的大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("----------------allocate()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        //数据put
        System.out.println("----------------put()-------------------");
        buffer.put(new String("abcde").getBytes(StandardCharsets.UTF_8));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //切换读取的模式
        buffer.flip();
        System.out.println("----------------flip()-------------------");
        //操作数据的位置
        System.out.println(buffer.position());
        //可操作的数据大小
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        System.out.println("----------------get()---------------end----");
        byte[] arrs = new byte[buffer.limit()];
        ByteBuffer byteBuffer = buffer.get(arrs);
        System.out.println(new String(arrs,0,arrs.length));
        //操作数据的位置
        System.out.println(buffer.position());
        //可操作的数据大小
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //将操作数据的位置重置初始位置，重读操作
        buffer.rewind();
        System.out.println("----------------rewind()-------------------");
        //操作数据的位置
        System.out.println(buffer.position());
        //可操作的数据大小
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        buffer.get(arrs);
        System.out.println(new String(arrs,0,arrs.length));

        //清空缓冲区 ，但是缓冲区的数据依然还在，但是处于被"遗忘"状态
        buffer.clear();
        System.out.println("----------------clear()-------------------");
        //操作数据的位置
        System.out.println(buffer.position());
        //可操作的数据大小
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
    }


    @Test
    public void test2(){
        String str = "abcdf";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes(StandardCharsets.UTF_8));

        buffer.flip();
        System.out.println(buffer.limit());
        byte[] arrs = new byte[buffer.limit()];

        buffer.get(arrs,0,2);
        buffer.mark();//标记
        System.out.println(new String(arrs,0,2));
        System.out.println(buffer.position());

        buffer.get(arrs,2,2);
        System.out.println(new String(arrs,2,2));
        System.out.println(buffer.position());

        buffer.reset(); //重置到mark的位置
        System.out.println(buffer.position());

    }

    @Test
    public void  test3(){

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        String str = "adaf";

        buffer.put(str.getBytes(StandardCharsets.UTF_8));

        buffer.flip();

        byte[] arrs = new byte[buffer.limit()];

        buffer.get(arrs);

        System.out.println(new String(arrs,0,arrs.length));
    }

}
