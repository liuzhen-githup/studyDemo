/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 *
 * CAS 乐观锁 - 通过API比较堆内存的值与工作内存的值。若期望值是一致则修改，否则不变
 *  CAS操作结果只有2种情况，要么成功 要么失败
 *
 *  CAS底层是通过Unsafe类保证原子性操作。
 *  Unsafe是JDK类库中的类，是可以直接操作底层内存的数组。且方法内部是通过do while 自旋操作。
 *      自旋：当条件不满足时，自旋再次进入方法判断，直到条件满足返回
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/9 11:00 下午
 */
public class CASDemo {

    /**
     * AtomicInteger - 原子整型类，操作时保证线程的原子性
     * @param args
     */
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);

        boolean flag =  atomicInteger.compareAndSet(10,123);
        System.out.println("输出原子整型类的交换结果："+ flag +"，输出交换结果值："+atomicInteger.get());

        //第二次比较交换时，主内存的值已经被修改。所以交换失败
        boolean flags =  atomicInteger.compareAndSet(10,321);
        System.out.println("输出原子整型类的交换结果："+ flags +"，输出交换结果值："+atomicInteger.get());

        atomicInteger.getAndIncrement();
    }

}
