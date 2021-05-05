/**
 * Copyright(c) 2018 asura
 */
package comm.study.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * <p></p>
 *
 * 线程池的创建使用
 *    第4种创建线程的方式
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/17 4:34 下午
 */
public class MyThreadPoolDemo {

    private volatile static int number = 1;

    /**
     * 测试拒绝策略
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService theadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <= 9; i++) {
                theadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t print value");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            theadPool.shutdown();
        }

    }


    /**
     * 线程池创建种类
     */
    @Test
    public static void createThreadPool(){
        System.out.println(Runtime.getRuntime().availableProcessors());

        //线程池指定线程数 - 10个线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //单列线程 -线程池中 只有一个线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //线程池中N个线程 根据实际状况而定
//        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 20; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 计数器 = " +number++);
                });

                TimeUnit.SECONDS.sleep(1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
