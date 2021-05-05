/**
 * Copyright(c) 2018 asura
 */
package comm.study.gcdemo;

import java.lang.ref.SoftReference;

/**
 * <p></p>
 *
 * 软引用
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/21 3:40 下午
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        softRef_Memory_NoEnough();
    }

    /**
     * 内存够用的时候就保留，不否则GC回收
     */
    public static void softRef_Memory_Enough(){
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o);
        System.out.println(o);
        System.out.println(softReference.get());

        o = null;
        System.gc();

        System.out.println(o);
        System.out.println(softReference.get());
    }

    /**
     * JVM配置，故意产生大对象且配置小的运行内存，让其内存不够导致OOM，查看软引用的回收
     *  -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NoEnough(){
        Object obj = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(obj);
        System.out.println(obj);
        System.out.println(softReference.get());

        obj = null;
        System.gc();
        try{
            byte[] arrs = new byte[10 * 1024 * 1024];
            System.out.println(arrs);
        }catch (Throwable e){
            e.printStackTrace();
        } finally {
            System.out.println(obj);
            System.out.println(softReference.get());
        }

    }
}
