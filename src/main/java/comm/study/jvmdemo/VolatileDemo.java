/**
 * Copyright(c) 2018 asura
 */
package comm.study.jvmdemo;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 *
 *  JMM
 *   1.验证Volatile关键字修饰后 可见性
 *   2.验证Volatile关键字的不保证原子性
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/5 11:30 下午
 */
public class VolatileDemo {

    public static void main(String[] args) {
        seeAtomicVolatile();
    }

    /**
     * 验证Volatile的原子性
     * 多线程并发时，当线程将工作内存刷新到主内存时，存在可见性通知差，这样会导致写时覆盖操作！
     *
     *  下列代码执行往往会小于 20*1000 ，属于典型的Volatile不保证原子性
     */
    @Test
    public static void seeAtomicVolatile(){
        MyData myData = new MyData();
        for (int i = 1; i <= 20 ; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000 ; j++) {
                    myData.addPlusPlus();
                    //使用原子操作类，达到保证原子操作
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }
        /**
         * 当上述 20 个线程执行完毕 ，才会继续向下执行main线程，否则 main线程会一直等待 20个线程执行结束
         * 后台默认2个线程 mian线程 和GC回收线程
         */
        while (Thread.activeCount() > 2){
            Thread.yield(); //暂停，不释放资源
        }

        System.out.println(Thread.currentThread().getName()+"\t int,finally number value = "+ myData.number);
        System.out.println(Thread.currentThread().getName()+"\t atomicInteger ,finally number value = "+ myData.atomicInteger);
    }

    /**
     * 当number参数添加了 Volatile关键字修饰，其余线程可见
     */
    @Test
    public static void seeOkVolatile(){
        MyData data = new MyData();
        /**
         * 线程one 在3秒后将number修改为 60
         */
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"\t comm in,init number value = "+data.number);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t comm to,update number value = "+data.number);
        },"one").start();
        /**
         * 验证当前主线程main 是否知道值在3秒后被修改为60
         *  若不可见 则main 线程不会知道number已经被修改；则此循环为死循环
         */
        while(data.number == 0){

        }
        System.out.println(Thread.currentThread().getName()+"\t session is over， number= "+data.number);
    }
}



/**
 *  验证volatile修饰符
 */
class MyData{
    volatile int number = 0;

    /**
     * 验证Volatile的可见性
     */
    public void addTo60(){
        this.number = 60;
    }

    /**
     * 验证Volatile不保证原子性
     */
    public void addPlusPlus(){
        number ++;
    }

    /**
     * 原子类，该类的操作可保证原子操作
     */
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        //每次自增 1
        atomicInteger.getAndIncrement();

        //根据输入参数增加
//        atomicInteger.getAndAdd(1);
    }

}