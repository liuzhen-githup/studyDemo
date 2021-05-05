/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 * synchronized 与 ReentrantLock
 * 1.构成
    synchronized 是关键字属于JVM层面
        monitorenter（底层是通过monitor对象来完成，其实wait/notify等方法也依赖于monitor对象，只有在同步快或方法中才能调用wait/notify等方法）
    Lock是具体类（是JDK1.5后提供 是java.util.concurrent.locks.lock）是JDK提供的一个API
 * 2.使用方法
    synchronized 不需要用户去手动释放锁，当synchronized代码执行完成后系统会自动释放线程对资源的占用
    ReentrantLock 则需要用户手动释放对锁的占用，若没有释放锁就可能导致死锁的现象
        需要lock()和unlock()方法配合try/finally语句块完成

 * 3.等待是否可中断
    synchronized不可中断 ，除非抛出异常或者正常执行完成
    ReentrantLock 可中断
        1.设置超时方法tryLock(long timeout,TimeUnit unit)
        2.lockInterruptibly()放代码块中，调用interrupt()方法可中断

 * 4.加锁释放公平
    synchronized 非公平锁（线程首先会试着占用锁，占用失败则等待唤醒）
    ReentrantLock 两者都可，默认无参构造器则非公平锁；传入boolean值，true为公平锁，false非公平锁

 * 5.锁绑定多个条件Condition
    synchronized 没有
    ReentrantLock 用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不像synchronized要么随机唤醒一个 要么唤醒全部线程

 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/16 6:06 下午
 */
public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResource resource = new ShareResource();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }



}

class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();


    public void print5() throws InterruptedException {
        lock.lock();
        try{
            if(number!=1){
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " +i);
            }
            number =2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try{
            if(number != 2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " +i);
            }
            number = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try{
            if(number!=3){
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " +i);
            }
            number =1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
