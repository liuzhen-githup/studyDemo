/**
 * Copyright(c) 2018 asura
 */
package comm.study.gcdemo;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/20 2:12 下午
 */
public class HaloGc {

    public static void main(String[] args) {
        //返回Java 虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        //返回Java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory +"(字节)、"+(totalMemory / 1024 / 1024) +"MB");
        System.out.println("MAX_MEMORY(-Xms) = " + maxMemory +"(字节)、"+(maxMemory / 1024 / 1024) +"MB");
    }
}
