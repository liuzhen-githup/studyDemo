/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * 信号灯
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/15 2:15 下午
 */
public class SemaphoreDemo {

    /**
     * 模拟停车位，车位5个 ，10辆车
     *  多线程抢占，当车位占满，其余线程等待，直到释放，后续线程继续抢占，直至结束
     * @param args
     */
    public static void main(String[] args) {
        //模拟车位5个
        Semaphore semaphore = new Semaphore(5);

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢占车位");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"\t 停车结束，车位释放");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
