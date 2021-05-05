/**
 * Copyright(c) 2018 asura
 */
package comm.study.gcdemo;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * <p></p>
 *  弱引用的 HashMap
 *    触发GC回收机制时，K V键值对 则被清理
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/21 5:17 下午
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myWeakHashMap();
    }

    /**
     * 传统的HashMap
     */
    public static void myHashMap(){
        HashMap<String,String> map = new HashMap<>();

        String key = new String("name");
        String value = "hashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    /**
     * 弱引用的HashMap
     */
    public static void myWeakHashMap(){
        WeakHashMap<String,String> map = new WeakHashMap<>();

        String key = new String("name");
        String value = "weakHashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}
