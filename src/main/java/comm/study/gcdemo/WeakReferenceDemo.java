/**
 * Copyright(c) 2018 asura
 */
package comm.study.gcdemo;

import java.lang.ref.WeakReference;

/**
 * <p></p>
 *
 * 弱引用
 *   触发回收机制时，引用会被自动回收
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/21 4:53 下午
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object obj = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj);

        System.out.println(obj);
        System.out.println(weakReference.get());

        obj = null;
        System.gc();

        System.out.println("触发GC机制后-------------");

        System.out.println(obj);
        System.out.println(weakReference.get());
    }
}
