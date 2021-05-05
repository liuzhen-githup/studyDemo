/**
 * Copyright(c) 2018 asura
 */
package comm.study.oomdemo;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * NIO分配本地内存（元空间）,不分配JVM虚拟机内存，本地内存不足导致异常
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/24 2:51 下午
 */
public class DirectByteBufferDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("配置的maxDirectMemorySize: "+sun.misc.VM.maxDirectMemory() / 1024 /1024 +"MB");

        TimeUnit.SECONDS.sleep(3);

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 *1024);


    }

}
