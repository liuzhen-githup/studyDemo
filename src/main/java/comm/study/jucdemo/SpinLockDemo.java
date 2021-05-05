/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import comm.study.jvmdemo.SingletonDemo;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p></p>
 *
 * 自旋锁 demo
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/13 3:25 下午
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t comm in owo");

        /**
         * 第一个线程进来 原子引用的中为null，所以判断为true，取非 则 条件不成立 ，跳出while循环
         * 当第二个线程进来，则原子引用的对象不为空，则判断条件为false，取非 则条件成立，自我循环等待上一个线程释放
         */
        while(!atomicReference.compareAndSet(null,thread)){
            System.out.println(Thread.currentThread().getName()+"循环等到锁释放......");
        }

    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t invoke MyUnlock()");
        //当线程不为空，且线程是期望线程（占用锁线程）则修改为null（释放锁）
        atomicReference.compareAndSet(thread,null);
    }


    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"one").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"two").start();
    }
}

