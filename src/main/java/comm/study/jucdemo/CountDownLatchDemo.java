/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import java.util.concurrent.CountDownLatch;

/**
 * <p></p>
 *
 * JUC 倒计时器
 *  CountDownLatch.countDown() 方法，需要等待所有线程执行完成后才会释放
 *  CountDownLatch.await(); 主线程必须等待子线程执行完成后，才会被唤醒
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/15 11:43 上午
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"国，被灭");
                countDownLatch.countDown();
            },CountTryEnum.ForEach_CountTryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"秦帝国，一统天下");

        System.out.println(CountTryEnum.ONE.getRetMessage());
    }

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 计时器倒计时...");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t main 方法需放在最后执行");
    }
}
