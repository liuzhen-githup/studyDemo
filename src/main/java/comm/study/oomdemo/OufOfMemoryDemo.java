/**
 * Copyright(c) 2018 asura
 */
package comm.study.oomdemo;

/**
 * <p></p>
 *
 * 对象创建超出堆外内存的大小导致内存溢出
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/22 10:02 下午
 */
public class OufOfMemoryDemo {

    public static void main(String[] args) {

        byte[] bytes = new byte[50*1024*1024];
    }
}
