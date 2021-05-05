/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * <p></p>
 *
 * ABA问题解决 原子引用操作+版本号（时间戳）
 *   -- 使用 JUC 包下的类 AtomicStampedReference
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/10 11:44 下午
 */
public class ABADemo {


    static AtomicReference<Integer> atomicReference = new AtomicReference<>(66);

    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(11,1);

    public static void main(String[] args) {
        ABASolve();
    }

    /**
     * 解决CAS带来的ABA问题
     *   AtomicStampedReference
     */
    public static void ABASolve(){
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 获取初始版本号信息："+ stamp);
            //这里暂停1秒是为了让线程TB也获取到初始版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**
             *  compareAndSet(V expectedReference,V newReference,int expectedStamp,int newStamp);
             *  四个参数分别为： 期望值 、更新值 、期望版本号、更新版本号
             */
            atomicStampedReference.compareAndSet(11,33,stamp,atomicStampedReference.getStamp()+1); //A-B
            atomicStampedReference.compareAndSet(33,11,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1); //B-A
            System.out.println(Thread.currentThread().getName()+"\t 获取内存值："+atomicStampedReference.getReference()+"\t 获取最终版本号："+atomicStampedReference.getStamp());

        },"TA").start();


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 获取初始版本号信息："+stamp);
            //这里暂停3秒是为了让线程TA 完成一次ABA操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(11,55,stamp,atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t get version number = "+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t 交换结果="+result+"\t 结果值为："+atomicStampedReference.getReference());

        },"TB").start();
    }

    /**
     *CAS操作带来的ABA问题验证
     *  线程A在执行完2次交换操作 使主内存的值 从 A-B-A 完成了一次ABA操作
     *  线程B执行时，并不知道线程A的中间的操作过程，认为主内存的值没变而进行了一次CAS操作
     */
    public static void ABAQuestion(){
        new Thread(()->{
            //将 66 与主内存的值比较，若一致则修改为88
            atomicReference.compareAndSet(66,88); //A-B
            //将 88 与主内存的值比较，若一致修改回66
            atomicReference.compareAndSet(88,66);//B-A
        },"A").start();

        new Thread(()->{
            //线程 two 先沉睡1秒，这样是为了保证线程one 完成ABA的操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(66,99)+"\t compare set value "+ atomicReference.get());
        },"B").start();
    }
}
