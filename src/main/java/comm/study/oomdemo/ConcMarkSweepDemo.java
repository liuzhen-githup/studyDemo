/**
 * Copyright(c) 2018 asura
 */
package comm.study.oomdemo;

/**
 * <p></p>
 *
 * CMS并发收集器
 *  1. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC  (DefNew + Tenured)
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/24 8:35 下午
 */
public class ConcMarkSweepDemo {


    static byte[] bytes = null;
    public static void main(String[] args) {

        bytes = new byte[10 *1024 *1024];
    }
}
