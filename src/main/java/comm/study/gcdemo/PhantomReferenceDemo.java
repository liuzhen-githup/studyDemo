/**
 * Copyright(c) 2018 asura
 */
package comm.study.gcdemo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * <p></p>
 *
 * 虚引用一般配合 ReferenceQueue 引用队列使用，没有ReferenceQueue也一样可以运行。
 *  创建引用的时候可以指定关联的队列，当GC释放对象内存的时候，会将引用加入到引用队列，
 *  如果程序发现某个虚引用已经被加入到引用队列，那么就可以在锁引用的对象的内存被回收前采取必要的行动，等同于一种通知机制
 *
 *  当关联的引用队列中有数据的时候，意味者引用指向的堆内存中的对象被回收，通过这种方式，JVM允许我们在对象被销毁后，
 *  做一些我们自己想做的事情
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/22 4:49 下午
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj,referenceQueue);

        System.out.println(obj);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("-----------------------");

        obj = null;
        System.gc();

        System.out.println(obj);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());


    }
}
