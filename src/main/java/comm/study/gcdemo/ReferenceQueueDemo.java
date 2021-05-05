/**
 * Copyright(c) 2018 asura
 */
package comm.study.gcdemo;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * 引用队列-针对软弱虚引用被GC前处理
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/22 4:37 下午
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(obj,referenceQueue);

        System.out.println(obj);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("========================");

        obj = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);


        System.out.println(obj);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());


    }
}
