/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * 生产者 消费者模式
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/16 5:13 下午
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 1; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 1; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}

/**
 * 1 线程  操作 资源类
 * 2 判断 通知 干活
 */
class ShareData{

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 生产信息
     *  多线程的判断必须使用while判断
     * @throws InterruptedException
     */
    public void increment() throws InterruptedException {
        lock.lock();
        try{
            //1判断
            while (number != 0){
                condition.await();
            }
            //2干活
            number ++;
            System.out.println(Thread.currentThread().getName()+"\t" +number);
            //3通知唤醒
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 消费信息
     *  多线程的判断必须使用while判断
     * @throws InterruptedException
     */
    public void decrement() throws InterruptedException {
        lock.lock();
        try{
            //1判断
          while (number == 0){
              condition.await();
          }
            //2干活
            number --;
            System.out.println(Thread.currentThread().getName()+"\t" +number);
            //3通知唤醒
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
