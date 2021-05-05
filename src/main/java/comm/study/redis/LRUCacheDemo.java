/**
 * Copyright(c) 2018 asura
 */
package comm.study.redis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * LRU算法
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/1 8:27 下午
 */
public class LRUCacheDemo<K,V> extends LinkedHashMap<K,V>{

    private int capacity = 0;

    public LRUCacheDemo(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo demo = new LRUCacheDemo(3);

        demo.put(1,"a");
        demo.put(2,"b");
        demo.put(3,"b");
        System.out.println(demo.keySet());

        demo.put(4,"d");
        System.out.println(demo.keySet());
        demo.put(3,"b");
        demo.put(5,"e");
        System.out.println(demo.keySet());
        demo.get(4);
        demo.get(3);
        demo.put(6,"f");
        System.out.println(demo.keySet());
    }
}
