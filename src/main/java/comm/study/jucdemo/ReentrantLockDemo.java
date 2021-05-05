/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * 重入锁
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/12 8:49 下午
 */
public class ReentrantLockDemo {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        new Thread(() ->{
            demo.sendSms();

        },"thread1").start();

        new Thread(() ->{
            demo.sendSms();
        },"thread2").start();

        TimeUnit.SECONDS.sleep(4);
        System.out.println("-----------------------------------------");

        Thread thread3 = new Thread(new Demo(),"thread3");
        Thread thread4 = new Thread(new Demo(),"thread4");
        thread3.start();
        thread4.start();

    }

}

class Demo implements Runnable{

    private Lock lock = new ReentrantLock();
    public synchronized void sendSms(){
        System.out.println(Thread.currentThread().getName()+"输出信息。。。");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendSms2();
    }
    public synchronized void sendSms2(){
        System.out.println(Thread.currentThread().getName()+"发送短信。。。");
    }


    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t get invoke()");
            set();
        } finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t set invoke()");
        }finally {
            lock.unlock();
        }
    }
}