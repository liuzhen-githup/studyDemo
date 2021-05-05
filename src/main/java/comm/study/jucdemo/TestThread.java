/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/18 5:18 下午
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {

           test1();

        }, "ThreadA").start();

        new Thread(() -> {
            new TestThread().test2();
        }, "ThreadB").start();
    }

    /**
     *
     * @return
     */
    public static synchronized void test1(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1234");
    }

    /**
     *
     * @return
     */
    public synchronized void test2(){
        System.out.println("abcd");
    }
}
