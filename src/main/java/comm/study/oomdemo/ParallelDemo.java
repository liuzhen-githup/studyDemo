/**
 * Copyright(c) 2018 asura
 */
package comm.study.oomdemo;

/**
 * <p></p>
 *1. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC  (PSYoungGen + ParOldGen)
 *2. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC  (PSYoungGen + ParOldGen)
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/24 6:51 下午
 */
public class ParallelDemo {
    static byte[] bytes = null;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("*********************hello Serial");

        bytes = new byte[20 * 1024 * 1024];
    }
}
