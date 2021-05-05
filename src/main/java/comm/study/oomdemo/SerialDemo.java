/**
 * Copyright(c) 2018 asura
 */
package comm.study.oomdemo;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * Serial串行垃圾回收器
 * 1. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC  (DefNew + Tenured)
 * ParNew并行垃圾收集器(针对于Young区 老年代仍然使用Serial Old)
 * 2. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC  (ParNew + Tenured)
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/24 6:23 下午
 */
public class SerialDemo {


    static byte[] bytes = null;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("*********************hello Serial");

       bytes = new byte[20 * 1024 * 1024];
    }
}
