/**
 * Copyright(c) 2018 asura
 */
package comm.study.listmapdemo;

import com.sun.org.apache.bcel.internal.classfile.Constant;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p></p>
 *
 * 集合类不安全的问题
 * 原因：
 *  是因为多线程执行时，资源争抢并发导致。
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/11 4:21 下午
 */
public class ContainerNotSafeDemo {

    static List<String> arrayList = null;
    static Set<String> hashSet = null;
    static Map<String,String> hashMap = null;

    public static void main(String[] args) {
        hashMapNoSafedDemo();
    }

    /**
     * hashMap线程不安全演示
     */
    public static void hashMapNoSafedDemo(){
        if(hashMap == null){
            hashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < 10; i++) {
                new Thread(()->{
                    hashMap.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                    System.out.println(hashMap);
                },String.valueOf(i)).start();
            }
        }
    }
    /**
     * HashSet线程不安全并发演示
     */
    public static void hashsetDemo(){
        if(hashSet == null) {
            hashSet = new HashSet<>();
            for (int i = 1; i < 30; i++) {
                new Thread(() -> {
                    hashSet.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(hashSet);
                },String.valueOf(i)).start();
            }
        }

    }


    /**
     * ArrayList不安全并发演示
     */
    public static void arrayListDemo(){
        //lambda表达式写法
       /* if(arrayList == null){
            arrayList = Arrays.asList("a","b","c");
        }
        arrayList.forEach(System.out::println);*/
//        arrayList = new ArrayList<>();
//        arrayList = new Vector<>();
//        arrayList = Collections.synchronizedList(new ArrayList<>());
        arrayList = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() ->{
                arrayList.add(UUID.randomUUID().toString().substring(1,8));
                System.out.println(arrayList); // java.util.ConcurrentModificationException
            },String.valueOf(i)).start();
        }
    }
}
