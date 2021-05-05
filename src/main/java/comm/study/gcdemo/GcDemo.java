/**
 * Copyright(c) 2018 asura
 */
package comm.study.gcdemo;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * 强引用
 *    触发回收机制，也不会被回收；
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/19 4:50 下午
 */
public class GcDemo {
    public static void main(String[] args) throws InterruptedException {

        Object obj1 = new Object();
        Object onj2 = obj1;

        obj1 = null;

        System.gc();

        System.out.println(obj1);
        System.out.println(onj2);
    }
}
